package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import enemy.Enemy;
import player.Player;
import player.PlayerState;
import sprite.GameConstant;

@SuppressWarnings("serial")
public class Board extends JPanel implements GameConstant{
	Image bg;
	Player player;
	Enemy enemy[]=new Enemy[MAX_ENEMY];
	Timer timer;
	Camera camera;
	long counter;
	private int punchflag;
	
	private int noOfEnemies;

	private boolean tableflag2;
	
	
	public Board(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		player = new Player();
		noOfEnemies=3;
		prepareEnemies();
		punchflag=1;
		tableflag2=false;
		camera = new Camera();
		setFocusable(true);
		bindEvents();
		
		gameLoop();
		
	}
	private void prepareEnemies() {
		for(int i=0;i<noOfEnemies;i++) {
			enemy[i]=new Enemy(600+i*100,ENEMY1);
		}
	}
	private void setProximity() {
		
		for(int i=0;i<noOfEnemies;i++) {
			enemy[i].setProximity(player);;
		}
	}
	
	

	
	private void bindEvents(){
		
		this.addKeyListener(new KeyAdapter() {
			
			
			@Override
			
			
			
			public void keyPressed(KeyEvent e){
				
				
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
						player.moveRight();
						
						camera.right();
						if(camera.getX()<(BG_W-(GAME_WIDTH))){
						moveEnemy(-10);
						}
						
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
						player.moveLeft();
						if(camera.getX()>10){
						moveEnemy(10);
						}
						camera.left();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
						player.moveUp();
						camera.up();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
						player.moveDown();
						camera.down();
				}
				if(e.getKeyCode()==KeyEvent.VK_W){
					player.jump();
					tableflag2=true;
					
				}
				if(e.getKeyCode()==KeyEvent.VK_D){
					if(player.getCurrentState()==PlayerState.DEFAULT_STAND_RIGHT) {
						if(punchflag==1) {
					
						player.punchRight_1();
						punchflag=2;
						}
					
						else if(punchflag==2) {
							player.punchRight_2();
							punchflag=1;
						}
					}
					else if(player.getCurrentState()==PlayerState.DEFAULT_STAND_LEFT) {
						if(punchflag==1) {
							player.punchLeft_1();
							punchflag=2;
						}
						else if(punchflag==2) {
							player.punchLeft_2();
							punchflag=1;
						}
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_A){
					if(player.getCurrentState()==PlayerState.DEFAULT_STAND_RIGHT) {
						player.kickRight();
						
						
					}
					else if(player.getCurrentState()==PlayerState.DEFAULT_STAND_LEFT) {
						
							player.kickLeft();
							
						}
			}
					
					
				
				
			}
			public void keyReleased(KeyEvent e) { 
				if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_D){
					player.setDefault();;
				}
			}
		}
		
	);
	}
	protected void moveEnemy(int speed) {
		for(int i=0;i<noOfEnemies;i++) {
			if(enemy[i].isLive()) {
				enemy[i].move(speed);
			}
		}
		
	}

	private void gameLoop(){
		timer= new Timer(GAME_SPEED, (e)->{
			player.fall();
			setProximity();
			tableflag2=player.setfloor(camera,tableflag2);
			checkVerticalLimit();
			setEnemyState();
			checkCollision();
			checkEnemyHealth();
			System.out.println(player.getY());
			//checkPlayerHealth();
			getEnemies(counter);
			counter++;
			repaint();
			
			
				
				
		});
		timer.start();
	}
	private void checkEnemyHealth() {
		for(int i=0;i<noOfEnemies;i++) {
			if(enemy[i].getHealth()==0) {
				enemy[i].die=true;
				
				if((player.getX()-enemy[i].getX())<=0)
					
					enemy[i].dieLeft();
				
				else
					enemy[i].dieRight();
			}
		}
		
	}
	private void getEnemies(long counter2) {
		if(counter==90)
		{	enemy[0].setLive(true);
			enemy[0].setDie(false);
		}
		if(counter==110) {
			enemy[1].setLive(true);
			enemy[1].setDie(false);
		}
		if(counter==140) {
			enemy[2].setLive(true);
			enemy[2].setDie(false);
		}
	}
	private void setEnemyState() {
		for(int i=0;i<noOfEnemies;i++) {
			enemy[i].setState(player);
		}
	}
	private void checkVerticalLimit() {
		if((player.getY()<195+((BG_H-GAME_HEIGHT)-camera.getY()))&&(!(player.getX()<(647-camera.getX())&&player.getX()>(251-camera.getX()-player.getW()))) ){
				player.setFloor(195+((BG_H-GAME_HEIGHT)-camera.getY()));
			}
	}
	
	public boolean isCollision(Player player, Enemy enemy){
		Rectangle one = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
		Rectangle two = new Rectangle(enemy.getX(), enemy.getY(), enemy.getW(), enemy.getH());
		//checkEnemyHealth();
		return one.intersects(two);
	}
	private void checkCollision() {
		for(int i=0;i<noOfEnemies;i++) {
			player.collision(enemy[i],isCollision(player,enemy[i]))	;		
			enemy[i].collision(player,isCollision(player,enemy[i]));
		}
	}
	

//	int counter;
//	private void score(){
//		counter++;
//		
//	}
	
//	boolean isGameOver = false;
//	public void checkCollision(){
//		for(Enemy enemy: enemies){
//			if(isCollision(player, enemy)){
//				isGameOver = true;
//				//repaint();
//				//timer.stop();
//			}
//		}
//	}
	

	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		camera.drawBG(g);
		player.drawPlayer(g);
		drawEnemies(g);
		player.drawpIcon(g);
		enemyIcon(g);
		
			
		
		
		
//		if(isGameOver){
//			gameOver(g);
//			return;
//		}
		
		
		//drawEnemies(g);
	//	g.setColor(Color.RED);
	//	g.drawString("Score "+counter, GAME_WIDTH-200, 70);
	}
private void enemyIcon(Graphics g) {
	int counter1=0;
	for(int i=0;i<noOfEnemies;i++) {
		if(enemy[i].isLive()&&(enemy[i].getProximity()==CLOSE) )
		{	counter1++;
			enemy[i].draweIcon(g,counter1);
		}
	}
}
private void drawEnemies(Graphics g) {

	for(int i=0;i<noOfEnemies;i++) {
		if(enemy[i].isLive()){
			enemy[i].drawEnemy(g);
		}
	}
	
}
	
//	public void gameOver(Graphics g){
//		g.setColor(Color.RED);
//		g.setFont(new Font("Arial",Font.BOLD,40));
//		g.drawString("Game Over", GAME_WIDTH/2, GAME_HEIGHT/2);
//	}
//	

}
