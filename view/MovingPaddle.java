package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Grid;

/*
 * This class is for drawing the paddle on the scene, it go through the whole grid
 * and take the position of paddle, and draw it onto the scene
 */

public class MovingPaddle {
	
	public static void drawPaddle(GraphicsContext gameWindow){
		
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 40; j++){
				//Draw paddle 1
				if (Grid.getObject(j,i) == Grid.Object.PADDLE1){
					gameWindow.setFill(Color.RED);
					gameWindow.fillRect(j * 15, i * 15 + 50, 15, 15);	
				}
				
				//Draw paddle 2
				if (Grid.getObject(j,i) == Grid.Object.PADDLE2){
					gameWindow.setFill(Color.rgb(211,84,0));
					gameWindow.fillRect(j * 15, i * 15 + 50, 15, 15);	
				}
				
				//Draw paddle 3
				if (Grid.getObject(j,i) == Grid.Object.PADDLE3){
					gameWindow.setFill(Color.rgb(46,204,113));
					gameWindow.fillRect(j * 15, i * 15 + 50, 15, 15);	
				}
				
				//Draw paddle 4
				if (Grid.getObject(j,i) == Grid.Object.PADDLE4){
					gameWindow.setFill(Color.rgb(142,63,173));
					gameWindow.fillRect(j * 15, i * 15 + 50, 15, 15);	
				}
			}
		}

	}
}