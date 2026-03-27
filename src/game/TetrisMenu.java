package game;
import javax.swing.*; 

public class TetrisMenu extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TetrisMenu() {
		
		//Game
		var gameMenu = new JMenu("Game"); 
		var restartItem = new JMenuItem("Restart"); 
		var pauseItem = new JMenuItem("Pause"); 
		var exitItem = new JMenuItem("Exit"); 
		
		gameMenu.add(restartItem);
		gameMenu.add(pauseItem); 
		gameMenu.add(exitItem); 
		
		//Audio
		var audioMenu = new JMenu("Audio"); 
		
		
			
		//Help 
		var helpMenu = new JMenu("Help"); 
		var faq = new JMenuItem("F.A.Q."); 
		var info = new JMenuItem("About us"); 
		
		helpMenu.add(faq); 
		helpMenu.add(info); 
		
		//Add menus to TetrisMenu
		add(gameMenu); 
		add(audioMenu); 
		add(helpMenu);
		
		//Actions 
		exitItem.addActionListener(e -> System.exit(0));
			
	}
	
	 
	
}
