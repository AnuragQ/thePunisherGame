package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import enemy.Enemy;
import enemy.EnemyState;
import main.Camera;
import sprite.GameConstant;
import sprite.Sprite;

public class Player extends Sprite implements GameConstant,PlayerState {
	private int acc;
	private int currentState;
	private int health;
	private boolean live;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isDie() {
		return die;
	}

	public void setDie(boolean die) {
		this.die = die;
	}

	private boolean die;

	 public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	int MoveRight = 0;
	 int MoveLeft=0;
	 int standLeft=0;
	 int standRight= 0;
	 int PunchRight=0;
	 int PunchLeft=0;
	 int KickLeft=0;
	 int KickRight=0;
	 

//	 public void checkfloor() {
//		 if((x>250&&x<645)&&(floor<565&&floor>452)) {
//			 floor=452;
//		 }
//	 }
//	 

	private boolean isJump=false;
	
	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	PlayerLoader sloader = new PlayerLoader();
	BufferedImage defaultRight[] = sloader.standRight();
	BufferedImage defaultLeft[] = sloader.standLeft();
	BufferedImage moveRight[] = sloader.moveRight();
	BufferedImage moveLeft[] = sloader.moveLeft();
	BufferedImage punchRight[] = sloader.punchRight();
	BufferedImage punchLeft[] = sloader.punchLeft();
	BufferedImage kickRight[] = sloader.kickRight();
	BufferedImage kickLeft[] = sloader.kickLeft();
	BufferedImage icon[] = sloader.icon();
	private boolean tableflag;

	
	

	public Player(){
		currentState = DEFAULT_STAND_RIGHT;
		speed = 30;
		x =50;
		tableflag=false;

		floor=GAME_HEIGHT-300;
		h = 200;
		w = 170;
		setHealth(400);
		acc=-25;
		fspeed=10;
	}

	public void fall(){
		if(y<(floor )){
			acc = acc + GRAVITY;
			y += acc;
		}
		if(y>= floor){
			y  =floor;
			isJump = false;
		}
		if(!isJump) {
			acc=0;
		}
	}
	

	
	
	
	public void jump(){
		if(!isJump){
		// acc = 15;
			acc=-80;

			isJump = true;
			y+=acc;
			

		}
	}
	
	public void moveRight(){
		currentState=DEFAULT_MOVE_RIGHT;
	}
	public void moveLeft(){
		currentState=DEFAULT_MOVE_LEFT;
	}
	public void moveUp(){
			floor-=fspeed;
	}
	public void moveDown(){
			floor+=fspeed;
	}
	public void punchRight_1() {
		currentState=PUNCH_RIGHT_1;
	}
	public void punchLeft_1() {
		currentState=PUNCH_LEFT_1;
	}
	public void punchRight_2() {
		currentState=PUNCH_RIGHT_2;
	}
	public void punchLeft_2() {
		currentState=PUNCH_LEFT_2;
	}
	public void kickRight() {
		currentState=KICK_RIGHT;
	}
	public void kickLeft() {
		currentState=KICK_LEFT;
	}

	
	private void drawDefaultImage(Graphics g){
		h=defaultRight[standRight].getHeight()*2;
		w=defaultRight[standRight].getWidth()*2;
		g.drawImage(defaultRight[standRight],x,y,w,h,null);
		
		
		standRight++;
		if(standRight>2){
			standRight=0;
		}
		
}
	private void drawmoveright(Graphics g){
		w=defaultRight[standRight].getHeight()*2;
		h=moveRight[MoveRight].getHeight()*2;
		g.drawImage(moveRight[MoveRight],x,y,w,h,null);
		
		MoveRight++;
		x +=speed;

		if(MoveRight>11){
			MoveRight=0;
			currentState = DEFAULT_STAND_RIGHT;
			standRight = 0;
			
		}
		
	}	
private void drawpunchright_1(Graphics g){
		w=punchRight[PunchRight].getWidth()*2;
		h=punchRight[PunchRight].getHeight()*2;
		g.drawImage(punchRight[PunchRight],x,y,w,h,null);
		
		PunchRight++;
		

		if(PunchRight>5){
			PunchRight=0;
			currentState=DEFAULT_STAND_RIGHT;
			standRight = 0;

			
		}
		
}
private void drawpunchright_2(Graphics g){
	w=punchRight[PunchRight+5].getWidth()*2;
	h=punchRight[PunchRight+5].getHeight()*2;
	g.drawImage(punchRight[PunchRight+5],x,y,w,h,null);
	
	PunchRight++;
	

	if(PunchRight>5){
		PunchRight=0;
		currentState=DEFAULT_STAND_RIGHT;
		standRight = 0;

		
	}
	
}
public void drawpIcon(Graphics g) {
	g.drawImage(icon[0], 20, 20,34,34,null);
	g.setColor(Color.GREEN);
	g.fillRect(54, 20,health, 15);
}
private void drawkickright(Graphics g) {
	w=kickRight[KickRight].getWidth()*2;
	h=kickRight[KickRight].getHeight()*2;
	g.drawImage(kickRight[KickRight],x,y,w,h,null);
	KickRight++;
	

	if(KickRight>7){
		KickRight=0;
		currentState=DEFAULT_STAND_RIGHT;
		standRight = 0;

		
	}

	
}

private void drawDefaultImagem(Graphics g) {
	w=defaultLeft[standLeft].getWidth()*2;
	h=defaultLeft[standLeft].getHeight()*2;
	g.drawImage(defaultLeft[standLeft],x,y,w,h,null);
	
	standLeft++;
	if(standLeft>2){
		standLeft=0;
	}
	
}
private void drawmoveleft(Graphics g){
	w=moveLeft[MoveLeft].getWidth()*2;
	h=moveLeft[MoveLeft].getHeight()*2;
		g.drawImage(moveLeft[MoveLeft],x,y,w,h,null);
		
		MoveLeft++;
		x -=speed;

		if(MoveLeft>11){
			MoveLeft=0;
			
			currentState = DEFAULT_STAND_LEFT;
			standLeft = 0;
			
		}
		
	}
private void drawpunchleft_1(Graphics g){
	w=punchLeft[PunchLeft].getWidth()*2;
	h=punchLeft[PunchLeft].getHeight()*2;
	g.drawImage(punchLeft[PunchLeft],x,y,w,h,null);
	
	PunchLeft++;
	

	if(PunchLeft>5){
		PunchLeft=0;
		currentState=DEFAULT_STAND_LEFT;
		standLeft = 0;
	}	
		
}
private void drawpunchleft_2(Graphics g){
	w=punchLeft[PunchLeft+5].getWidth()*2;
	h=punchLeft[PunchLeft+5].getHeight()*2;
	g.drawImage(punchLeft[PunchLeft+5],x,y,w,h,null);
		
	PunchLeft++;
		

	if(PunchLeft>5){
		PunchLeft=0;
		currentState=DEFAULT_STAND_LEFT;
		standLeft = 0;	
			
}
	
}
private void drawkickleft(Graphics g) {
	w=kickLeft[KickLeft].getWidth()*2;
	h=kickLeft[KickLeft].getHeight()*2;
		g.drawImage(kickLeft[KickLeft],x,y,w,h,null);
		KickLeft++;
			

		if(KickLeft>7){
			KickLeft=0;
			currentState=DEFAULT_STAND_LEFT;
			standLeft = 0;	
		}
	}


	
	public void drawPlayer(Graphics g){
		
		if(currentState == DEFAULT_STAND_RIGHT){
			drawDefaultImage(g);
		}
		else if(currentState==DEFAULT_MOVE_RIGHT){	
			drawmoveright(g);
			//x +=speed;

		}
		else if(currentState==DEFAULT_MOVE_LEFT){
			drawmoveleft(g);
		}
		else if(currentState==DEFAULT_STAND_LEFT){
			drawDefaultImagem(g);
		}
		else if(currentState==PUNCH_RIGHT_1){
			drawpunchright_1(g);
		}
		else if(currentState==PUNCH_RIGHT_2){
			drawpunchright_2(g);
		}
		else if(currentState==PUNCH_LEFT_1){
			drawpunchleft_1(g);
		}
		else if(currentState==PUNCH_LEFT_2){
			drawpunchleft_2(g);
		}
		else if(currentState==KICK_RIGHT){
			drawkickright(g);
		}
		else if(currentState==KICK_LEFT){
			drawkickleft(g);
		}
}

	

	public void setDefault() {
		if(currentState==DEFAULT_MOVE_RIGHT)
			currentState=DEFAULT_STAND_RIGHT;
		else if(currentState==DEFAULT_MOVE_LEFT)
			currentState=DEFAULT_STAND_LEFT;
		
		
			
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void collision(Enemy enemy, boolean collision) {
		if(!isDie()){		
			if(collision){
				if((x-enemy.getX())<0) {
					if(enemy.getCurrentState()==EnemyState.PUNCH_LEFT||enemy.getCurrentState()==EnemyState.KICK_LEFT) {
						health-=50;
						recoilright();
					}
				}
				else {
					if(enemy.getCurrentState()==EnemyState.PUNCH_RIGHT||enemy.getCurrentState()==EnemyState.KICK_RIGHT) {
						health-=50;
						recoilleft();
					}
				}
			}
		}		
	}

	private void recoilright() {
		// TODO Auto-generated method stub
		x-=50;
	}

	private void recoilleft() {
		// TODO Auto-generated method stub
		x+=50;
	}

	public boolean setfloor(Camera camera, boolean tableflag2) {
		
			int f=floor;
			
			if(tableflag2) {
				if( (y<150+((BG_H-GAME_HEIGHT)-camera.getY()))&&(x<(647-camera.getX())&&x>(251-camera.getX()-w))) {
					floor=(120+(BG_H-GAME_HEIGHT)-camera.getY());
					tableflag=true;
				
				}
				else {
				
			
					if(!tableflag)
					{
						floor=(f);
					}
					else{
						floor=(220+(BG_H-GAME_HEIGHT)-camera.getY());
						tableflag=false;
					}
				}
				if(isJump==false&&tableflag==false){
					tableflag2=false;
				}
			}else
			{
				if((y<240+((BG_H-GAME_HEIGHT)-camera.getY()))&&(x<(647-camera.getX())&&x>(251-camera.getX()-w))) {
					floor=(240+((BG_H-GAME_HEIGHT)-camera.getY()));
				}
			}
			
			
		return tableflag2;
		
	}

	
	

	

}

