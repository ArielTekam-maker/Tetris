package tetrominos;

import java.awt.Color;

public class IBlock extends TetrominoBase{
	
	public IBlock() {
		color = Color.CYAN; 
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
