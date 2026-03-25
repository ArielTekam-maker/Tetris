package tetrominos;

import java.awt.Color;

public class TBlock extends TetrominoBase{

	public TBlock() {
		color = new Color(160, 0, 240);; 
		shapes = new int [][][] {
			{
				{0,1,0},
				{1,1,1} 
			}, 
			{
				{1,0},
				{1,1},
				{1,0}
			},
			{
				{1,1,1},
				{0,1,0} 
			},
			{
				{0,1},
				{1,1},
				{0,1}
			}
		}; 
	}
}
