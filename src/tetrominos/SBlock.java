package tetrominos;

import java.awt.Color;

public class SBlock extends TetrominoBase{

	public SBlock() {
		color = Color.GREEN; 
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
