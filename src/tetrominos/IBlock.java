package tetrominos;

import java.awt.Color;

public class IBlock extends TetrominoBase{
	
	public IBlock() {
		color = new Color(0, 240, 240); 
		shapes = new int [][][] {
			{	
				{1,1,1,1}
			}, 
			
			{	{1},
				{1},
				{1},
				{1}
			}
		}; 
	}
}
