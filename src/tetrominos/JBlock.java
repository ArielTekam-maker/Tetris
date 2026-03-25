package tetrominos;

import java.awt.Color;

public class JBlock extends TetrominoBase{

	public JBlock() {
		color = new Color(0, 100, 255); 
		shapes = new int [][][] {
			{
				{0,1},
				{0,1},
				{1,1}
			},
			{
				{1,0,0},
				{1,1,1} 
			}, 
			{
				{1,1},
				{1,0},
				{1,0}
			},
			{
				{1,1,1},
				{0,0,1} 
			},
		}; 
	}
}
