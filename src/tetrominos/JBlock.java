package tetrominos;

import java.awt.Color;

public class JBlock extends TetrominoBase{

	public JBlock() {
		color = new Color(255,132,0); 
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
