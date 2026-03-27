package game;

import java.awt.*;
import tetrominos.*;

public class Display {

	private static int rows = 22; 
	private static int columns = 14; 
	private static int cellSize = 30; 
	
	
	public static void renderGrid(Graphics g) {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int x = column * cellSize; 
				int y = row * cellSize; 
				
				g.drawRect(x, y, cellSize, cellSize);
			}
		}
	}
	
	public static void renderBoard(Graphics g, Color[][] board) {
		for (int row = 0; row < rows; row++) {
		    for (int col = 0; col < columns; col++) {

		        if (board[row][col] != null) {

		            int x = col * cellSize;
		            int y = row * cellSize;
		            
		            g.setColor(board[row][col]);
		            g.fillRoundRect(x, y, cellSize, cellSize, 12, 12);

		            g.setColor(Color.BLACK);
		            g.drawRoundRect(x, y, cellSize, cellSize,12,12);
		        }
		    }
		}
	}
	
	public static void renderBlock(Graphics g, TetrominoBase currentBlock) {
		int[][] shape = currentBlock.getShape(); 
		Color color = currentBlock.getColor(); 
		
		for (int row = 0; row < shape.length; row++) {
			for (int column = 0; column < shape[row].length; column++) {
				
				if(shape[row][column] != 0) {
					int x = (currentBlock.getX() + column) * cellSize; 
					int y = (currentBlock.getY() + row) * cellSize;
					
					g.setColor(color);
					g.fillRoundRect(x, y, cellSize, cellSize, 12, 12);
					
					g.setColor(Color.BLACK);
					g.drawRoundRect(x, y, cellSize, cellSize,12,12);	
				}
			}
		}
	}
	
	public static void renderMessage(Graphics g, String message, int panelWidth, int panelHeight) { 
		FontMetrics fm = g.getFontMetrics();
		
		int x = (panelWidth - fm.stringWidth(message.toUpperCase())) / 4;
	    int y = (panelHeight - fm.getHeight()) / 2 + fm.getAscent();
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString(message.toUpperCase(), x, y);
	}
	
}
