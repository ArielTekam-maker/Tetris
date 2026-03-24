package tetrominos;
import java.awt.*;

public abstract class TetrominoBase {
	protected int[][][] shapes; 
	protected int rotation; 
	protected int x, y; 
	protected Color color; 
	
	
	public void rotate() {
		rotation = (rotation + 1) % shapes.length; 
	}
	
	public void rotateBack() {
	    rotation = (rotation - 1 + shapes.length) % shapes.length;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	public void setPosition(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	
	public Color getColor() {return color;}
	
	public int [][] getShape() {
		return shapes[rotation]; 
	}
	
}
