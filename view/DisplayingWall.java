package view;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import model.Grid;

/*
 * This class can manage all the wall at the grid. It can init them(create many new walls) and
 * destory them(let wall.isDestory = true). Note that the Wall class is not used at all
 */

public class DisplayingWall {

	/*
	 * Use for initialize all the wall when the game just begin and no wall has been destory
	 */
	public static void init(){
		
		int i;
		
		/*Player 1*/
		//Row 1 & 2
		for (i = 0; i < 12; i++){
			Grid.setObject(i, 28, Grid.Object.WALL1);
			Grid.setObject(i, 29, Grid.Object.WALL1);
		}
		
		//Row 3 - 12
		for (i = 30; i < 40; i++){
			Grid.setObject(10, i, Grid.Object.WALL1);
			Grid.setObject(11, i, Grid.Object.WALL1);
		}
		
		
		/*Player 2*/
		//Row 1 - 10
		for (i = 0; i < 10; i++){
			Grid.setObject(10, i, Grid.Object.WALL2);
			Grid.setObject(11, i, Grid.Object.WALL2);
		}
		
		//Row 11 & 12
		for (i = 0; i < 12; i++){
			Grid.setObject(i, 10, Grid.Object.WALL2);
			Grid.setObject(i, 11, Grid.Object.WALL2);
		}
				
		
		/*Player 3*/
		//Row 1 - 10
		for (i = 0; i < 10; i++){
			Grid.setObject(28, i, Grid.Object.WALL3);
			Grid.setObject(29, i, Grid.Object.WALL3);
		}
				
		//Row 11 & 12
		for (i = 28; i < 40; i++){
			Grid.setObject(i, 10, Grid.Object.WALL3);
			Grid.setObject(i, 11, Grid.Object.WALL3);
		}
		
		
		/*Player 4*/
		//Row 1 & 2
		for (i = 28; i < 40; i++){
			Grid.setObject(i, 28, Grid.Object.WALL4);
			Grid.setObject(i, 29, Grid.Object.WALL4);
		}
			
		//Row 3 - 12
		for (i = 30; i < 40; i++){
			Grid.setObject(28, i, Grid.Object.WALL4);
			Grid.setObject(29, i, Grid.Object.WALL4);
		}
		
	}
	
	/*
	 *Draw all the wall
	 */
	public static void drawWall(GraphicsContext gameWindow){
		
		int i, j;
		for (i = 0; i < 40; i++){
			for(j = 0; j < 40; j++){
				if (Grid.getObject(j, i) == Grid.Object.WALL1 ||
					Grid.getObject(j, i) == Grid.Object.WALL2 ||
					Grid.getObject(j, i) == Grid.Object.WALL3 ||
					Grid.getObject(j, i) == Grid.Object.WALL4){
					gameWindow.setFill(Color.BLACK);
					gameWindow.fillRect(j * 15, i * 15 + 50, 15, 15);
				}
			}
		}
	}
	
}