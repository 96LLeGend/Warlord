package engine;

import javafx.scene.Scene;
import model.Grid;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*
 * This class is used for handle pausing, the countdown for the start, fast 
 * forward time and the in game menus
 */

public class Interrupt{
	
	private static int temp = 0;
	
	/*
	 * Handling pause and resume
	 */
	public static int pause(Scene scene, int run){

		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			temp = run;
			
			/*When P is pressed, "run" will become "not run" or "not run" will become "run", 
			*therefore pause and resume
			*/
			if(key.getCode() == KeyCode.P) {
				if (temp == 0) {
					temp = 1;
				} else if (temp == 1) {
					temp = 0;
				}
			}
		});
			
		return temp;
	}
	
	
	public static boolean countdownForStart(int countdownFrame){
		
		//Show paddles when countdowning
		if (countdownFrame > 0){			
			Grid.setObject(14, 25, Grid.Object.PADDLE1);
			Grid.setObject(14, 26, Grid.Object.PADDLE1);
			Grid.setObject(14, 27, Grid.Object.PADDLE1);
			Grid.setObject(14, 14, Grid.Object.PADDLE2);
			Grid.setObject(14, 13, Grid.Object.PADDLE2);
			Grid.setObject(14, 12, Grid.Object.PADDLE2);
			Grid.setObject(25, 14, Grid.Object.PADDLE3);
			Grid.setObject(25, 13, Grid.Object.PADDLE3);
			Grid.setObject(25, 12, Grid.Object.PADDLE3);
			Grid.setObject(25, 25, Grid.Object.PADDLE4);
			Grid.setObject(25, 26, Grid.Object.PADDLE4);
			Grid.setObject(25, 27, Grid.Object.PADDLE4);
						
		/*No need the manager paddles anymore, as the countdown is end and the 
		PaddleCOntroller take over from here*/
		} else if(countdownFrame == 0){
			Grid.setObject(14, 25, Grid.Object.EMPTY);
			Grid.setObject(14, 26, Grid.Object.EMPTY);
			Grid.setObject(14, 27, Grid.Object.EMPTY);
			Grid.setObject(14, 14, Grid.Object.EMPTY);
			Grid.setObject(14, 13, Grid.Object.EMPTY);
			Grid.setObject(14, 12, Grid.Object.EMPTY);
			Grid.setObject(25, 14, Grid.Object.EMPTY);
			Grid.setObject(25, 13, Grid.Object.EMPTY);
			Grid.setObject(25, 12, Grid.Object.EMPTY);
			Grid.setObject(25, 25, Grid.Object.EMPTY);
			Grid.setObject(25, 26, Grid.Object.EMPTY);
			Grid.setObject(25, 27, Grid.Object.EMPTY);
			
			temp = 1;
			
			return true;
		}
		
		return false;
	}
	
}