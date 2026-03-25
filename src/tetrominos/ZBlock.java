package tetrominos;

import java.awt.Color;

public class ZBlock extends TetrominoBase{

	public ZBlock() {
		color =  new Color(220, 0, 0); //Purple
		shapes = new int [][][] {
			{
				{1,1,0},
				{0,1,1} 
			}, 
			{
				{0,1},
				{1,1},
				{1,0}
			}
		}; 
	}
}
 