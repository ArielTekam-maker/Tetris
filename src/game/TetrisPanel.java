package game;
import javax.swing.*;
import java.awt.*;

import tetrominos.*; 

public class TetrisPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int rows = 22; 
	private final int columns = 14; 
	private final int cellSize = 30; 
	private Color[][] board = new Color[rows][columns]; 
	private boolean gameOver = false; 
	
	public TetrominoBase currentBlock; 
	
	
	public TetrisPanel() {
		setPreferredSize(new Dimension(columns*cellSize, rows*cellSize));
		setBackground(Color.BLACK);
		currentBlock = TetrominosRandomFactory.generateRandomBlock(); 
		currentBlock.setPosition(7,0);
		moveBlocks();
		
		Keyboard keyboard = new Keyboard(this); 
		this.addKeyListener(keyboard);
		setFocusable(true);
		requestFocusInWindow();
	}
	
	//Render the game's grid and elements using the graphic pen from the "Graphics" class
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		renderGrid(g);
		renderBoard(g); 
		renderBlock(g); 
		if (gameOver) {
			renderGameOver(g);
		}
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
	
	private void renderBoard(Graphics g) {
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
	
	private void renderBlock(Graphics g) {
		
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
	
	private void moveBlocks() {
		Thread fallingBlocksThread = new Thread(() -> {
			
			while(true) {
				
				if (!gameOver) {

					//Get the position of the current Block and update it.
					int currentX = currentBlock.getX(); 
					int currentY = currentBlock.getY(); 
					
					int newY = currentY + 1; 
					
					if (checkInsideBounds(currentX, newY)) {
						currentBlock.setPosition(currentX, newY);
					} else {
						lockBlock(); 
						clearLines(); 
						createBlock();
					} 
					
					repaint(); 
				}
				
				//Manage the start of the falling event.
				try {
					Thread.sleep(300); // Set the speed of the falling event of the block.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
		});
		
		fallingBlocksThread.start();
	}
	
	public boolean checkInsideBounds(int newX, int newY) {

	    int[][] shape = currentBlock.getShape();

	    for (int row = 0; row < shape.length; row++) {
	        for (int col = 0; col < shape[row].length; col++) {

	            if (shape[row][col] != 0) {

	                int boardX = newX + col;
	                int boardY = newY + row;

	                if (boardX < 0) {
	                    return false;
	                }
	                
	                if (boardX >= columns) {
	                    return false;
	                }

	                if (boardY >= rows) {
	                    return false;
	                }
	                
	                if (boardY >= 0 && board[boardY][boardX] != null) {
	                    return false;
	                }
	            }
	        }
	    }

	    return true;
	}
	
	private void createBlock() {
			currentBlock = TetrominosRandomFactory.generateRandomBlock(); 
			currentBlock.setPosition(7, -3);
			
			if (!checkInsideBounds(currentBlock.getX(), currentBlock.getY())) {
			    gameOver = true;
			}
	}
	
	private void lockBlock() {

	    int[][] shape = currentBlock.getShape();

	    for (int row = 0; row < shape.length; row++) {
	        for (int col = 0; col < shape[row].length; col++) {

	            if (shape[row][col] != 0) {

	                int boardX = currentBlock.getX() + col;
	                int boardY = currentBlock.getY() + row;

	                // Save block into board
	                try {
	                	board[boardY][boardX] = currentBlock.getColor();
	                } catch (ArrayIndexOutOfBoundsException e) {
	                	setGameOver(true);
	                }
	                
	            }
	        }
	    }
	}

	private boolean isRowFull(int row) {
		for (int column = 0; column < columns; column++) {
			if (board[row][column] == null) {
				return false; 
			}
		}
		return true; 
	}
	
	
	private void clearRow(int row) {
		for (int i = row; i>0; i--) {
			for (int column = 0; column < columns; column++) {
				board[i][column] = board[i-1][column]; 
			}
		}
		
		for (int column = 0; column < columns; column++) {
	        board[0][column] = null;
	    }
	}
	
	private void clearLines() {
		int clearedLines = 0;

	    for (int row = 0; row < rows; row++) {

	        if (isRowFull(row)) {
	            clearRow(row);
	            clearedLines ++;

	            row--;
	        }
	    }
	}
	
	private void renderGameOver(Graphics g) {
		
		String text = "Game Over"; 
		FontMetrics fm = g.getFontMetrics();
		
		int x = (this.getWidth() - fm.stringWidth(text.toUpperCase())) / 4;
	    int y = (this.getHeight() - fm.getHeight()) / 2 + fm.getAscent();
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString(text.toUpperCase(), x, y);
	}
	
	//Getters and Setters
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
