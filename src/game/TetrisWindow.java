package game;

import java.awt.*;
import javax.swing.*;

public class TetrisWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  
	public TetrisWindow() { 
		
		//>--- Game Area ---<
		//___________________
		
		super("Tetris");
		
		var menuBar = new TetrisMenu(); 
		setJMenuBar(menuBar);
		
		//Add the game panel and DashBoard
		setLayout(new BorderLayout());
		
		var panel = new TetrisPanel();
		var dashboard = new Dashboard();
		add(panel, BorderLayout.CENTER); 
		add(dashboard, BorderLayout.EAST);
		
		pack(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
}
