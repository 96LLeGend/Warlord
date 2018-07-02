package model;

import model.Ball;
import model.Grid.Object;

public class Game {

	/*
	 * This class is for running the game, which coordinate different classes and time the game
	 */
	
	private static int timeRemaining;
	private static int numberOfWarlord;
	private static String winner; 
	
	//Constructor
	public Game(){
		timeRemaining = 120;
		numberOfWarlord = 0;
	};
	
	//Make one move
	public void tick(){
		Ball.update();
	}
	
	//Determine if the game has finish(timesup or only one warlord remain alive)
	public static boolean isFinished(){
		if (timeRemaining == 0 || numberOfWarlord <= 1){
			return true;
		} else {
			return false;
		}
	}
	
	//Increase player number, so that the game know how many warlord on the grid.
	public static void addWarlordToGame(){
		numberOfWarlord ++;
	}
	
	//Decrease player number, when a warlord have been hitted and killed.
	public static void deleteWarlordFromGame(){
		if (numberOfWarlord > 0){	//So that the number of player can never be zero
			numberOfWarlord --;
		}
	}
	
	//Return the time, used for check if the game finish by timesup
	public static int getTimeRemaining(){
		return timeRemaining;
	}
	
	//Return player number, for detemine if there is a winner(which when only one warlord on the grid)
	public static int getNumberOfWarlord(){
		return numberOfWarlord;
	}
	
	//Set the time(Testing purpose)
	public static void setTimeRemaining(int seconds){
		timeRemaining = seconds;
	}
	
	//Use a random number to generate a random initial horizontal directon for the ball 
	public static int setBalldirextionX(){
		
		int X;
		int direction = (int )(Math.random() * 40 + 1);
		
		if (direction >= 0 && direction < 5 ){
			X = -2;
		}else if (direction >= 5 && direction < 10 ){
			X = -1;
		}else if (direction >= 10 && direction < 15 ){
			X = -1;
		}else if (direction >= 15 && direction < 20 ){
			X = 2;
		}else if (direction >= 20 && direction < 25 ){
			X = 1;
		}else if (direction >= 25 && direction < 30 ){
			X = 2;
		}else if (direction >= 30 && direction < 35 ){
			X = -1;
		}else{
			X = -2;
		}
		
		return X;
	}
	
	//Use a random number to generate a random initial horizontal directon for the ball 
	public static int setBalldirextionY(){
		
		int Y;
		int direction = (int )(Math.random() * 40 + 1);
		
		if (direction >= 0 && direction < 5 ){
			Y = -1;
		}else if (direction >= 5 && direction < 10 ){
			Y = -2;
		}else if (direction >= 10 && direction < 15 ){
			Y = -2;
		}else if (direction >= 15 && direction < 20 ){
			Y = -1;
		}else if (direction >= 20 && direction < 25 ){
			Y = 2;
		}else if (direction >= 25 && direction < 30 ){
			Y = 1;
		}else if (direction >= 30 && direction < 35 ){
			Y = 2;
		}else{
			Y = -1;
		}
		
		return Y;
	}
	
	//Find who is the winner
	public static String findWinner(){
		
		//When there just one warlord on the grid
		Object newWinner = Grid.getLastWarlord();
		
		if (numberOfWarlord == 1) {
			if (newWinner == Object.WARLORD1) {
				winner = "P1";
			} else if (newWinner == Object.WARLORD2) {
				winner = "P2";
			} else if (newWinner == Object.WARLORD3) {
				winner = "P3";
			} else if (newWinner == Object.WARLORD4) {
				winner = "P4";
			}

		//In the case of time runs out, just find what kind of wall the grid has the most
		} else {
			
			int highestWallNumber;
			int wall1 = Grid.getObjectNumber(Object.WALL1);
			int wall2 = Grid.getObjectNumber(Object.WALL2);
			int wall3 = Grid.getObjectNumber(Object.WALL3);
			int wall4 = Grid.getObjectNumber(Object.WALL4);
			
			
			if (wall1 >= wall2){
				highestWallNumber = wall1;
				winner = "P1";
			} else {
				highestWallNumber = wall2;
				winner = "P2";
			}
			
			if (highestWallNumber < wall3){
				highestWallNumber = wall3;
				winner = "P3";
			}
			
			if (highestWallNumber < wall4){
				highestWallNumber = wall4;
				winner = "P4";
			}
		}
		return winner;
	}
	
}
