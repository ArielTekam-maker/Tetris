package tetrominos;

import java.awt.Color;

public class TBlock extends TetrominoBase{

	public TBlock() {
		color = Color.RED; 
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
