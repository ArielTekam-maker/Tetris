package game;

import java.awt.*;

import javax.swing.*;

public class Dashboard extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JLabel scoreLabel;
	private static JLabel levelLabel;
	private static JLabel linesLabel;
	private JTextArea controlsArea;
	
	private static TetrisPanel gamePanel; 
	
	public Dashboard(TetrisPanel tetrisPanel) {
		Dashboard.gamePanel = tetrisPanel;
		
		setPreferredSize(new Dimension(250, 0));
		setBackground(gamePanel.getBackground());
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents();
	}
	
	private void initComponents() {
		scoreLabel = createLabel();
		levelLabel = createLabel();
		linesLabel = createLabel();
		controlsArea = createTextArea();
		
		add(Box.createVerticalStrut(100));
		add(scoreLabel);
		add(Box.createVerticalStrut(50));
		add(linesLabel);
		add(Box.createVerticalStrut(50));
		add(levelLabel);
		add(Box.createVerticalStrut(100));
		add(controlsArea);
		
		scoreLabel.setText("Score: " + gamePanel.getScore());
		linesLabel.setText("Lines: " + gamePanel.getLines());
		levelLabel.setText("Level: " + gamePanel.getLevel());
		
		scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		linesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		controlsArea.setText(		
		"LEFT ARROW: Move left\n\n" + 
		"RIGHT ARROW: Move right\n\n" +
		"DOWN ARROW: Soft Drop\n\n" + 
		"SPACE: Rotate\n\n" + 
		"R: Restart\n\n" + 
		"E: Exit"
		);
	}
	
	private JLabel createLabel() {
		 var label = new JLabel();

		 label.setForeground(Color.WHITE);
		 label.setFont(new Font("Consolas", Font.BOLD, 16));

		 return label;
	}
	
	private JTextArea createTextArea() {
		var textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFocusable(false);

		textArea.setForeground(Color.WHITE);
		textArea.setBackground(gamePanel.getBackground());

		textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		textArea.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createTitledBorder("Controls"),
			    BorderFactory.createEmptyBorder(30, 30, 30, 30)
			));
		return textArea;
	}
	
	public static void updateDashboard() {
		scoreLabel.setText("Score: " + gamePanel.getScore());
		linesLabel.setText("Lines: " + gamePanel.getLines());
		levelLabel.setText("Level: " + gamePanel.getLevel());
	}
	
	public static void resetDashboard() {
		scoreLabel.setText("Score: " + 0);
		linesLabel.setText("Lines: " + 0);
		levelLabel.setText("Level: " + 1);
	}
}
