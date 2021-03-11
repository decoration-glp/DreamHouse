package test;
import gui.MainGUI;

public class TestHouse {

	
	
		public static void main(String[] args) {

			MainGUI gameMainGUI = new MainGUI("MY DREAM HOUSE");

			Thread gameThread = new Thread(gameMainGUI);
			gameThread.start();

		}
	

}
