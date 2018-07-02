package engine;

import model.Paddle;
import model.Grid;
import model.Ball;


/*
 * This class can control when, where and how we draw the paddle on the screen
 */

public class AI{
	
	//AI who control the player1(bottom-left warlord)
	public static void AIForP1(Paddle paddle){
		
		//When the ball at the bottom right corner
		if (Ball.getXPos() > 15 && Ball.getYPos() > 24) {
			
			//Paddle move upward when the ball is higher than the paddle
			if(Ball.getYPos() < paddle.getYPos()) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-1);
				}
				
			//Paddle move downward when the ball is higher than the paddle
			}else if(Ball.getYPos() > paddle.getYPos()) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(1);	
				}
			}
			
		//When the ball at the top left corner
		} else if (Ball.getXPos() <= 15 && Ball.getYPos() <= 24) {
			
			//Paddle move toward left when the ball is at the left handside of the paddle
			if(Ball.getXPos() < paddle.getXPos()) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-1);
				}
			
			//Paddle move toward right when the ball is at the left handside of the paddle
			}else if(Ball.getXPos() > paddle.getXPos()) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 25 && paddle.getYPos() < 39){
					paddle.setVx(0);
					paddle.setVy(1);	
				}
			}
		}
			
		//Clear the paddle from the grid
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
	
	//AI who control the player2(top-left warlord)
	public static void AIForP2(Paddle paddle){
			
		//When the ball at the top right corner
		if (Ball.getXPos() > 15 && Ball.getYPos() < 15) {
			
			//Paddle move upward when the ball is higher than the paddle
			if(Ball.getYPos() < paddle.getYPos()) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(-1);
				}
				
			//Paddle move downward when the ball is higher than the paddle
			}else if(Ball.getYPos() > paddle.getYPos()) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(1);
				}
			}
				
			//When the ball at the bottom left corner
		} else if (Ball.getXPos() < 15 && Ball.getYPos() > 15) {
				
			//Paddle move toward left when the ball is at the left handside of the paddle
			if(Ball.getXPos() < paddle.getXPos()) {
				if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(1);
				}
				
			//Paddle move toward right when the ball is at the left handside of the paddle
			}else if(Ball.getXPos() > paddle.getXPos()) {
				if(paddle.getXPos() == 0 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 0 && paddle.getXPos() < 14 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 14 && paddle.getYPos() > 0 && paddle.getYPos() < 14){
					paddle.setVx(0);
					paddle.setVy(-1);
				}
			}
		}
		
		//Clear the paddle from the grid
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

	//AI who control the player3(top-right warlord)
	public static void AIForP3(Paddle paddle){
		
		//When the ball at the top left corner
		if (Ball.getXPos() < 25 && Ball.getYPos() < 15) {
			
			//Paddle move upward when the ball is higher than the paddle
			if(Ball.getYPos() < paddle.getYPos()) {
				if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-1);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-1);
				
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(-1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				}
				
			//Paddle move downward when the ball is higher than the paddle
			}else if(Ball.getYPos() > paddle.getYPos()) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(1);
					paddle.setVy(0);
				}
			}
				
			//When the ball at the bottom right corner
		} else if (Ball.getXPos() >= 25 && Ball.getYPos() > 15) {
				
			//Paddle move toward left when the ball is at the left handside of the paddle
			if(Ball.getXPos() < paddle.getXPos()) {
				if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-1);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(0);
					paddle.setVy(-1);
				
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(-1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 14){
					paddle.setVx(-1);
					paddle.setVy(0);
				}
				
			//Paddle move toward right when the ball is at the left handside of the paddle
			}else if(Ball.getXPos() > paddle.getXPos()) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 0){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getYPos() > 0 && paddle.getYPos() < 14 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 14){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getYPos() == 14 && paddle.getXPos() > 25 && paddle.getXPos() < 39){
					paddle.setVx(1);
					paddle.setVy(0);
				}
			}
		}
		
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

	//AI who control the player4(bottom-right warlord)
	public static void AIForP4(Paddle paddle){
		
		//When the ball at the bottom left corner
		if (Ball.getXPos() <= 24 && Ball.getYPos() >= 24) {
			
			//Paddle move upward when the ball is higher than the paddle
			if(Ball.getYPos() < paddle.getYPos()) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
				}
				
			//Paddle move downward when the ball is higher than the paddle
			}else if(Ball.getYPos() > paddle.getYPos()) {
				if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
				
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				}
			}
				
			//When the ball at the top right corner
		} else if (Ball.getXPos() > 24 && Ball.getYPos() < 24) {
				
			//Paddle move toward left when the ball is at the left handside of the paddle
			if(Ball.getXPos() < paddle.getXPos()) {
				if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
				
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(0);
					paddle.setVy(1);
				
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() == 39 && paddle.getYPos() == 25){
					paddle.setVx(-1);
					paddle.setVy(0);
				}
				
			//Paddle move toward right when the ball is at the left handside of the paddle
			}else if(Ball.getXPos() > paddle.getXPos()) {
				if(paddle.getXPos() == 25 && paddle.getYPos() == 39){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getYPos() > 25 && paddle.getYPos() < 39 && paddle.getXPos() == 25){
					paddle.setVx(0);
					paddle.setVy(-1);
					
				}else if(paddle.getXPos() == 25 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
					
				}else if(paddle.getXPos() > 25 && paddle.getXPos() < 39 && paddle.getYPos() == 25){
					paddle.setVx(1);
					paddle.setVy(0);
				}
			}
		}
		
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
	
}