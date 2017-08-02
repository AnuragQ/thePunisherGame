package enemy;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class EnemyLoader {
	BufferedImage img ;
	BufferedImage leftImg ;
	public EnemyLoader(String Enemy){
		
		loadSpriteSheet(Enemy+"m.png");
		loadSpriteSheetm(Enemy+".png");
	}
	private void loadSpriteSheetm(String string) {
		try {
			leftImg=ImageIO.read(EnemyLoader.class.getResource(string));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadSpriteSheet(String string) {
		try {
			img = ImageIO.read(EnemyLoader.class.getResource(string));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public BufferedImage[] icon() {
		BufferedImage bf[]  = new BufferedImage[1] ;
		bf[0]=img.getSubimage(486, 416, 24, 16);
		return bf;
	}
	public BufferedImage[] standRight(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = img.getSubimage(974, 44, 46, 84);
		bf[1] = img.getSubimage(894, 46, 51, 82);
		bf[2] = img.getSubimage(830, 45, 60, 83);
		return bf;
		
		
	}
	public BufferedImage[] MoveRight(){
		BufferedImage bf[]  = new BufferedImage[6];
		bf[0] = img.getSubimage(690, 43, 74, 79);
		bf[1] = img.getSubimage(593, 46, 64, 82);
		bf[2] = img.getSubimage(526, 44, 48, 84);
		bf[3] = img.getSubimage(275, 46, 74, 82);
		bf[4] = img.getSubimage(183, 47, 58, 81);
		bf[5] = img.getSubimage(97, 44, 50, 84);
		return bf;
		
		
	}
	public BufferedImage[] PunchRight(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = img.getSubimage(584, 173, 54, 83);
		bf[1] = img.getSubimage(473, 176, 98, 80);
		bf[2] = img.getSubimage(374, 179, 52, 77);
		
		return bf;
		
		
	}
	public BufferedImage[] KickRight(){
		BufferedImage bf[]  = new BufferedImage[4];
		bf[0] = img.getSubimage(943, 164, 69, 92);
		bf[1] = img.getSubimage(862, 166, 64, 90);
		bf[2] = img.getSubimage(766, 168, 94, 87);
		bf[3] = img.getSubimage(862, 166, 64, 90);

		
		return bf;
		
		
	}
	public BufferedImage[] DieRight(){
		BufferedImage bf[]  = new BufferedImage[9];
		bf[0] = img.getSubimage(750, 299, 48, 79);
		bf[1] = img.getSubimage(191, 176, 52, 80);
		bf[2] = img.getSubimage(510, 342, 96, 37);
		bf[3] = img.getSubimage(116, 364, 116, 20);
		bf[4] = img.getSubimage(564, 90, 1,1);
		bf[5] = img.getSubimage(564, 90, 1,1);
		bf[6] = img.getSubimage(116, 364, 116, 20);
		bf[7] = img.getSubimage(564, 90, 1,1);
		bf[8] = img.getSubimage(116, 364, 116, 20);

		
		return bf;
		
		
	}
	public BufferedImage[] DieLeft(){
		BufferedImage bf[]  = new BufferedImage[9];
		bf[0] = leftImg.getSubimage(224, 299, 48, 79);
		bf[1] = leftImg.getSubimage(779, 176, 52, 80);
		bf[2] = leftImg.getSubimage(416, 342, 96, 37);
		bf[3] = leftImg.getSubimage(641, 364, 116, 20);
		bf[4] = img.getSubimage(564, 90, 1,1);
		bf[5] = img.getSubimage(564, 90, 1,1);
		bf[6] = leftImg.getSubimage(641, 364, 116, 20);
		bf[7] = img.getSubimage(564, 90, 1,1);
		bf[8] = leftImg.getSubimage(641, 364, 116, 20);

		
		return bf;
		
		
	}
	public BufferedImage[] Kickleft(){
		BufferedImage bf[]  = new BufferedImage[4];
		bf[0] = leftImg.getSubimage(10, 164, 69, 92);
		bf[1] = leftImg.getSubimage(96, 166, 64, 90);
		bf[2] = leftImg.getSubimage(162, 168, 94, 87);
		bf[3] = leftImg.getSubimage(96, 166, 64, 90);

		
		return bf;
		
		
	}
	public BufferedImage[] PunchLeft(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = leftImg.getSubimage(384, 173, 54, 83);
		bf[1] = leftImg.getSubimage(451, 176, 98, 80);
		bf[2] = leftImg.getSubimage(576, 179, 52, 77);
		
		return bf;
		
		
	}
	public BufferedImage[] MoveLeft(){
		BufferedImage bf[]  = new BufferedImage[6];
		bf[0] = leftImg.getSubimage(258, 43, 74, 79);
		bf[1] = leftImg.getSubimage(365, 46, 64, 82);
		bf[2] = leftImg.getSubimage(448, 44, 48, 84);
		bf[3] = leftImg.getSubimage(673, 46, 74, 82);
		bf[4] = leftImg.getSubimage(781, 47, 58, 81);
		bf[5] = leftImg.getSubimage(875, 44, 50, 84);
		return bf;
		
		
	}
	public BufferedImage[] standLeft(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = leftImg.getSubimage(2, 44, 46, 84);
		bf[1] = leftImg.getSubimage(77, 46, 51, 82);
		bf[2] = leftImg.getSubimage(132, 45, 60, 83);
		
		return bf;
		
		
	}
	public BufferedImage[] recoilLeft(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = leftImg.getSubimage(705, 176, 43, 80);
		bf[1] = leftImg.getSubimage(779, 176, 52, 80);
		bf[2] = leftImg.getSubimage(836, 175, 60, 80);
		
		return bf;
		
		
	}
	public BufferedImage[] recoilright(){
		BufferedImage bf[]  = new BufferedImage[3];
		bf[0] = img.getSubimage(274, 176, 43, 80);
		bf[1] = img.getSubimage(191, 176, 52, 80);
		bf[2] = img.getSubimage(126, 175, 60, 80);
		
		return bf;
		
		
	}
	
}
