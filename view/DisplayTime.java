package view;

import javafx.scene.paint.Color;
import model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*
 * This class can display the time remain and game status on the header
 */

public class DisplayTime{
	
	/*
	 * Display the time remaining at the top left corner
	 */
	public static void countDown(GraphicsContext gameWindow){

		//Read the remaining time from Game class
		String time = String.valueOf(Game.getTimeRemaining());
		
		//Drawing
		gameWindow.setStroke(Color.rgb(74, 35, 90));
		gameWindow.setFill(Color.rgb(192, 57, 43));
		gameWindow.setLineWidth(2);
		Font theCountdown = Font.font("Times New Roman", FontWeight.BOLD, 48.0);
		gameWindow.setFont(theCountdown);
		gameWindow.strokeText(time, 5, 40);
		gameWindow.fillText(time, 5, 40);
		   
	}
	
	
	/*
	 * Display game status in the header. It also display the countdown before game start in the centre of the screen
	 */
	public static void status(GraphicsContext gameWindow, int countdownFrame){
		
		//Display the countdown in the centre of the screen
		gameWindow.setStroke(Color.BLACK);
		gameWindow.setLineWidth(1);
		Font theCountdown = Font.font("Times New Roman", FontWeight.BOLD, 20.0);
		gameWindow.setFont(theCountdown);
		
		//Drawing the count down
		if (countdownFrame > 400){
			gameWindow.strokeText("The duel start at...5", 190, 340);
			
		} else if (countdownFrame <= 400 && countdownFrame > 300){
			gameWindow.strokeText("The duel start at...4", 190, 340);
			
		} else if (countdownFrame <= 300 && countdownFrame > 200){
			gameWindow.strokeText("The duel start at...3", 190, 340);
			
		} else if (countdownFrame <= 200 && countdownFrame > 100){
			gameWindow.strokeText("The duel start at...2", 190, 340);
			
		} else if (countdownFrame <= 100 && countdownFrame > 0){
			gameWindow.strokeText("The duel start at...1", 190, 340);
			
		} else if (countdownFrame == 0){
			gameWindow.strokeText("The duel start at...0", 180, 340);			
		}
		
		
		//Display the status in the header
		gameWindow.setFill( Color.BLUE);
		Font inProgress = Font.font("Times New Roman", FontWeight.BOLD, 20.0);
		gameWindow.setFont(inProgress);
		
		if (Game.getTimeRemaining() == 120) {
			gameWindow.fillText("Get ready!", 280, 35);
			
		} else if (Game.getTimeRemaining() < 120 && Game.getTimeRemaining() > 10){
			gameWindow.fillText("The duel is on!", 260, 35);
			
		} else if(Game.getTimeRemaining() < 10 && Game.getTimeRemaining() > 0){
			gameWindow.fillText("Come on, time is running out!", 190, 35);
			
		} else if (Game.getTimeRemaining() == 0){
			gameWindow.fillText("The duel is over!", 255, 35);
		}
	}
	
}