package tetrominos;

import java.awt.Color;

public class ZBlock extends TetrominoBase{

	public ZBlock() {
		color = new Color(143,0,255); //Purple
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
 