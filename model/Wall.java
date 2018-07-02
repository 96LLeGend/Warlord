package model;

public class Wall {
	
	/*
	This class determine where each "brick" from the wall suport to be, and determine if they been hitted
	*/
	
	private int XPos;
	private int YPos;
	private boolean hitted;

	//Wall constructor, by default the wall is in the centre of the grid and is not been hitted yet
	public Wall(){
		XPos = 0;
		YPos = 0;
		hitted = false;
	}
	
	//Set the brick's horizontal position
	public void setXPos(int x){
		XPos = x;
	}

	//Set the brick's vertical position
	public void setYPos(int y){
		YPos = y;
	}
	
	//Get the brick's horizontal position
	public int getXPos(){
		return XPos;
	}
	
	//Set the brick's vertical position
	public int getYPos(){
		return YPos;
	}
	
	//Set status (hitted or not hitted)
	public void setHitted(boolean isHitted){
		hitted = isHitted;
	}
	
	//Find out if the wall has been destory(return true)
	public boolean isDestroyed(){
		return hitted;
	}
}
