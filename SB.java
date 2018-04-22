import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SB {
		


//Player1 
private static JLabel lblForPlayer1Names;

private JLabel lblP1Name;

private JLabel lblForP1Colors;

private JLabel lblP1Color;

private static JLabel lblForP1Score;

private static JLabel lblP1Score;

private JLabel lblPlayer1IsWinner;

//Player 2
private static JLabel lblForPlayer2Names;

private JLabel lblP2Name;

private JLabel lblForP2Colors;

private JLabel lblP2Color;

private static JLabel lblForP2Score;

private static JLabel lblP2Score;

private JLabel lblPlayer2IsWinner;
	      
	// JPanel Names 
		public static JPanel jpPlayer1, jpPlayer2;
	
	//Player 1 panel
	
	private JButton btnPlayer1;
	private static String P1Name = "Player1";
	private String P1Color = "Red";
	public static int p1Score= 0 ;
	static JLabel p1Won= new JLabel( "----------------"); 
	static boolean player1Turn = true;
	private static int Player1Score;
	private static ImageIcon p1Icon = new ImageIcon("/Users/hashmatibrahimi/eclipse-workspace/Connect4Game/img/redPuck.png");
		
	//Player2 JPanel
	
	private JButton btnPlayer2;
	private static String P2Name = "Player 2";
	private String P2Color = "Yellow";
	public static int p2Score = 0 ;
	static JLabel p2Won= new JLabel( "----------------"); //Player.P2Name + " YOU ARE THE WINNER!!!"; ---> ADD TO SETTER METHOD LATER 
	static boolean player2Turn = false;
	private static int Player2Score;
	private static ImageIcon p2Icon = new ImageIcon("/Users/hashmatibrahimi/eclipse-workspace/Connect4Game/img/yellowPuck.png");

	private static String currPlayer = "Player1";
	
			
	public SB () {
		
		//-------------------------------------------------------------------------------------------------		
		lblForPlayer1Names = new JLabel("Name");
		lblForP1Colors = new JLabel("Color");
		lblForP1Score = new JLabel("Score");
		lblPlayer1IsWinner = new JLabel("--------");
		
		lblForPlayer2Names = new JLabel("Name");
		lblForP2Colors = new JLabel("Color");
		lblForP2Score = new JLabel("Score");
		lblPlayer2IsWinner = new JLabel("--------");
		
		
//Player 1 jPanel
//------------------------------------------------------------------------------------------------------
	
		
		jpPlayer1 = new JPanel(new GridLayout(1,9,5,4));
		jpPlayer1.setBorder(BorderFactory.createDashedBorder(Color.black, 3, 10, 0, false));
		
		// Player 1 Components
				lblP1Name = new JLabel(P1Name);
				lblP1Color = new JLabel(P1Color);
				lblP1Score = new JLabel("0");
				btnPlayer1 = new JButton("Player 1");
				btnPlayer1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
					setPlayer1Name(JOptionPane.showInputDialog(null, "Please enter a name you desire Player 1"));
						
					};
					
				});
				
				
				//add and orient labels for player1 panel
				jpPlayer1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				jpPlayer1.add(btnPlayer1);
				jpPlayer1.add(lblForPlayer1Names);
				jpPlayer1.add(lblForP1Colors);
				jpPlayer1.add(lblP1Color);
				jpPlayer1.add(lblForP1Score);
				jpPlayer1.add(lblP1Score);
				//jpPlayer1.add(lblForPlayer1Won);
				jpPlayer1.add(p1Won);
				jpPlayer1.setVisible(true);
				
				
				
//Player 2 JPanel
//------------------------------------------------------------------------------------------------------				
		jpPlayer2 = new JPanel(new GridLayout(1,9,5,4));
		jpPlayer2.setBorder(BorderFactory.createDashedBorder(Color.black, 3, 10, 0, false));
		
		//Player 2 Components
			lblP2Name = new JLabel(P2Name);
			lblP2Color = new JLabel(P2Color);
			lblP2Score = new JLabel("0");
			btnPlayer2 = new JButton("Player2");
			btnPlayer2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setPlayer2Name(JOptionPane.showInputDialog(null, "Please enter a name you desire Player 2"));
					
				}
				
			});
				//add and orient labels for player2 panel
			jpPlayer2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jpPlayer2.add(btnPlayer2);
			jpPlayer2.add(lblForPlayer2Names);
			jpPlayer2.add(lblForP2Colors);
			jpPlayer2.add(lblP2Color);
			jpPlayer2.add(lblForP2Score);
			jpPlayer2.add(lblP2Score);
			//jpPlayer2.add(lblForPlayer2Won);
			jpPlayer2.add(p2Won);
			jpPlayer2.setVisible(true);
			
		
	
		
		
		
	
		
		//________________________________________________________________________________
		

	
	
}
    


	
	//setters and getters for score change
	
	public static ImageIcon getPlayer1Icon() {
		return p1Icon;
	}
	public static ImageIcon getPlayer2Icon() {
		return p2Icon;
	}
	
	
	public static void setP1Score(int score) {
		lblP1Score.setText("" + score);
	}
	public int getP1Score() {
		return Player1Score;	
		
	}
	public static void incP1Score() {
		p1Score++;
		lblP1Score.setText("" + p1Score);
	}
	
public static void setP2Score(int score) {
		lblP2Score.setText("" + score);
	}
	public int getP2Score() {
		return Player2Score;
	}
	public static void incP2Score() {
		p2Score++;
		lblP2Score.setText("" + p2Score);
	}
		
	//setter and getter for player winner
	public static void setP1Won() {
		p1Won.setText(P1Name + "WINNER!!!"); 
		p1Won.setForeground(java.awt.Color.red);
		p2Won.setForeground(java.awt.Color.DARK_GRAY);
		p2Won.setText(P2Name + "LOSSER"); 
		p1Won.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
		incP1Score();
		
		
	}
	public static void setP2Won() {
		p1Won.setText(P1Name + "  LOSSER"); 
		p2Won.setText(P2Name + "  WINNER!!!"); 
		p1Won.setForeground(java.awt.Color.DARK_GRAY);
		p2Won.setForeground(java.awt.Color.ORANGE);
		p1Won.setFont(new Font( Font.DIALOG,Font.ITALIC,15));
		p2Won.setFont(new Font( Font.DIALOG,Font.ITALIC,15));
		incP2Score();
		
	}
	
	
	
	//setters and getters for currPlayer
 	public static void setCurrPlayer(String curP) {
		currPlayer = curP;
		if(currPlayer == "Player1") {
			
		}
			
	}
	public static String getCurrPlayer() {
		return currPlayer;
	}
			
	
	 //getters and setters for player turn 
	public static void setPlayer1Turn(boolean turn) {
		player1Turn = turn;
	}
	public static void setPlayer2Turn(boolean turn) {
		player2Turn = turn;
	}
	
	
	
	//------------------------------------------------------------------------------------------------------
		//setters and getters for name change
	
	public static void setPlayer1Name(String name) {
		P1Name = name;
		lblForPlayer1Names.setText(name);
	}
	public static void setPlayer2Name(String name) {
		P2Name = name;
		lblForPlayer2Names.setText(name);
	}
	public String getPlayer1Name() {
		return P1Name;
	}
	public String getPlayer2Name() {
		return P2Name;
	}
	

	
	
}


