import javax.swing.*;
import java.awt.*;
import tetrominos.*; 

public class TetrisPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int rows = 20; 
	private final int columns = 15; 
	private final int cellSize = 30; 
	private int[][] board = new int[rows][columns]; 
	private TetrominoBase currentBlock; 
	
	public TetrisPanel() {
		setPreferredSize(new Dimension(columns*cellSize, rows*cellSize));
		setBackground(Color.BLACK);
	}
	
	//Render the game's grid and elements using the graphic pen from the "Graphics" class
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		renderGrid(g);
		renderBlock(g); 
	}
	
	private void renderGrid(Graphics g) {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int x = column * cellSize; 
				int y = row * cellSize; 
				
				g.drawRect(x, y, cellSize, cellSize);
				
			}
		}
	}
	
	private void renderBlock(Graphics g) {
		currentBlock = TetrominosFactory.generateRandomBlock(); 
		currentBlock.setPosition(4,0);
		
		int[][] shape = currentBlock.getShape(); 
		Color color = currentBlock.getColor(); 
		
		for (int row = 0; row < shape.length; row++) {
			for (int column = 0; column < shape[row].length; column++) {
				
				if(shape[row][column] != 0) {
					int x = (currentBlock.getX() + column) * cellSize; 
					int y = (currentBlock.getY() + row) * cellSize;
					
					g.setColor(color);
					g.fillRect(x, y, cellSize, cellSize);
					
					g.setColor(Color.BLACK);
					g.drawRect(x, y, cellSize, cellSize);	
				}
			}
		}
	}
}
