import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class C4B extends JPanel {
	static JButton[][] slots = new JButton[6][7];
	GHeader header = new GHeader();
	private static int counter;

	public static boolean exitGame = false;

	public C4B() {
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBackground(Color.blue);
		setLayout(new GridLayout(6, 2, 0, 0));
		displayGB();
		SB.setPlayer1Name(JOptionPane.showInputDialog(null, "Please enter a name you desire Player 1"));
		SB.setPlayer2Name(JOptionPane.showInputDialog(null, "Please enter a name you desire Player 2"));
	}

	int currRow;
	int currCol;

	int rowMax = 6;
	int colMax = 7;

	public void displayGB() {

		slots = new JButton[6][7];// initialize 2D array to 6x7

		for (int row = 0; row < slots.length; row++) {
			for (int col = 0; col < slots[row].length; col++) {
				slots[row][col] = new JButton(" " + row + col);
				slots[row][col].setForeground(Color.WHITE);
				slots[row][col].setBackground(Color.WHITE);
				slots[row][col].addActionListener(listener);

				add(slots[row][col]);
			}

		}
	}

	public void dropDown(int col, ImageIcon puck) {
		for (int row = 0; row < slots.length; row++) {
			if (slots[row][col].getIcon() != null) {
				slots[row - 1][col].setIcon(puck);
				currRow = row - 1;
				currCol = col;
				break;
			} else if (row == slots.length - 1) {
				slots[row][col].setIcon(puck);
				currRow = row;
				currCol = col;
				break;
			}

		}
	}

	public static void clearBoard() {
		for (int row = 0; row < slots.length; row++) {
			for (int col = 0; col < slots[row].length; col++) {
				slots[row][col].setIcon(null);
				SB.setCurrPlayer("Player1");
			}
		}
		SB.setCurrPlayer("Player1");
		SB.jpPlayer1.setBackground(Color.lightGray);
		SB.jpPlayer2.setBackground(Color.LIGHT_GRAY);
		SB.p1Won.setForeground(java.awt.Color.red);
		SB.p2Won.setForeground(java.awt.Color.DARK_GRAY);
		SB.p1Won.setText("------------------");
		SB.p2Won.setText("------------------");

	}

	public void takeTurn() {
		if (SB.getCurrPlayer() == "Player1") {

			SB.jpPlayer1.setBackground(Color.green);
			SB.jpPlayer2.setBackground(Color.LIGHT_GRAY);
			SB.setCurrPlayer("Player2");

		}

		else if (SB.getCurrPlayer() == "Player2") {

			SB.jpPlayer1.setBackground(Color.LIGHT_GRAY);
			SB.jpPlayer2.setBackground(Color.green);
			SB.setCurrPlayer("Player1");

		}

	}

	public void checkHoriz(ImageIcon puck) {
		for (int pRow = 0; pRow < slots.length; pRow++) {
			int horzCounter = 0;
			for (int pCol = 0; pCol < slots[pRow].length; pCol++) {

				if (slots[pRow][pCol].getIcon() == puck) {

					horzCounter++;
					if (horzCounter == GHeader.x) {
						counter = horzCounter;
					}
				} else {
					horzCounter = 0;
				}

			}
		}
	}

	public void checkVirt(ImageIcon puck) {
		for (int pCol = 0; pCol <= 6; pCol++) {
			int virtCounter = 0;
			for (int pRow = 0; pRow <= 5; pRow++) {
				// System.out.println(virtCounter);

				if (slots[pRow][pCol].getIcon() == puck) {

					virtCounter++;
					if (virtCounter == GHeader.x) {
						counter = virtCounter;
					}

				} else {
					virtCounter = 0;
				}

			}
		}
	}

	public void checkLRDiagonal(ImageIcon puck) {
		for (int rowStart = 0; rowStart <= rowMax - 2; rowStart++) {
			int LRCounter = 0;
			int row;
			int col;
			for (row = rowStart, col = 0; row < rowMax && col < colMax; row++, col++) {
				// System.out.println(virtCounter);

				if (slots[row][col].getIcon() == puck) {

					LRCounter++;
					System.out.println(LRCounter);
					if (LRCounter == GHeader.x) {
						counter = LRCounter;
					}

				} else {
					LRCounter = 0;
				}

			}
		}
	}

	public void checkRLDiagonal(ImageIcon puck) {
		for (int pCol = 0; pCol <= 6; pCol++) {
			int RLCounter = 0;
			for (int pRow = 0; pRow <= 5; pRow++) {
				// System.out.println(virtCounter);

				if (slots[pRow][pCol].getIcon() == puck) {

					RLCounter++;
					if (RLCounter == GHeader.x) {
						counter = RLCounter;
					}

				} else {
					RLCounter = 0;
				}

			}
		}
	}

	public void winner() {
		if (counter == GHeader.x) {
			if (SB.getCurrPlayer() == "Player1") {
				SB.setP1Won();
				counter = 0;
				playAgain();

			} else if (SB.getCurrPlayer() == "Player2") {
				SB.setP2Won();
				counter = 0;
				playAgain();

			}
		}

	}

	public void playAgain() {
		int repeat = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
		if (repeat == 0) {
			clearBoard();

		} else if (repeat == 1) {

		} else {

		}

	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource() instanceof JButton) {

				JButton b = (JButton) arg0.getSource();

				int col = Integer.parseInt(b.getText().substring(1));

				if (SB.getCurrPlayer() == "Player1") {

					dropDown(col, SB.getPlayer1Icon());

					checkHoriz(SB.getPlayer1Icon());
					checkVirt(SB.getPlayer1Icon());
					checkLRDiagonal(SB.getPlayer1Icon());
					// checkRLDiagonal(SB.getPlayer1Icon());

				} else if (SB.getCurrPlayer() == "Player2") {

					dropDown(col, SB.getPlayer2Icon());

					checkHoriz(SB.getPlayer2Icon());
					checkVirt(SB.getPlayer2Icon());
					checkLRDiagonal(SB.getPlayer2Icon());
					// checkRLDiagonal(SB.getPlayer2Icon());

				}

				winner();
				takeTurn();

			}
		}

	};

	private static class RoundedBorder implements Border {

		private int radius;

		RoundedBorder(int radius) {
			this.radius = radius;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		public boolean isBorderOpaque() {
			return false;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
		}
	}
}
