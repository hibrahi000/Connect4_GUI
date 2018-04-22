import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GHeader extends JPanel {



	private JLabel lblForGame, lblConnectType;
	private JButton btnChangeGame, btnClear, btnGReset;
	
	public static int x = 4;
	private String GameType = "Connect 4";
	private ActionListener clear;
	private ActionListener reset;
	
	public int getX() {
		return x;
	}
	public GHeader() {
	
		this.setBorder(BorderFactory.createLineBorder(Color.black,5));
		
		this.setLayout(new FlowLayout());
		
			this.setBackground(Color.cyan);
			
			
			
			 lblForGame = new JLabel("GAME TYPE:");
			 lblConnectType = new JLabel(GameType);
			
			btnChangeGame = new JButton("Change Game Type");
			btnClear = new JButton("Clear Board");
			btnGReset = new JButton("RESET GAME");
			this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			this.add(lblForGame);
			this.add(lblConnectType);
			this.add(btnChangeGame);
			this.add(btnClear);
			this.add(btnGReset);
			

			//Change font Aspects for header
			JLabel [] headerInfo = {lblForGame, lblConnectType};
			for(int i =0; i<headerInfo.length;i++) {
				headerInfo[i].setFont(new Font( Font.SERIF,Font.BOLD,20));
			   
			}
			
			
			
			//______________________________ Change game button action
		btnChangeGame.addActionListener(new ActionListener() {
			@Override
			
				public void actionPerformed(ActionEvent e) {
					JFrame gameSelect = new JFrame();
					gameSelect.setSize(500,500);
					gameSelect.setBackground(Color.LIGHT_GRAY);
					gameSelect.setLayout(new GridLayout(2,0));
					gameSelect.setSize(1000, 100);
					
					JPanel games = new JPanel(new GridLayout(1,4));
					JLabel instructions = new JLabel("           Select the ConnectX game you want to play.");
					instructions.setForeground(Color.black);
					instructions.setFont(new Font(Font.MONOSPACED,Font.ITALIC,25));
					instructions.setAlignmentX(CENTER_ALIGNMENT);
					gameSelect.setVisible(true);
					
					
					JButton Connect3, Connect4, Connect5, Connect6;
					
					Connect3 = new JButton("Connect 3");
					Connect3.addActionListener(new ActionListener() {
					
						@Override
						public void actionPerformed(ActionEvent e) {			
							
							x = 3;
							GameType = "Connect "+x;
							lblConnectType.setText(GameType);
							gameSelect.dispose();				
						}
					});
			
					
					Connect4 = new JButton("Connect 4");
					Connect4.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						x  = 4;
						GameType = "Connect "+x;
						lblConnectType.setText(GameType);
						gameSelect.dispose();
						
						}
					});
					
					Connect5 = new JButton("Connect 5");
					Connect5.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {				
						x =5;
						GameType = "Connect "+x;
						lblConnectType.setText(GameType);
						gameSelect.dispose();
						}
					});
					
					Connect6 = new JButton("Connect 6");
					Connect6.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						x = 6;
						GameType = "Connect "+x;
						lblConnectType.setText(GameType);
						gameSelect.dispose();
						
						}
					});
					
					games.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
					
					games.add(Connect3);
					games.add(Connect4);
					games.add(Connect5);
					games.add(Connect6);
					
					gameSelect.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
					
					gameSelect.add(instructions);
					gameSelect.add(games);
					
					
					
					
					
					
				}
				
				
			});		
		
		btnClear.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            C4B.clearBoard();
	            
	        }
	    });
		
		 btnGReset.addActionListener(new ActionListener()
		 {

		        @Override
		        public void actionPerformed(ActionEvent arg1) {
		            C4B.clearBoard();
		            SB.setP1Score(0);
		            SB.setP2Score(0);
		            
		        }
		    });
				 
				
		
		}
	
	}
	

