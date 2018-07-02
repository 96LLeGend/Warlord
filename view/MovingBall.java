package view;
	
import javafx.scene.paint.Color;
import model.Ball;
import javafx.scene.canvas.GraphicsContext;

/*
 *This class can read the position information of the ball from the grid and draw it on the screen 
 */

public class MovingBall {
	
	public static void drawBall(GraphicsContext gameWindow){	    
		
		gameWindow.setFill(Color.BLUE);
	    gameWindow.fillOval(Ball.getXPos() * 15, Ball.getYPos() * 15 + 50, 15, 15);

	}
}