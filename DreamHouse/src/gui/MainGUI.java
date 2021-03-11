package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;

import engine.process.MapBuilder;
import engine.process.MobileElementManager;






public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Salon salon;

	private final static Dimension preferredSize = new Dimension(HouseConfig.WINDOW_WIDTH,HouseConfig.WINDOW_HEIGHT);

	private MobileElementManager manager;

	private MapDisplay dashboard;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);
		JLabel lblNewLabel_1 = new JLabel("left click : cr�e un mur | I : inserer un objet | P : pivoter | S : supprimer ");
		
		contentPane.add(lblNewLabel_1, BorderLayout.NORTH);
		salon = MapBuilder.buildSalon();
		manager = MapBuilder.buildInitMobile(salon);
		dashboard = new MapDisplay(salon, manager);

		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(HouseConfig.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			
			dashboard.repaint();
		}
	}
	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
				manager.moveLeftMeuble();
				break;
			case 'd':
				manager.moveRightMeuble();
				break;
			case 'z':
				manager.moveTopMeuble();
				break;
			case 's':
				manager.moveBotMeuble();
				break;
			case 'p':
				manager.pivoter();
				break;
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}


	
	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX() ;
			int y = e.getY();

			Case bombPosition = dashboard.getWallPosition(x, y);
			manager.putWall(bombPosition);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

}


