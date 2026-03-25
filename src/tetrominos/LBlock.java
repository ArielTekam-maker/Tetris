package tetrominos;

import java.awt.Color;

public class LBlock extends TetrominoBase{
	
	public LBlock() {
		color = new Color(255, 140, 0); 
		shapes = new int [][][] {
			{
				{1,0},
				{1,0},
				{1,1}
			},
			{
				{1,1,1},
				{1,0,0} 
			}, 
			{
				{1,1},
				{0,1},
				{0,1}
			},
			{
				{0,0,1},
				{1,1,1} 
			},
		}; 
	}
}
