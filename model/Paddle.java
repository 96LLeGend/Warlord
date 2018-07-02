package model;

import model.Grid.Object;

public class Paddle {
	
	/*
	*This class set the paddle to its specific position and set up its speed 
	*/
	
	private int XPos;
	private int YPos;
	private int Vx;
	private int Vy;
	private Object player;
	
	//Paddle constructor, by default it is in the centre of the screen, and speed = 0 
	public Paddle(){
		XPos = 0;
		YPos = 0;
		Vx = 0;
		Vy = 0;
	}

	//Set the paddle's horizontal position
	public void setXPos(int x){
		XPos = x;
	}

	//Set the paddle's vertical position
	public void setYPos(int y){
		YPos = y;
	}

	//Get the paddle's vertical position
	public int getXPos(){
		return XPos;
	}

	//Get the paddle's vertical position
	public int getYPos(){
		return YPos;
	}

	//Set traval velocity in horizontal direction
	public void setVx(int Xspeed){
		Vx = Xspeed;
	}

	//Set travel velocity in vertical direction
	public void setVy(int Yspeed){
		Vy = Yspeed;
	}

	//Get traval velocity in horizontal direction
	public int getVx(){
		return Vx;
	}

	//Get travel velocity in vertical direction
	public int getVy(){
		return Vy;
	}
	
	//Set the current paddle belong to which player
	public void setPlayer (Object playerNumber){
		player = playerNumber;
	}
	
	//Return which player is this paddle belong to
	public Object getPlayer(){
		return player;
	}
	
}
