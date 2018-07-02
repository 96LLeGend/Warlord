package view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.canvas.GraphicsContext;

/*
 * This class is design exclusively for the pages with menu, to create the button selector
 */

public class DisplaySelector{

	/*
	 * The options and selector for the main menu
	 */
	public static void mainMenu(GraphicsContext mainWindow, int selector){
		
		//Clear the old selected position
		mainWindow.clearRect(227, 407, 146, 56);
		mainWindow.clearRect(227, 467, 146, 56);
		mainWindow.clearRect(227, 527, 146, 56);
		mainWindow.clearRect(227, 587, 146, 56);
		
		//Create the buttons
		mainWindow.setFill(Color.GRAY);
	    mainWindow.fillRoundRect(230, 410, 140, 50, 20, 20);
	    mainWindow.fillRoundRect(230, 470, 140, 50, 20, 20);
	    mainWindow.fillRoundRect(230, 530, 140, 50, 20, 20);
	    mainWindow.fillRoundRect(230, 590, 140, 50, 20, 20);
	    
	    //Write the writing on the buttons
	    mainWindow.setFill(Color.WHITE);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 18.0);
		mainWindow.setFont(theFont);
		mainWindow.fillText("Start Game", 240, 440);
		mainWindow.fillText("Help Centre", 240, 500);
		mainWindow.fillText("About", 268, 560);
		mainWindow.fillText("Exit", 278, 620);
		
		//Creat the selector
		mainWindow.setStroke(Color.BLACK);
		mainWindow.setLineWidth(3);		
		
		//Depend which option the selector, draw the selector in the corresponding position 
		if (selector == 1) {
			mainWindow.strokeRoundRect(230, 410, 140, 50, 20, 20);
		} else if (selector == 2) {
			mainWindow.strokeRoundRect(230, 470, 140, 50, 20, 20);
		} else if (selector == 3) {
			mainWindow.strokeRoundRect(230, 530, 140, 50, 20, 20);
		} else if (selector == 4) {
			mainWindow.strokeRoundRect(230, 590, 140, 50, 20, 20);
		}
	    
	
	}

	/*
	 * The options and selector for the game mode menu
	 */
	public static void selectPlayerNumber(GraphicsContext numberWindow, int selector){
		
		//Clear the old selected position
		numberWindow.clearRect(227, 147, 146, 56);
		numberWindow.clearRect(227, 207, 146, 56);
		numberWindow.clearRect(227, 267, 146, 56);
		numberWindow.clearRect(227, 327, 146, 56);
		numberWindow.clearRect(227, 387, 146, 56);
		numberWindow.clearRect(227, 447, 146, 56);
		
		//Create the buttons
		numberWindow.setFill(Color.GRAY);
		numberWindow.fillRoundRect(230, 150, 140, 50, 20, 20);
		numberWindow.fillRoundRect(230, 210, 140, 50, 20, 20);
		numberWindow.fillRoundRect(230, 270, 140, 50, 20, 20);
		numberWindow.fillRoundRect(230, 330, 140, 50, 20, 20);
		numberWindow.fillRoundRect(230, 390, 140, 50, 20, 20);
		numberWindow.fillRoundRect(230, 450, 140, 50, 20, 20);
	    
		//Write the writing on the buttons
		numberWindow.setFill(Color.WHITE);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 15.0);
		numberWindow.setFont(theFont);
		numberWindow.fillText("Demo Mode", 248, 180);
		numberWindow.fillText("Single Player", 245, 240);
		numberWindow.fillText("Two Players", 248, 300);
		numberWindow.fillText("Three Players", 242, 360);
		numberWindow.fillText("Four Players", 245, 420);
		numberWindow.fillText("Return", 270, 480);
		
		//Creat the selector
		numberWindow.setStroke(Color.BLACK);
		numberWindow.setLineWidth(3);
		
		//Depend which option the selector, draw the selector in the corresponding position 
		if (selector == 1) {
			numberWindow.strokeRoundRect(230, 150, 140, 50, 20, 20);
		} else if (selector == 2) {
			numberWindow.strokeRoundRect(230, 210, 140, 50, 20, 20);
		} else if (selector == 3) {
			numberWindow.strokeRoundRect(230, 270, 140, 50, 20, 20);
		} else if (selector == 4) {
			numberWindow.strokeRoundRect(230, 330, 140, 50, 20, 20);
		} else if (selector == 5) {
			numberWindow.strokeRoundRect(230, 390, 140, 50, 20, 20);
		} else if (selector == 6) {
			numberWindow.strokeRoundRect(230, 450, 140, 50, 20, 20);
		}
	    
	}
	
	public static void endGameMenu(GraphicsContext endGameWindow, int selector, String player){
	
		//Clear the old selected position
		endGameWindow.clearRect(227, 352, 146, 56);
		endGameWindow.clearRect(227, 402, 146, 56);
		
		//Create a transparent background for the the pop-up menu
		endGameWindow.setFill(Color.TRANSPARENT);
		endGameWindow.fillRoundRect(195, 245, 210, 210, 20, 20);
		
		//The outline of the menu
		endGameWindow.setStroke(Color.BLACK);
		endGameWindow.setLineWidth(6);
		endGameWindow.strokeRoundRect(195, 245, 210, 210, 20, 20);
		
		//The writing for displaying the winner
		endGameWindow.setFill(Color.BLACK);
		Font bigFont = Font.font("Times New Roman", FontWeight.BOLD, 40.0);
		endGameWindow.setFont(bigFont);
		endGameWindow.fillText("Over!", 235, 290);
		
		endGameWindow.setFill(Color.BLACK);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 13.0);
		endGameWindow.setFont(theFont);
		endGameWindow.fillText("The winner is: " + player, 234, 320);
		
		//Create the buttons
		endGameWindow.setFill(Color.GRAY);
		endGameWindow.fillRoundRect(230, 355, 140, 40, 20, 20);
		endGameWindow.fillRoundRect(230, 405, 140, 40, 20, 20);	
		
		//Write the writing on the buttons
		endGameWindow.setFill(Color.WHITE);
		Font smallFont = Font.font("Times New Roman", FontWeight.BOLD, 15.0);
		endGameWindow.setFont(smallFont);
		endGameWindow.fillText("Restart", 268, 380);
		endGameWindow.fillText("Exit", 285, 430);

		//Creat the selector
		endGameWindow.setStroke(Color.BLACK);
		endGameWindow.setLineWidth(2);
		
		//Depend which option the selector, draw the selector in the corresponding position 
		if (selector == 1) {
			endGameWindow.strokeRoundRect(230, 355, 140, 40, 20, 20);
		} else if (selector == 2) {
			endGameWindow.strokeRoundRect(230, 405, 140, 40, 20, 20);
		}
	    
	}
	
}
