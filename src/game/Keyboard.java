package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import tetrominos.*;

public class Keyboard extends KeyAdapter{
	private TetrisPanel gamePanel; 
	
	public Keyboard(TetrisPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
    public void keyPressed(KeyEvent e) {

		TetrominoBase currentBlock = gamePanel.getCurrentBlock();
        int key = e.getKeyCode();
        int x = currentBlock.getX(); 
        int y = currentBlock.getY(); 

        if (key == KeyEvent.VK_LEFT) {
        	if (gamePanel.checkInsideBounds(x-1, y)) {
        		currentBlock.setPosition(x-1, y);
			}
        } 
        else if (key == KeyEvent.VK_RIGHT) {
        	if (gamePanel.checkInsideBounds(x+1, y)) {
        		currentBlock.setPosition(x+1, y);
			}
        } 
        else if (key == KeyEvent.VK_DOWN) {
        	if (gamePanel.checkInsideBounds(x,y+2)) {
        		currentBlock.setPosition(x, y+2);
			}
        } 
        else if(key == KeyEvent.VK_SPACE) {
        	currentBlock.rotate();
        	if (!gamePanel.checkInsideBounds(currentBlock.getX(), currentBlock.getY())) {
                currentBlock.rotateBack();
            }
        }
        else if(key == KeyEvent.VK_R) {
        	gamePanel.resetGame();
        }
        else if(key == KeyEvent.VK_E) {
        	System.exit(0);
        }
        else if(key == KeyEvent.VK_P) {
        	gamePanel.togglePause();
        }

        gamePanel.repaint();
    }
}
