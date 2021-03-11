package gui;

import java.awt.BasicStroke;
import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

	import config.HouseConfig;
	import engine.map.Case;
	import engine.map.Salon;
	import engine.mobile.Wall;
import engine.process.SimulationUtility;
import engine.mobile.Meuble;
	import engine.mobile.MobileElement;


public class Paint {
	
	
	
		public void paint(Salon salon, Graphics graphics) {
			int blockSize = HouseConfig.CASE_SIZE;
			Case[][] blocks = salon.getCases();

			for (int lineIndex = 0; lineIndex < salon.getLigneMax(); lineIndex++) {
				for (int columnIndex = 0; columnIndex < salon.getColoneMax(); columnIndex++) {
					Case block = blocks[lineIndex][columnIndex];

					if ((lineIndex + columnIndex) % 2 == 0) {
						graphics.setColor(Color.LIGHT_GRAY);
						graphics.fillRect(block.getColone() * blockSize, block.getLigne() * blockSize, blockSize, blockSize);
					}
				}
			}
		}

	
		
		public void paint(List<Case> wallZone, Graphics graphics) {
			for (Case block : wallZone) {

				int blockSize = HouseConfig.CASE_SIZE;

				int y = block.getLigne();
				int x = block.getColone();

				graphics.setColor(Color.BLACK);
				graphics.fillRect((x * blockSize), y * blockSize, blockSize, blockSize);
			}

		}
		public void printMeuble(Meuble meuble, Graphics2D g2) {
			Case position = meuble.getPosition();
			int blockSize = HouseConfig.CASE_SIZE;

			int y = position.getLigne();
			int x = position.getColone();
			
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(6));

			
			g2.drawImage(SimulationUtility.readImage("src/Images/lit"+meuble.getApparence()+".png"),x * blockSize , y * blockSize  , meuble.getLargeurMeuble(), meuble.getLongueurMeuble(), null);
			
		}
		
	}


