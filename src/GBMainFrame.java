import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class GBMainFrame extends JFrame {

	public GBMainFrame() {

		boolean close = false;

		JFrame MainFrame = new JFrame();
		MainFrame.getSize();
		System.out.println(MainFrame.getSize());
		MainFrame.setSize(new Dimension(1500, 1000));
		MainFrame.setLayout(new FlowLayout());
		MainFrame.setBackground(Color.BLUE);
		MainFrame.getContentPane().setBackground(Color.gray);

		GHeader gh = new GHeader();
		gh.setPreferredSize(new Dimension(1500, 50));
		MainFrame.add(gh, BorderLayout.NORTH);

		SB sb = new SB();
		sb.jpPlayer1.setPreferredSize(new Dimension(1500, 50));
		sb.jpPlayer2.setPreferredSize(new Dimension(1500, 50));
		MainFrame.add(sb.jpPlayer1);
		MainFrame.add(sb.jpPlayer2);

		C4B board = new C4B();
		board.setPreferredSize(new Dimension(1000, 800));
		MainFrame.add(board);

		// MainFrame.add(GSB.ScoreBoard.jpPlayer1);
		// MainFrame.add(GSB.ScoreBoard.jpPlayer2);

		MainFrame.setLocationRelativeTo(null);
		MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		MainFrame.setVisible(true);

	}

}
