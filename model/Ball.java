package model;


import model.Grid;


public class Ball {

	/*
	This class control the speed and position of the ball, as well as its physics
	*/

	private static int XPos;
	private static int YPos;
	private static int Vx;
	private static int Vy;

	//Ball constructor, by default the ball with be in the centre of the grid and speed is 0(not moving)
	public Ball(){
		XPos = 0;
		YPos = 0;
		Vx = 0;
		Vy = 0;
	}
	
	//Search wall and paddle, then move the ball
	public static void update(){
		
		int i;
		int tempX = XPos;
		int tempY = YPos;
		boolean somethingOnTheWayX = false;
		boolean somethingOnTheWayY = false;
		
		//Check wall and paddle in X axis
		if (Vx >= 0){
			//When the ball travel from the left to right
			for (i = XPos; i < XPos + Vx; i++){
				
				if (i < 39){
					//Check wall in the next piexel
					if (Grid.getObject(i + 1, YPos) == Grid.Object.WALL1 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.WALL2 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.WALL3 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.WALL4){
						//Wall get destory
						Grid.setObject(i + 1, YPos, Grid.Object.EMPTY);
						somethingOnTheWayX = true;
						//Main.soundEffect();
					}
					
					//Check paddle in the next piexel
					if (Grid.getObject(i + 1, YPos) == Grid.Object.PADDLE1 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.PADDLE2 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.PADDLE3 ||
						Grid.getObject(i + 1, YPos) == Grid.Object.PADDLE4){
						somethingOnTheWayX = true;
					}
					
					//Hit the boundry
				} else if (i == 39){
					somethingOnTheWayX = true;
				}
				
				//Once something has found, update the new potential position and break the loop
				if (somethingOnTheWayX){
					tempX = i;	//save the potential new position
					i = XPos + Vx;	//Stop the loop once something has found
					Vx = Vx * -1;	//set new ball velocity
				}
			}
		} else if (Vx < 0){
			//When the ball travel from the right to left
			for (i = XPos; i > XPos + Vx; i--){
				
				
				if (i > 0){
					//Check wall in the perious piexel
					if (Grid.getObject(i - 1, YPos) == Grid.Object.WALL1 ||
						Grid.getObject(i - 1, YPos) == Grid.Object.WALL2 ||
						Grid.getObject(i - 1, YPos) == Grid.Object.WALL3 ||
						Grid.getObject(i - 1, YPos) == Grid.Object.WALL4){
						//Wall get destory
						Grid.setObject(i - 1, YPos, Grid.Object.EMPTY);
						somethingOnTheWayX = true;
						//Main.soundEffect();
					}
					
					//Check paddle in the perious piexel
					if (Grid.getObject(i - 1, YPos) == Grid.Object.PADDLE1 ||
						Grid.getObject(i - 1, YPos) == Grid.Object.PADDLE2 ||	
						Grid.getObject(i - 1, YPos) == Grid.Object.PADDLE3 ||
						Grid.getObject(i - 1, YPos) == Grid.Object.PADDLE4){
						somethingOnTheWayX = true;
					}
					
					//Hit the boundry
				} else if (i == 0){
					somethingOnTheWayX = true;
				}
				
				//Once something has found, update the new potential position and break the loop
				if (somethingOnTheWayX){
					tempX = i;	//save the potential new position
					i = XPos + Vx;	//Stop the loop once the wall has found
					Vx = Vx * -1;	//set new ball velocity
				}
			}
		}
			
		//Check wall and paddle in Y axis
		if (Vy >= 0){
			//When the ball travel from the top to bottom
			for (i = YPos; i < YPos + Vy; i++){
				
				if (i < 39){
					//Check wall in the next piexel
					if (Grid.getObject(XPos, i + 1) == Grid.Object.WALL1 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.WALL2 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.WALL3 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.WALL4){
						//Wall get destory
						Grid.setObject(XPos, i + 1, Grid.Object.EMPTY);
						somethingOnTheWayY = true;
						//Main.soundEffect();
					}
					
					//Check paddle in the next piexel
					if (Grid.getObject(XPos, i + 1) == Grid.Object.PADDLE1 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.PADDLE2 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.PADDLE3 ||
						Grid.getObject(XPos, i + 1) == Grid.Object.PADDLE4){
						somethingOnTheWayY = true;
					}
					
					//Hit the boundry
				} else if (i == 39){
					somethingOnTheWayY = true;
				}
				
				//Once something has found, update the new potential position and break the loop
				if (somethingOnTheWayY){
					tempY = i;	//save the potential new position
					i = YPos + Vy;	//Stop the loop once the wall has found
					Vy = Vy * -1;	//set new ball velocity
				}
			}
		} else if (Vy < 0){
			//When the ball travel from the bottom to top
			for (i = YPos; i > YPos + Vy; i--){
				
				if (i > 0){
					//Check wall in the perious piexel
					if (Grid.getObject(XPos, i - 1) == Grid.Object.WALL1 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.WALL2 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.WALL3 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.WALL4){
						//Wall get destory
						Grid.setObject(XPos, i - 1, Grid.Object.EMPTY);
						somethingOnTheWayY = true;
						//Main.soundEffect();
					}
					
					//Check paddle in the perious piexel
					if (Grid.getObject(XPos, i - 1) == Grid.Object.PADDLE1 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.PADDLE2 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.PADDLE3 ||
						Grid.getObject(XPos, i - 1) == Grid.Object.PADDLE4){
						somethingOnTheWayY = true;
					}
					
					//Hit the boundry
				} else if (i == 0){
					somethingOnTheWayY = true;
				}
				
				//Once something has found, update the new potential position and break the loop
				if (somethingOnTheWayY){
					tempY = i;	//save the potential new position
					i =  YPos + Vy;	//Stop the loop once the wall has found
					Vy = Vy * -1;	//set new ball velocity
				}
			}
		}

		//In the case that no wall or paddle is on the path of the ball
		if (!somethingOnTheWayX){
			tempX = XPos + Vx;
		}
		if (!somethingOnTheWayY){
			tempY = YPos + Vy;
		}
		
		//Check if the ball hit the edge of the frame in X direction
		if (tempX > 39){	 
			XPos = 77 - tempX;	//Set new position
			
			//Change the direction of the ball as it bounce back 
			if (!somethingOnTheWayX){Vx = Vx * -1;}
			
		} else if (tempX < 0){
			XPos = tempX * -1;	//Set new position
			
			//Change the direction of the ball as it bounce back 
			if (!somethingOnTheWayX){Vx = Vx * -1;}
			
			//Nothing on the way, just change the position
		} else {
			XPos = tempX;			
		}

		//Check if the ball hit the edge of the frame in Y direction 
		if (tempY > 39){	 
			YPos = 77 - tempY;	//Set new position
			
			//Change the direction of the ball as it bounce back 
			if (!somethingOnTheWayY){Vy = Vy * -1;}
			
		} else if (tempY < 0){
			YPos = tempY * -1;	//Set new position
			
			//Change the direction of the ball as it bounce back 
			if (!somethingOnTheWayY){Vy = Vy * -1;}
			
			//Nothing on the way, just change the position
		} else {
			YPos = tempY;
		}
				
	}
	
	//Set hrizontal position
	public void setXPos(int x){
		XPos = x;
	}

	//Set vertical position
	public void setYPos(int y){
		YPos = y;
	}

	//Get the hrizontal position
	public static int getXPos(){
		return XPos;
	}

	//Get the vertical position
	public static int getYPos(){
		return YPos;
	}

	//Set traval velocity in horizontal direction
	public void setXVelocity(int XSpeed){
		Vx = XSpeed;
	}

	//Set travel velocity in vertical direction
	public void setYVelocity(int YSpeed){
		Vy = YSpeed;
	}

	//Get traval velocity in horizontal direction
	public int getXVelocity(){
		return Vx;
	}

	//Get travel velocity in vertical direction
	public int getYVelocity(){
		return Vy;
	}

}
