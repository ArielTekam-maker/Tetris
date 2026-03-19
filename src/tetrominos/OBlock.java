package tetrominos;

import java.awt.Color;

public class OBlock extends TetrominoBase{

	public OBlock() {
		color = Color.YELLOW; 
		shapes = new int [][][] {
			{
				{1,1},
				{1,1}
			}
		}; 
	}

}
