package model;

import model.Grid;
import model.Grid.Object;

public class Warlord {

	/*
	 * This class customize the player and determind if they are killed
	 */
	
	private static int XPos;
	private static int YPos;
	private boolean hitted;
	private Object player;
	
	/*Warlord constructor, by default they are in the middle of the grid in the beginning
	and haven been hitted. When a warlord is create, the warLord number under the Game 
	class will be updated as well*/
	public Warlord(){
		XPos = 0;
		YPos = 0;
		hitted = false;
		Game.addWarlordToGame();
	}
	
	//Set the horizontal position of the warlord
	public void setXPos(int x){
		XPos = x;
	}
	
	//Set the vertical position of the warlord
	public void setYPos(int y){
		YPos = y;
	}
	
	//Get the horizontal position of the warlord
	public static int getXPos(){
		return XPos;
	}
	
	//Set the vertical position of the warlord
	public static int getYPos(){
		return YPos;
	}
	
	//Determine if the warlord have been hitted, therefore it is dead
	public boolean isDead(){
		return hitted;
	}
	
	/*Determine if the warlord win the game, by checking if there is other players on the 
	grid or if the warlord destory the highest number of the war when times up*/
	public boolean hasWon(){
		if (Game.getNumberOfWarlord() == 1 || Game.getTimeRemaining() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	//Set which player this warlord belong to
	public void setPlayer(Object playerNumber){
		player = playerNumber;
	}
	
	//Return which player this warlord belong to
	public Object getPlayer(){
		return player;
	}
	
	/*
	 * Check if the ball land in one of the warlord spot, if so the warlord will be killed.
	 * The warlords number under the Game class is updated as well 
	 */
	public void checkHitted(int x, int y){
		if (this.hitted == false){
			if (Grid.getObject(x,y) == player){
				this.hitted = true;
				Game.deleteWarlordFromGame();
			}
		}
	}
}
