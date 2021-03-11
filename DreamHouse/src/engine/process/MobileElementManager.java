package engine.process;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Wall;
import engine.mobile.Meuble;

 public class MobileElementManager {
	private Salon salon;
	private Wall wall = null;
	private Meuble meuble;
	private List<Case> wallZone = new ArrayList<Case>();


	public MobileElementManager(Salon salon) {
		this.salon = salon;
	}
	
	public void set(Meuble meuble) {
		this.meuble = meuble ;
	}
   
	
    
	
	public void putWall(Case position) {
		

			
				 wall = new Wall(position);
				 int line = position.getLigne();
				int column = position.getColone();
				 wallZone.add(salon.getCase(line, column));
				
				
	}
	public void moveLeftMeuble() {
		Case position = meuble.getPosition();

		if (position.getColone() > 0) {
			Case newPosition = salon.getCase(position.getLigne(), position.getColone() - 1);
			meuble.setPosition(newPosition);
		}

	}

	public void moveRightMeuble() {
		Case position = meuble.getPosition();

		if (position.getColone() < HouseConfig.COLUMN_COUNT - 1) {
			Case newPosition = salon.getCase(position.getLigne(), position.getColone() + 1);
			meuble.setPosition(newPosition);
		}
	}
	
	public void moveTopMeuble() {
		Case position = meuble.getPosition();

		if (position.getLigne() > 0) {
			Case newPosition = salon.getCase(position.getLigne() -1 , position.getColone() );
			meuble.setPosition(newPosition);
		}
	}
	
	public void moveBotMeuble() {
		Case position = meuble.getPosition();

		if (position.getLigne() < HouseConfig.LIGNE_COUNT - 1) {
			Case newPosition = salon.getCase(position.getLigne() +1 , position.getColone() );
			meuble.setPosition(newPosition);
		}
	}
	
	public Wall getWall() {
			return wall;
			
	}
	public List<Case> getWallZone() {
		return wallZone;
	}
	public Meuble getMeuble() {
		return meuble;
	}
	public void pivoter() {
		int z ;
		z=meuble.getLongueurMeuble();
		meuble.setLongueurMeuble(meuble.getLargeurMeuble());
		meuble.setLargeurMeuble(z);
		if (meuble.getApparence()<3 ) {
			meuble.incrementApparence();
		}
		else {
			meuble.setApparence(0);
		}
	}

	
}
