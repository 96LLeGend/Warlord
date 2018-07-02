package engine;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Paddle;
import model.Warlord;
import model.Grid;


/*
 * This class can control when, where and how we draw the paddle on the screen
 * It provide user interrupt
 */

public class PaddleController {
	
	//Controller for P1's paddle, with key "A" and "D"
	public static void keybordInputP1(Scene scene, Paddle paddle){
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			/*
			 * When A is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will
			 * be different, but generally it follow the "from bottom to top, from right to left" logic
			 */
			if(key.getCode() == KeyCode.A) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(-3);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(-3);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(-3);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-3);
				}
				
			/*
			 * When D is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will
			 * be different, but generally it follow the "from top to bottom, from left to right" logic
			 */
			}else if(key.getCode() == KeyCode.D) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 25){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(3);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(3);	
				}
			}
			
		});
		
		//Clear the paddle from the grid, a paddle has a length of 3 units
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), Grid.Object.EMPTY);
		if (paddle.getXPos() == 14) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 1, Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 2, Grid.Object.EMPTY);
		} else {
			Grid.setObject(paddle.getXPos() + 1, paddle.getYPos(), Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos() + 2, paddle.getYPos(), Grid.Object.EMPTY);
		}
		
		
		//Move the paddle to its new position
		paddle.setXPos(paddle.getXPos() + paddle.getVx());
		paddle.setYPos(paddle.getYPos() + paddle.getVy());
		
		//Make the paddle stop
		paddle.setVx(0);
		paddle.setVy(0);
		
		//If the paddle's new position is out of the frame, move the paddle back inside the frame again
		if (paddle.getXPos() > 14){
			paddle.setXPos(14);
		} else if (paddle.getXPos() < 0){
			paddle.setXPos(0);
		}
		
		if (paddle.getYPos() > 37){
			paddle.setYPos(37);
		} else if (paddle.getYPos() < 25){
			paddle.setYPos(25);
		}
		
		//Set the new paddle position in the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), paddle.getPlayer());
		if (paddle.getXPos() == 14) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 1, paddle.getPlayer());
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 2, paddle.getPlayer());
		} else {
			Grid.setObject(paddle.getXPos() + 1, paddle.getYPos(), paddle.getPlayer());
			Grid.setObject(paddle.getXPos() + 2, paddle.getYPos(), paddle.getPlayer());
		}
				
	}
	
	//Controller for P2's paddle, with key "LEFT" and "RIGHT"
	public static void keybordInputP2(Scene scene, Paddle paddle){
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			/*
			 * When LEFT is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from top to bottom, from right to left" logic
			 */
			if(key.getCode() == KeyCode.LEFT) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(-3);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(-3);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(3);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(3);
				}
				
			/*
			 * When RIGHT is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from bottom to top, from right to left" logic
			 */
			}else if(key.getCode() == KeyCode.RIGHT) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 14){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-3);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(-3);
				}
			}
			
		});
		
		//Clear the paddle from the grid, every paddle has a length of 3 units
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), Grid.Object.EMPTY);
		if (paddle.getXPos() == 14) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 1, Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 2, Grid.Object.EMPTY);
		} else {
			Grid.setObject(paddle.getXPos() + 1, paddle.getYPos(), Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos() + 2, paddle.getYPos(), Grid.Object.EMPTY);
		}
		
		
		//Move the paddle to its new position
		paddle.setXPos(paddle.getXPos() + paddle.getVx());
		paddle.setYPos(paddle.getYPos() + paddle.getVy());
		
		//Make the paddle stop
		paddle.setVx(0);
		paddle.setVy(0);
		
		//If the paddle's new position is out of the frame, move the paddle back inside the frame again
		if (paddle.getXPos() > 14){
			paddle.setXPos(14);
		} else if (paddle.getXPos() < 0){
			paddle.setXPos(0);
		}
		
		if (paddle.getYPos() > 14){
			paddle.setYPos(14);
		} else if (paddle.getYPos() < 2){
			paddle.setYPos(2);
		}
		
		//Set the new paddle position in the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), paddle.getPlayer());
		if (paddle.getXPos() == 14) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 1, paddle.getPlayer());
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 2, paddle.getPlayer());
		} else {
			Grid.setObject(paddle.getXPos() + 1, paddle.getYPos(), paddle.getPlayer());
			Grid.setObject(paddle.getXPos() + 2, paddle.getYPos(), paddle.getPlayer());
		}
				
	}
	
	//Controller for P3's paddle, with key "T" and "Y"
	public static void keybordInputP3(Scene scene, Paddle paddle){
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			/*
			 * When T is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from bottom to the top, from right to left" logic
			 */
			if(key.getCode() == KeyCode.T) {
				if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-3);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-3);
				
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(-3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 14){
					paddle.setVx(-3);
					paddle.setVy(0);
				}
				
			/*When Y is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from top to bottom, from left to right" logic
			 */
			}else if(key.getCode() == KeyCode.Y) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(3);
					
				}else if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(3);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(3);
					paddle.setVy(0);
				}
			}
			
		});
		
		//Clear the paddle from the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), Grid.Object.EMPTY);
		if (paddle.getXPos() == 25) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 1, Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 2, Grid.Object.EMPTY);
		} else {
			Grid.setObject(paddle.getXPos() - 1, paddle.getYPos(), Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos() - 2, paddle.getYPos(), Grid.Object.EMPTY);
		}
		
		
		//Move the paddle to its new position
		paddle.setXPos(paddle.getXPos() + paddle.getVx());
		paddle.setYPos(paddle.getYPos() + paddle.getVy());
		
		//Make the paddle stop
		paddle.setVx(0);
		paddle.setVy(0);
		
		//If the paddle's new position is out of the frame, move the paddle back inside the frame again
		if (paddle.getXPos() > 39){
			paddle.setXPos(39);
		} else if (paddle.getXPos() < 25){
			paddle.setXPos(25);
		}
		
		if (paddle.getYPos() > 14){
			paddle.setYPos(14);
		} else if (paddle.getYPos() < 2){
			paddle.setYPos(2);
		}
		
		//Set the new paddle position in the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), paddle.getPlayer());
		if (paddle.getXPos() == 25) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 1, paddle.getPlayer());
			Grid.setObject(paddle.getXPos(), paddle.getYPos() - 2, paddle.getPlayer());
		} else {
			Grid.setObject(paddle.getXPos() - 1, paddle.getYPos(), paddle.getPlayer());
			Grid.setObject(paddle.getXPos() - 2, paddle.getYPos(), paddle.getPlayer());
		}
				
	}
	
	//Controller for P4's paddle, with key "I" and "O"
	public static void keybordInputP4(Scene scene, Paddle paddle){
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			/*When I is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from top to bottom, from right to left" logic
			 */
			if(key.getCode() == KeyCode.I) {
				if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(3);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(3);
				
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(-3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 25){
					paddle.setVx(-3);
					paddle.setVy(0);
				}
				
			/*When O is pressed, depend on the current position of the paddle, the movement(Vx,Vy) will 
			 * be different, but generally it follow the "from bottom to top, from left to right" logic
			 */
			}else if(key.getCode() == KeyCode.O) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-3);
					
				}else if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-3);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(3);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(3);
					paddle.setVy(0);
				}
			}
			
		});
		
		//Clear the paddle from the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), Grid.Object.EMPTY);
		if (paddle.getXPos() == 25) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 1, Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 2, Grid.Object.EMPTY);
		} else {
			Grid.setObject(paddle.getXPos() - 1, paddle.getYPos(), Grid.Object.EMPTY);
			Grid.setObject(paddle.getXPos() - 2, paddle.getYPos(), Grid.Object.EMPTY);
		}
		
		
		//Move the paddle to its new position
		paddle.setXPos(paddle.getXPos() + paddle.getVx());
		paddle.setYPos(paddle.getYPos() + paddle.getVy());
		
		//Make the paddle stop
		paddle.setVx(0);
		paddle.setVy(0);
		
		//If the paddle's new position is out of the frame, move the paddle back inside the frame again
		if (paddle.getXPos() > 39){
			paddle.setXPos(39);
		} else if (paddle.getXPos() < 25){
			paddle.setXPos(25);
		}
		
		if (paddle.getYPos() > 37){
			paddle.setYPos(37);
		} else if (paddle.getYPos() < 24){
			paddle.setYPos(24);
		}
		
		//Set the new paddle position in the grid
		Grid.setObject(paddle.getXPos(), paddle.getYPos(), paddle.getPlayer());
		if (paddle.getXPos() == 25) {
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 1, paddle.getPlayer());
			Grid.setObject(paddle.getXPos(), paddle.getYPos() + 2, paddle.getPlayer());
		} else {
			Grid.setObject(paddle.getXPos() - 1, paddle.getYPos(), paddle.getPlayer());
			Grid.setObject(paddle.getXPos() - 2, paddle.getYPos(), paddle.getPlayer());
		}
				
	}
	
	
	/*
	 * Find out if the paddle show be exist or not, by checking if the correspond warlord is dead or not
	 */
	public static void destoryPaddle(Warlord P1, Warlord P2, Warlord P3, Warlord P4){
		
		int i, j;
		
		//If P1 is dead, remove its paddle
		if (P1.isDead()){
			for (i = 0; i < 40; i++){
				for(j = 0; j < 40; j++){
					if (Grid.getObject(j, i) == Grid.Object.PADDLE1){
						Grid.setObject(j, i, Grid.Object.EMPTY);
					}
				}
			}
		}
		
		//If P2 is dead, remove its paddle
		if (P2.isDead()){
			for (i = 0; i < 40; i++){
				for(j = 0; j < 40; j++){
					if (Grid.getObject(j, i) == Grid.Object.PADDLE2){
						Grid.setObject(j, i, Grid.Object.EMPTY);
					}
				}
			}
		}
		
		//If P3 is dead, remove its paddle
		if (P3.isDead()){
			for (i = 0; i < 40; i++){
				for(j = 0; j < 40; j++){
					if (Grid.getObject(j, i) == Grid.Object.PADDLE3){
						Grid.setObject(j, i, Grid.Object.EMPTY);
					}
				}
			}
		}
		
		//If P4 is dead, remove its paddle
		if (P4.isDead()){
			for (i = 0; i < 40; i++){
				for(j = 0; j < 40; j++){
					if (Grid.getObject(j, i) == Grid.Object.PADDLE4){
						Grid.setObject(j, i, Grid.Object.EMPTY);
					}
				}
			}
		}
	}

}