package enemy;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import player.Player;
import player.PlayerState;
import sprite.GameConstant;
import sprite.Sprite;

public class Enemy extends Sprite implements GameConstant,EnemyState {
	 private int MoveRight = 0;
	 private int MoveLeft=0;
	 private int standLeft=0;
	 private int standRight= 0;
	 private int PunchRight=0;
	 private int PunchLeft=0;
	 private int KickLeft=0;
	 private int KickRight=0;
	 private int DieRight=0;
	 private int DieLeft=0;
	 private int currentState;
	 public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	private boolean move;
	 private int health;
	 private int RecoilRight;
	 private int RecoilLeft;
	 private int eflag;
	 
	public boolean isMove() {
		return move;
	}
	private int proximity;
	public void setProximity(int proximity) {
		this.proximity = proximity;
	}
	BufferedImage defaultRight[];
	BufferedImage defaultLeft[];
	BufferedImage moveRight[];
	BufferedImage moveLeft[];
	BufferedImage punchRight[];
	BufferedImage punchLeft[];
	BufferedImage kickRight[];
	BufferedImage kickLeft[];
	BufferedImage dieRight[];
	BufferedImage dieLeft[];
	BufferedImage recoilRight[];
	BufferedImage recoilLeft[];
	BufferedImage icon[];
	private boolean live;
	public boolean die;
	

	
	public boolean isDie() {
		return die;
	}
	public void setDie(boolean die) {
		this.die = die;
	}
	private void enemyLoader(String string) {
		EnemyLoader sloader = new EnemyLoader(string);
	
		defaultRight = sloader.standRight();
		defaultLeft = sloader.standLeft();
		moveRight = sloader.MoveRight();
		moveLeft = sloader.MoveLeft();
		punchRight = sloader.PunchRight();
		punchLeft = sloader.PunchLeft();
		kickRight = sloader.KickRight();
		kickLeft = sloader.Kickleft();
		dieRight=sloader.DieRight();
		dieLeft=sloader.DieLeft();
		recoilRight=sloader.recoilright();
		recoilLeft=sloader.recoilLeft();
		icon = sloader.icon();
	 }
	public Enemy(int x, String img){
		enemyLoader(img);
		this.x=x;
		health=100;
		this.h =200; this.w = 170;
		this.y=300;
		currentState=DEFAULT_STAND_LEFT;
		this.speed = 10;
		setLive(false);
		die=true;
		proximity=NEAR;
		eflag=1;
	}
	
	
	
public int getProximity() {
		return proximity;
	}
//	public void setProximity(int proximity) {
//		this.proximity = proximity;
//	}
private void drawDefaultImage(Graphics g){
		h=defaultRight[standRight].getHeight()*2;
		w=defaultRight[standRight].getWidth()*2;
		g.drawImage(defaultRight[standRight],x,y,w,h,null);
		
		standRight++;
		if(standRight>2){
			standRight=0;
		}
		
}
public void move(int speed) {
	x+=speed;
}
private void drawmoveright(Graphics g){
		w=moveRight[standRight].getHeight()*2;
		h=moveRight[MoveRight].getHeight()*2;
		g.drawImage(moveRight[MoveRight],x,y,w,h,null);
		
		MoveRight++;
		x +=speed;

		if(MoveRight>5){
			MoveRight=0;
			currentState = DEFAULT_STAND_RIGHT;
			standRight = 0;
			
		}
		
	}	
private void drawpunchright(Graphics g){
		w=punchRight[PunchRight].getWidth()*2;
		h=punchRight[PunchRight].getHeight()*2;
		g.drawImage(punchRight[PunchRight],x,y,w,h,null);
		move=true;
		PunchRight++;
		

		if(PunchRight>2){
			PunchRight=0;
			move=false;
			currentState=DEFAULT_STAND_RIGHT;
			standRight = 0;

			
		}
		
}
private void drawkickright(Graphics g) {
	w=kickRight[KickRight].getWidth()*2;
	h=kickRight[KickRight].getHeight()*2;
	g.drawImage(kickRight[KickRight],x,y,w,h,null);
	move=true;
	KickRight++;
	

	if(KickRight>3){
		KickRight=0;
		move=false;
		currentState=DEFAULT_STAND_RIGHT;
		standRight = 0;

		
	}

	
}
private void drawdieright(Graphics g) {
	w=dieRight[DieRight].getWidth()*2;
	h=dieRight[DieRight].getHeight()*2;
	g.drawImage(dieRight[DieRight],x,y,w,h,null);

	DieRight++;
	

	if(DieRight>8){
		
		live=false;
		
	}
}

private void drawDefaultImagem(Graphics g) {
	w=defaultLeft[standLeft].getWidth()*2;
	h=defaultLeft[standLeft].getHeight()*2;
	g.drawImage(defaultLeft[standLeft],x,y,w,h,null);
	move=true;
	standLeft++;
	if(standLeft>2){
		move=false;
		standLeft=0;
	}
	
}
private void drawmoveleft(Graphics g){
	w=moveLeft[MoveLeft].getWidth()*2;
	h=moveLeft[MoveLeft].getHeight()*2;
		g.drawImage(moveLeft[MoveLeft],x,y,w,h,null);
		move=true;
		MoveLeft++;
		x -=speed;

		if(MoveLeft>5){
			MoveLeft=0;
			move=false;
			currentState = DEFAULT_STAND_LEFT;
			standLeft = 0;
			
		}
		
	}
private void drawpunchleft(Graphics g){
	w=punchLeft[PunchLeft].getWidth()*2;
	h=punchLeft[PunchLeft].getHeight()*2;
	g.drawImage(punchLeft[PunchLeft],x,y,w,h,null);
	move=true;
	PunchLeft++;
	

	if(PunchLeft>2){
		PunchLeft=0;
		move=false;
		currentState=DEFAULT_STAND_LEFT;
		standLeft = 0;
	}	
		
}
private void drawkickleft(Graphics g) {
	w=kickLeft[KickLeft].getWidth()*2;
	h=kickLeft[KickLeft].getHeight()*2;
		g.drawImage(kickLeft[KickLeft],x,y,w,h,null);
		move=true;
		KickLeft++;
			

		if(KickLeft>3){
			KickLeft=0;
			move=false;
			currentState=DEFAULT_STAND_LEFT;
			standLeft = 0;	
		}
	}
private void drawdieleft(Graphics g) {
	w=dieLeft[DieLeft].getWidth()*2;
	h=dieLeft[DieLeft].getHeight()*2;
	g.drawImage(dieLeft[DieLeft],x,y,w,h,null);

	DieLeft++;
	

	if(DieLeft>8){
		setLive(false);

		
	}
	
}

public void drawrecoilleft(Graphics g ){
	
		w=recoilLeft[RecoilLeft].getWidth()*2;
		h=recoilLeft[RecoilLeft].getHeight()*2;
			g.drawImage(recoilLeft[RecoilLeft],x,y,w,h,null);
			move=true;
			RecoilLeft++;
			x +=50;
			
			if(RecoilLeft>2){
				RecoilLeft=0;
				move=false;
				currentState = DEFAULT_STAND_LEFT;
				standLeft = 0;
			
			}
			
		
}
public void drawrecoilright(Graphics g) {
	
	w=recoilRight[RecoilRight].getWidth()*2;
	h=recoilRight[RecoilRight].getHeight()*2;
		g.drawImage(recoilRight[RecoilRight],x,y,w,h,null);
		move=true;
		RecoilRight++;
		x -=50;
		
		if(RecoilRight>2){
			RecoilRight=0;
			move=false;
			currentState = DEFAULT_STAND_RIGHT;
			standRight = 0;
		
			
		}
		
	
}

public void draweIcon(Graphics g, int counter) {
	g.drawImage(icon[0], 20, 60+(counter*50),34,34,null);
	g.setColor(Color.GREEN);
	g.fillRect(60, 60+(counter*50), health, 10);
}
public void drawEnemy(Graphics g){
		
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
		else if(currentState==PUNCH_RIGHT){
			drawpunchright(g);
		}
		
		else if(currentState==PUNCH_LEFT){
			drawpunchleft(g);
		}
		
		else if(currentState==KICK_RIGHT){
			drawkickright(g);
		}
		else if(currentState==KICK_LEFT){
			drawkickleft(g);
		}
		else if(currentState==DIE_RIGHT){
			drawdieright(g);
		}
		else if(currentState==DIE_LEFT){
			drawdieleft(g);
		}
		else if(currentState==RECOIL_RIGHT){
			drawrecoilright(g);
		}
		else if(currentState==RECOIL_LEFT){
			drawrecoilleft(g);
		}
}

	
	
	public void moveRight(){
		currentState=DEFAULT_MOVE_RIGHT;
	}
	public void moveLeft(){
		currentState=DEFAULT_MOVE_LEFT;
	}
	public void standRight(){
		currentState=DEFAULT_STAND_RIGHT;
	}
	public void standLeft(){
		currentState=DEFAULT_STAND_LEFT;
	}
	public void moveUp(){
			y-=speed;
	}
	public void moveDown(){
			y+=speed;
	}
	public void punchRight() {
		currentState=PUNCH_RIGHT;
	}
	public void punchLeft() {
		currentState=PUNCH_LEFT;
	}
	public void kickRight() {
		currentState=KICK_RIGHT;
	}
	public void kickLeft() {
		currentState=KICK_LEFT;
	}
	public void dieRight() {
		currentState=DIE_RIGHT;
	}
	public void dieLeft() {
		currentState=DIE_LEFT;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void recoilleft() {
		currentState=RECOIL_LEFT;
	}
	public void recoilright() {
		currentState=RECOIL_RIGHT;
	}
	
	public void setProximity(Player player) {
		if(this.live) {
			
			
			if(Math.abs(player.getX()-x)>=450) {
				this.proximity=FAR;
			}
			else if(Math.abs(player.getX()-x)<600&&Math.abs(player.getX()-x)>205) {
				this.proximity=NEAR;
			}
			else if(Math.abs(player.getX()-x)<600&&Math.abs(player.getX()-x)<205) {
				this.proximity=CLOSE;
			}
		}
	}
	public void setState(Player player) {
		if(!die){
			
			if(proximity==FAR) {
				
				if((player.getX()-x)<0){
					standLeft();;
				}
				else {
					standRight();;
				}
			}
			else if(proximity==NEAR) {
				if(y<player.getY()) {
					moveDown();
				}else if(y>player.getY()) {
					moveUp();
				}
				if(x<player.getX()) {
					moveRight();
				}
				else if(x>player.getX()) {
					moveLeft();
				}
			}
			else if(proximity==CLOSE) {
				if(x<player.getX()) {
					if(eflag==1) {
						if(!isMove()){
							punchRight();
							eflag=2;
						}
					}
					else if(eflag==3){
						if(!isMove()){
							kickRight();
							eflag=1;
						}
					}
					else if(eflag==2) {
						if(!isMove()){
							moveRight();
							eflag=3;
						}
					}
				}
				else if(x>player.getX()) {
					if(eflag==1) {
						
						if(!isMove()){
							punchLeft();
							eflag=2;
						}
					}
					else if(eflag==3){
						if(!isMove()){
							kickLeft();
							eflag=1;
						}
					}
					else if(eflag==2) {
						if(!isMove()){
							moveLeft();
							eflag=3;
						}
					}
				}
			}
		}
	}
	public void collision(Player player,boolean isCollision) {
		if(!isDie()){		
			if(isCollision){
				if((player.getX()-x)<0) {
					if(player.getCurrentState()==PlayerState.PUNCH_RIGHT_1||player.getCurrentState()==PlayerState.PUNCH_RIGHT_2||player.getCurrentState()==PlayerState.KICK_RIGHT) {
						health-=50;
						recoilleft();
					}
				}
				else {
					if(player.getCurrentState()==PlayerState.PUNCH_LEFT_1||player.getCurrentState()==PlayerState.PUNCH_LEFT_2||player.getCurrentState()==PlayerState.KICK_LEFT) {
						health-=50;
						recoilright();
					}
				}
			}
		}		
	}
	
}
