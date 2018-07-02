package model;

public class Grid {
	
	/*
	*This class create a "map" for the ball, the ball just need to look at the "map"
	*to identify if there is something(warlord, paddle, wall in the current spot
	*/
	
	//Enum for different objects
	public enum Object {
	    EMPTY, PADDLE1, PADDLE2, PADDLE3, PADDLE4, WALL1, WALL2, WALL3, WALL4, WARLORD1, WARLORD2, WARLORD3, WARLORD4;
	}
	
	//Create the grid
	private static Object[][] grid = new Object[40][40];
	
	//Constructor, the grid is empty when created
	public Grid(){
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 40; j++){
				grid[i][j] = Object.EMPTY;
			}
		}
	}
	
	//Set the object in a specific spot
	public static void setObject(int x, int y, Object object){
		grid[y][x] = object;
	}
	
	//Get the object in a specific spot
	public static Object getObject(int x, int y){
		return grid[y][x];
	}
	
	//Get the last warlord(For determine who is the winner)
	public static Object getLastWarlord(){
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 40; j++){
				if (grid[j][i] == Object.WARLORD1){
					return Object.WARLORD1;
				} else if (grid[j][i] == Object.WARLORD2){
					return Object.WARLORD2;
				} else if (grid[j][i] == Object.WARLORD3){
					return Object.WARLORD3;
				} else if (grid[j][i] == Object.WARLORD4){
					return Object.WARLORD4;
				}
			}
		}
		
		return Object.EMPTY;
	}
		
	//Get the number of wall(For determine who is the winner)
	public static int getObjectNumber(Object object){
		
		int X = 0;
		
		for(int i = 0; i < 40; i++){
			for(int j = 0; j < 40; j++){
				if (grid[j][i] == object){
					X++;
				} 
			}
		}
		
		return X;
	}
}