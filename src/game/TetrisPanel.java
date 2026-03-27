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
	private boolean paused = false;
	
	private int score = 0; 
	private int level = 1; 
	private int linesClearedTotal = 0;
	private int baseSpeed = 900;
	private int speed = baseSpeed;
	
	private TetrominoBase currentBlock;
	
	public TetrisPanel() {
		setPreferredSize(new Dimension(columns*cellSize, rows*cellSize));
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
		
		createBlock();
		
		if(!paused) {
			moveBlocks();			
		}
		
		Keyboard keyboard = new Keyboard(this); 
		this.addKeyListener(keyboard);
		setFocusable(true);
		requestFocusInWindow();
	}
	
	//Render the game's grid and elements using the graphic pen from the "Graphics" class
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		Display.renderGrid(g);
		Display.renderBoard(g, board); 
		Display.renderBlock(g, currentBlock); 
		if (gameOver) {
			Display.renderMessage(g, "Game Over", this.getWidth(), this.getHeight());
		}
		
		if (paused) {
		    g.setColor(Color.YELLOW);
		    g.setFont(new Font("Consolas", Font.BOLD, 50));
		    g.drawString("PAUSED", getWidth()/2 - 70, getHeight()/2);
		}
	}
	
	private void moveBlocks() {
		Thread fallingBlocksThread = new Thread(() -> {
			
			
			while(true) {
				
				if (!paused && !gameOver) {

					//Get the position of the current Block and update it.
					int currentX = currentBlock.getX(); 
					int currentY = currentBlock.getY(); 
					int newY = currentY + 1; 
					
					if (checkInsideBounds(currentX, newY)) {
						currentBlock.setPosition(currentX, newY);
					} else {
						lockBlock(); 
						
						int linesCleared = clearLines();
						
						if(linesCleared > 0) {
							addScore(linesCleared);
							updateLevelAndSpeed();
							Dashboard.updateDashboard();
						}
						createBlock();
					}
					this.repaint();

					//Manage the start of the falling event.
					try {
						
						Thread.sleep(this.speed); // Set the speed of the falling event of the block.
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		currentBlock.setPosition(6, -3);
			
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
	
	
	private void clearRow(int rowNummer) {
		for (int row = rowNummer; row>0; row--) {
			for (int column = 0; column < columns; column++) {
				board[row][column] = board[row-1][column]; 
			}
		}
		
		for (int column = 0; column < columns; column++) {
	        board[0][column] = null;
	    }
	}
	
	private int clearLines() {
		int linesCleared = 0;
	    for (int row = 0; row < rows; row++) {

	        if (isRowFull(row)) {
	            clearRow(row);
	            linesCleared++;
	            
	            row--;
	        }
	    }
	    
	    return linesCleared;
	}
	
	private void addScore(int linesCleared) {

	    int points = 0;

	    switch (linesCleared) {
	        case 1: points = 100; break;
	        case 2: points = 300; break;
	        case 3: points = 500; break;
	        case 4: points = 800; break;
	    }

	    score += points * level;
	    linesClearedTotal += linesCleared;

	    level = linesClearedTotal / 10 + 1;
	}
	
	private void updateLevelAndSpeed() {
	    level = linesClearedTotal / 10 + 1; // increase level every 10 lines

	    // Decrease speed for higher levels
	    speed = Math.max(50, baseSpeed - (level - 1) * 40);
	}
	
	public void resetGame() {

	    board = new Color[rows][columns];

	    Dashboard.resetDashboard();
	    
	    score = 0;
	    linesClearedTotal = 0;
	    level = 1;

	    gameOver = false;
	    paused = false;

	    currentBlock = TetrominosRandomFactory.generateRandomBlock();
	    currentBlock.setPosition(6, -3);
	}
	
	public void togglePause() {
	    paused = !paused;
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
	
	public TetrominoBase getCurrentBlock() {
		return this.currentBlock; 
	}
	
	public void setCurrentBlock(TetrominoBase currentBlock) {
		this.currentBlock = currentBlock;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLines() {
		return linesClearedTotal;
	}

	public void setLines(int lines) {
		this.linesClearedTotal = lines;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}

