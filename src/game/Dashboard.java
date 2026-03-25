package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Dashboard extends JPanel{
	
	private TetrisPanel tetrisPanel;
	
	public Dashboard() {
		setPreferredSize(new Dimension(150, 400));
		setBackground(Color.DARK_GRAY);
	}
}
