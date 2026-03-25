package tetrominos;

import java.awt.Color;

public class OBlock extends TetrominoBase{

	public OBlock() {
		color = new Color(240, 240, 0);; 
		shapes = new int [][][] {
			{
				{1,1},
				{1,1}
			}
		}; 
	}

}
