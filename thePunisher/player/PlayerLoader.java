package player;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerLoader {
	BufferedImage img ;
	BufferedImage leftImg ;
	public PlayerLoader(){
		loadSpriteSheet();
		loadSpriteSheetm();
	}
	
	public BufferedImage[] icon() {
		BufferedImage bf[]  = new BufferedImage[1] ;
		bf[0]=leftImg.getSubimage(809, 63, 24, 24);
		return bf;
	}
	
	public BufferedImage[] standRight(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = img.getSubimage(35, 29, 75, 86);
		bf[1] = img.getSubimage(117, 30, 74, 85);
		bf[2] = img.getSubimage(197, 31, 73, 84);
		return bf;
		
		
	}
	public BufferedImage[] moveRight(){
		BufferedImage bf[] =new BufferedImage[12];
		bf[0] = img.getSubimage(24,137, 77, 85);
		bf[1] = img.getSubimage(113, 137, 77, 85);
		bf[2] = img.getSubimage(201, 138, 72, 84);
		bf[3] = img.getSubimage(285, 136, 65, 86);
		bf[4] = img.getSubimage(357, 136, 67, 86);
		bf[5] = img.getSubimage(426, 137, 73, 85);
		bf[6] = img.getSubimage(504, 137, 85, 85);
		bf[7] = img.getSubimage(597, 137, 81, 85);
		bf[8] = img.getSubimage(685, 136, 68, 86);
		bf[9] =  img.getSubimage(760, 135, 66, 87);
		bf[10] = img.getSubimage(830, 135,71, 87);
		bf[11]= img.getSubimage(909, 136, 78, 86);
		return bf;
	}
	public BufferedImage[] punchRight(){
		BufferedImage bf[] =new BufferedImage[11];
		bf[0] = img.getSubimage(25,251, 76, 88);
		bf[1] = img.getSubimage(108, 251, 104, 88);
		bf[2] = img.getSubimage(222, 251, 88, 88);
		bf[3] = img.getSubimage(322, 251, 80, 88);
		bf[4] = img.getSubimage(419, 251, 76, 88);
		bf[5] = img.getSubimage(511, 254, 67, 89);
		bf[6] = img.getSubimage(597, 255, 67, 88);
		bf[7] = img.getSubimage(682, 258, 96, 85);
		bf[8] =  img.getSubimage(790, 256, 83, 87);
		bf[9] = img.getSubimage(884, 255,67, 88);
		bf[10]= img.getSubimage(963, 254, 67, 89);
		return bf;
	}
	public BufferedImage[] kickRight(){
		BufferedImage bf[] =new BufferedImage[8];
		bf[0] = img.getSubimage(25,378, 73, 84);
		bf[1] = img.getSubimage(114, 374, 68, 88);
		bf[2] = img.getSubimage(207, 377, 60, 85);
		bf[3] = img.getSubimage(297, 369, 84, 92);
		bf[4] = img.getSubimage(402, 377, 92, 84);
		bf[5] = img.getSubimage(505, 371, 71, 89);
		bf[6] = img.getSubimage(590, 369, 40, 91);
		bf[7] = img.getSubimage(645, 394, 72, 65);
		
		return bf;
	}
	
	public BufferedImage[] standLeft(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = leftImg.getSubimage(1136, 29, 75, 86);
		bf[1] = leftImg.getSubimage(1055, 30, 74, 85);
		bf[2] = leftImg.getSubimage(976, 31, 73, 84);
		
		return bf;
		
		
	}

	public BufferedImage[] moveLeft(){
		BufferedImage bf[] =new BufferedImage[12];
		bf[0] = leftImg.getSubimage(1145, 137, 77, 85);
		bf[1] = leftImg.getSubimage(1056, 137, 77, 85);
		bf[2] = leftImg.getSubimage(971, 138, 72, 84);
		bf[3] = leftImg.getSubimage(896, 136, 65, 86);
		bf[4] = leftImg.getSubimage(822, 136, 67, 86);
		bf[5] = leftImg.getSubimage(747, 137, 73, 85);
		bf[6] = leftImg.getSubimage(657, 137, 85, 85);
		bf[7] = leftImg.getSubimage(568, 137, 81, 85);
		bf[8] = leftImg.getSubimage(493, 136, 68, 86);
		bf[9] =  leftImg.getSubimage(420, 135, 66, 87);
		bf[10] = leftImg.getSubimage(345, 135,71, 87);
		bf[11]= leftImg.getSubimage(259, 135, 78, 86);
		return bf;
	}
	public BufferedImage[] punchLeft(){
		BufferedImage bf[] =new BufferedImage[11];
		bf[0] = leftImg.getSubimage(1154,251, 76, 88);
		bf[1] = leftImg.getSubimage(1034, 251, 104, 88);
		bf[2] = leftImg.getSubimage(936, 251, 88, 88);
		bf[3] = leftImg.getSubimage(844, 251, 80, 88);
		bf[4] = leftImg.getSubimage(751, 251, 76, 88);
		bf[5] = leftImg.getSubimage(668, 254, 67, 89);
		bf[6] = leftImg.getSubimage(582, 255, 67, 88);
		bf[7] = leftImg.getSubimage(468, 258, 96, 85);
		bf[8] =  leftImg.getSubimage(373, 256, 83, 87);
		bf[9] = leftImg.getSubimage(295, 255,67, 88);
		bf[10]= leftImg.getSubimage(216, 254, 67, 89);
		return bf;
	}
	public BufferedImage[] kickLeft(){
		BufferedImage bf[] =new BufferedImage[8];
		bf[0] = leftImg.getSubimage(1148,378, 73, 84);
		bf[1] = leftImg.getSubimage(1064, 374, 68, 88);
		bf[2] = leftImg.getSubimage(979, 377, 60, 85);
		bf[3] = leftImg.getSubimage(865, 369, 84, 92);
		bf[4] = leftImg.getSubimage(752, 377, 92, 84);
		bf[5] = leftImg.getSubimage(670, 371, 71, 89);
		bf[6] = leftImg.getSubimage(616, 369, 40, 91);
		bf[7] = leftImg.getSubimage(529, 394, 72, 65);
		
		return bf;
	}
	
	public void loadSpriteSheet(){
		try {
			img = ImageIO.read(PlayerLoader.class.getResource("player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadSpriteSheetm(){
			try {
				leftImg = ImageIO.read(PlayerLoader.class.getResource("playerm.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}


}