package game;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Keyboard implements KeyListener{
	private TetrisPanel game; 
	
	public Keyboard(TetrisPanel game) {
		this.game = game; 
	}
	
	@Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        int x = game.currentBlock.getX(); 
        int y = game.currentBlock.getY(); 

        if (key == KeyEvent.VK_LEFT) {
        	if (game.checkInsideBounds(x-1, y)) {
        		game.currentBlock.setPosition(x-1, y);
			}
        } 
        else if (key == KeyEvent.VK_RIGHT) {
        	if (game.checkInsideBounds(x+1, y)) {
        		game.currentBlock.setPosition(x+1, y);
			}
        } 
        else if (key == KeyEvent.VK_DOWN) {
        	if (game.checkInsideBounds(x,y+2)) {
        		game.currentBlock.setPosition(x, y+2);
			}
        } 
        else if(key == KeyEvent.VK_SPACE) {
        	game.currentBlock.rotate();
        	if (!game.checkInsideBounds(game.currentBlock.getX(), game.currentBlock.getY())) {
                game.currentBlock.rotateBack();
            }
        }

        game.repaint();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
