import javax.swing.*;

public class TetrisWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	public TetrisWindow() { 
		super("Tetris");
		
		var menuBar = new TetrisMenu(); 
		setJMenuBar(menuBar);
		
		//Add the game panel
		var panel = new TetrisPanel(); 
		add(panel); 
		
		pack(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
