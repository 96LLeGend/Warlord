package view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Game;
import model.Warlord;
import javafx.scene.canvas.GraphicsContext;
import view.DisplayingWarlord;
/*
 * This class is for drawing the warlord at four corners.
 * It will check the status of four warlord and decide to draw it or not
 */

public class DisplayingWarlord {
	
	public static void drawWarlord(Warlord P1, Warlord P2, Warlord P3, Warlord P4, GraphicsContext gameWindow){
		//If no warlord at all, no need to run --save resource
		if(Game.getNumberOfWarlord() > 0){
			
			//Set up the font
			Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 20.0);
			gameWindow.setFont(theFont);
			
			
			//If P1 is not dead, draw its
			if (!P1.isDead()){
				gameWindow.setFill(Color.RED);
				gameWindow.fillRect(0, 530, 120, 120);
				gameWindow.setFill(Color.WHITE);
				gameWindow.fillText("P1", 10, 640);	
			}
			
			//If P2 is not dead, draw it
			if (!P2.isDead()){
				gameWindow.setFill(Color.rgb(211,84,0));
				gameWindow.fillRect(0, 50, 120, 120);	
				gameWindow.setFill(Color.WHITE);
				gameWindow.fillText("P2", 10, 80);
			}
			
			//If P3 is not dead, draw it
			if (!P3.isDead()){
				gameWindow.setFill(Color.rgb(46,204,113));
				gameWindow.fillRect(480, 50, 120, 120);
				gameWindow.setFill(Color.WHITE);
				gameWindow.fillText("P3", 560, 80);
			}
			
			//If P4 is not dead, draw it
			if (!P4.isDead()){
				gameWindow.setFill(Color.rgb(142,63,173));
				gameWindow.fillRect(480, 530, 120, 120);
				gameWindow.setFill(Color.WHITE);
				gameWindow.fillText("P4", 560, 640);
			}
		}
	}
}