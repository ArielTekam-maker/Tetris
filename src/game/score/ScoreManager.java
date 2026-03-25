package game.score;

public class ScoreManager {
	private int score = 0;
	
	public void updateScore(int lines) {
		if(lines == 1)
			score += 20;
		else if(lines == 2) 
			score += 50;
		else if(lines == 3)
			score += 100;
		else if(lines == 4)
			score += 200;
	}
}
