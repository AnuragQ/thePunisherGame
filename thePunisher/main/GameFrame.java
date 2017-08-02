package main;

import javax.swing.JFrame;

import sprite.GameConstant;



@SuppressWarnings("serial")
public class GameFrame extends JFrame implements GameConstant {
	public GameFrame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(TITLE);
		Board board = new Board();
		add(board);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GameFrame obj = new GameFrame();

	}

}
