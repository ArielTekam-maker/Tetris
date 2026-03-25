package tetrominos;

import java.awt.Color;

public class SBlock extends TetrominoBase{

	public SBlock() {
		color = new Color(0, 200, 0); 
		shapes = new int [][][] {
			{
				{0,1,1},
				{1,1,0} 
			}, 
			{
				{1,0},
				{1,1},
				{0,1}
			}
		}; 
	}
}
