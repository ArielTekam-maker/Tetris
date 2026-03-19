import java.util.Random;
import tetrominos.*;

public class TetrominosFactory {

	private static final Random random = new Random(); 
	
	public static TetrominoBase generateRandomBlock() {
		int randomBlock = random.nextInt(7); 
		switch(randomBlock) {
			case 0: return new IBlock(); 
			case 1: return new OBlock(); 
			case 2: return new TBlock(); 
			case 3: return new SBlock();
			case 4: return new ZBlock(); 
			case 5: return new JBlock(); 
			case 6: return new LBlock(); 
			default: return null; 
		}
	}
}
