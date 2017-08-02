package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sprite.GameConstant;

public class Camera implements GameConstant {
	BufferedImage bi;
	int speed;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	int x;
	int y=BG_H-GAME_HEIGHT;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	private void movelr(){
		x+=speed;
	}
	private void moveud(){
		y+=speed;
	}
	public void left(){
		if(x>10){
		speed = -10;
		movelr();
		}
	}
	public void right(){
		
		//System.out.println("X is "+x+" "+(960-GAME_WIDTH));
		if(x<(BG_W-(GAME_WIDTH))){
			speed  = 10;
			movelr();
		}
	}
	public void up(){
		if(y>10){
			speed=-10;
			moveud();
		}
	}
	public void down(){
		if(y<BG_H-GAME_HEIGHT){
			speed=10;
			moveud();
		}
	}
	public void drawBG(Graphics g){
		BufferedImage subI = bi.getSubimage(x, y, GAME_WIDTH, GAME_HEIGHT);
		g.drawImage(subI,0,0,GAME_WIDTH,GAME_HEIGHT,null);
		
	}
	public Camera(){
		
			
		try {
			bi  = ImageIO.read(Camera.class.getResource(BG_IMG));
		} catch (IOException e) {
			System.out.println("Background not found ");
			//e.printStackTrace();
		}
		
		}
	
}
