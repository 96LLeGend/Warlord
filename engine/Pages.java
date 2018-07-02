package engine;

import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Ball;
import model.Paddle;
import model.Game;
import model.Grid;
import model.Warlord;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import engine.PaddleController;
import engine.AI;
import engine.Interrupt;
import view.MovingBall;
import view.MovingPaddle;
import view.DisplayingWarlord;
import view.DisplayingWall;
import view.DisplaySelector;
import view.DisplayTime;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

/*
 * This class the main controller, it control what to show, what function, what it does on every 
 * single pages/menu in the game
 */


public class Pages {

	//Three selectors used for 3 menus
	private static int numberSelector = 1;
	private static int optionsSelector = 1;
	private static int endSelector = 1;
	
	/*
	 * The main menu page
	 */
	public static void mainMenu(){
		
		//By defalut the game select the first option for the user
		optionsSelector = 1;
		
		//Create stage for the current page
		Stage mainMenuStage = new Stage();
		mainMenuStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create canvas and graphicsContext for drawing on the current page
		Canvas newMainMenu = new Canvas(600, 650);
	    GraphicsContext mainWindow = newMainMenu.getGraphicsContext2D();
	    
	    //Import background image
	    Image armor = new Image("armor.jpg", 600, 400, false, false);
	    mainWindow.drawImage(armor, 0, 0);
	    
	    //Create scene for the current page
	    VBox menu = new VBox(5);     
		menu.getChildren().addAll(newMainMenu);
		Scene scene = new Scene(menu, 600, 650);
		
	    //Sound effect
	   /* String musicFile = "mainbgm.mp3";    
	    Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);*/
	    
	    //Draw the page
	    DisplaySelector.mainMenu(mainWindow, optionsSelector);
       	
	    //The options selecting mechanism 
    	scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
    				
    			/*    			 
    			 * When UP pressed, selector go up(-1), if it already selecting the first option(1),
    			 * go back to the last one(4)
    			 */    		
 				if (key.getCode() == KeyCode.UP) {
   					if (optionsSelector - 1 < 1){
   						optionsSelector = 4;
   					} else {
   						optionsSelector--;
   					}
   					DisplaySelector.mainMenu(mainWindow, optionsSelector);
   				
   					
   				/*    			 
   	    		 * When DOWN pressed, selector go down(+1), if it already selecting the last option(4),
   	    		 * go back to the first one(1)
   	    		*/   
   				} else if (key.getCode() == KeyCode.DOWN) {
   					if (optionsSelector + 1 > 4){
   						optionsSelector = 1;
   					} else {
   						optionsSelector++;
   					}
   					DisplaySelector.mainMenu(mainWindow, optionsSelector);
    					
   					
   				/*
   				 * Act the option that the selector select, while ENTER is pressed
   				 */
   				} else if (key.getCode() == KeyCode.ENTER) {
    				if (optionsSelector == 1){
    					//To select the number of players
    					mainMenuStage.close();
    					Pages.playersNumber(); 
    					    						
    				} else if (optionsSelector == 2){
    					//To helpCentre (For checking buttons)
    					mainMenuStage.close();
    					Pages.helpCentre(); 
    						
    				} else if (optionsSelector == 3){
    					//To about page (For checking developers)
    					mainMenuStage.close();
    					Pages.about();     					
    						
    				} else if (optionsSelector == 4){
    					//Exit game (close the window)
    					mainMenuStage.close();
    				}
    		}
    	});  
    	 	
	    mainMenuStage.setScene(scene);
		mainMenuStage.show();
		
	}

	
	/*
	 * The first game mode : demo, which the computer play with itself;
	 */
	public static void demo(){
		
		//Create stage for the current page
		Stage demoStage = new Stage();
		demoStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);

		/*
		 * Set up game first
		 */
		Game game = new Game();
				
		Grid grid = new Grid();

		DisplayingWall.init();
				
		//Set up ball
		Ball ball = new Ball();
		ball.setXPos(19);
		ball.setYPos(19);
				
		//Use a random number to generate a random initial directon for the ball 
		ball.setXVelocity(Game.setBalldirextionX());
		ball.setYVelocity(Game.setBalldirextionY());
				
		//Set up player's paddle
		Paddle paddle1 = new Paddle();
		paddle1.setXPos(14);
		paddle1.setYPos(25);
		paddle1.setPlayer(Grid.Object.PADDLE1);
				
		Paddle paddle2 = new Paddle();
		paddle2.setXPos(14);
		paddle2.setYPos(14);
		paddle2.setPlayer(Grid.Object.PADDLE2);
				
		Paddle paddle3 = new Paddle();
		paddle3.setXPos(25);
		paddle3.setYPos(14);
		paddle3.setPlayer(Grid.Object.PADDLE3);
				
		Paddle paddle4 = new Paddle();
		paddle4.setXPos(25);
		paddle4.setYPos(25);
		paddle4.setPlayer(Grid.Object.PADDLE4);
			
		//Set up warlords
		Warlord P1 = new Warlord();
		P1.setXPos(0);
		P1.setYPos(32);
		P1.setPlayer(Grid.Object.WARLORD1);
		for(int i = 32; i < 40; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD1);
			}
		}
				
		Warlord P2 = new Warlord();
		P2.setXPos(0);
		P2.setYPos(0);
		P2.setPlayer(Grid.Object.WARLORD2);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD2);
			}
		}
				
		Warlord P3 = new Warlord();
		P3.setXPos(32);
		P3.setYPos(0);
		P3.setPlayer(Grid.Object.WARLORD3);
		for(int i = 0; i < 8; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD3);
			}
		}
				
		Warlord P4 = new Warlord();
		P4.setXPos(32);
		P4.setYPos(32);
		P4.setPlayer(Grid.Object.WARLORD4);
		for(int i = 32; i < 40; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD4);
			}
		}
				
		//Create canvas for drawing on the current page
		Canvas canvas = new Canvas(600, 650);
		GraphicsContext gameWindow = canvas.getGraphicsContext2D();

			    
		//Animation start
		Timeline TL = new Timeline();
		TL.setCycleCount(Animation.INDEFINITE);
		KeyFrame gameOn = new KeyFrame(Duration.seconds(.01),
		new EventHandler<ActionEvent>() {

		    	int frameHold = 0;
		      	int currentFrame = 0;
		       	int countdownFrame = 500;
		       	int run = 0;
		        	
		       	public void handle(ActionEvent event) {

		     	   //clear the screen
		       	   root.getChildren().clear();
		       	   root.getChildren().add(canvas);
		   		   gameWindow.clearRect(0, 0, 600, 650);
		    		   
		   		   //Countdown for start
		   		   countdownFrame--;
		   		   Interrupt.countdownForStart(countdownFrame); 
		    	
		   		   //Check if "P" is press, if so pause or resume
		   		   if (countdownFrame <= 0) {		    		   
		    		   run = Interrupt.pause(scene, run);
		   		   }
		   		   
		   		 /*
		   		  * When it is not pause the controllers will kick in and keep updating the game according the game model,
		   		  * otherwise just displaying the current stage without updating
		   		  */   		   		   
		   		   if (run == 1){
		    		   //The ball on get update every 5 frame instead of 1, so that the paddle can 
		   			   //speed up(higher frame rate) with speed the ball
		    		   if (frameHold == 5){
			    		   game.tick();
			    		   frameHold = 0;
		    		   } else {
		    			   frameHold++;
		    		   }
			    		   
		    		   //Time control,  fast foward (for testing) or normal, or exit the game straight away
		    		   scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			 			   
		    				//When BACKSPACE is pressed, time will faster forward to the 
		    			    //last 1 seconds(For testing purpose)
		    				if(key.getCode() == KeyCode.BACK_SPACE) {
		    					currentFrame = 11900; 
		    				//When ESC is pressed, return to main menu, via set time to the beyond last second
		    				} else if (key.getCode() == KeyCode.ESCAPE){
		    					 currentFrame = 13000;
		    				}
		    			});
		    		    currentFrame++;
		    		    
		    		    //Escape and back to main menu
		    		    if (currentFrame == 13001){
		    		    	TL.pause();
	    					demoStage.close();
			    			Pages.mainMenu();
		    		    }

		    		   //Determine if the game has finish
		    		   if (Game.isFinished()){
		    			  TL.pause();
		    			  
		    			  //Return to main menu
		    			  demoStage.close();
		    			  Pages.endGame(P1, P2, P3, P4, 0);
		    			  
		    			  //if it is not finish refresh the time remaining
		    		   } else {
		    			  Game.setTimeRemaining(120 - (currentFrame / 100));
		    		   }

		    		   //Check if any warlord get hitted
		    		   P1.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P2.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P3.checkHitted(ball.getXPos(), ball.getYPos());
			   		   P4.checkHitted(ball.getXPos(), ball.getYPos());
			    			         
			   		   //Update players' paddle in the model
			   		   AI.AIForP1(paddle1);
			   		   AI.AIForP2(paddle2);
			   		   AI.AIForP3(paddle3);
			   		   AI.AIForP4(paddle4);
		    	           
		    	   }
		    		   
		    		   
		    	   //Header
		    	   gameWindow.setFill(Color.BLACK);
		    	   gameWindow.fillRect(0, 45, 600, 5);
		    	   
		    	   //Display time
		    	   DisplayTime.countDown(gameWindow);
		    	   
		    	   //Display game status
		    	   DisplayTime.status(gameWindow, countdownFrame);
		    		    	
		    	   //Remove the destoried warlords' paddle
		    	   PaddleController.destoryPaddle(P1, P2, P3, P4);
		    		   
		    	   //Move the ball
		    	   MovingBall.drawBall(gameWindow);
		    		   
		    	   //Draw the warlords
		    	   DisplayingWarlord.drawWarlord(P1, P2, P3, P4, gameWindow);
		    		   
		    	   //Move(or not move) the player's paddle
		    	   MovingPaddle.drawPaddle(gameWindow);
			        	
		    	   //Draw all the walls
		    	   DisplayingWall.drawWall(gameWindow);
		    	      		   
		        }	
		    });

		    TL.getKeyFrames().add(gameOn);
		    TL.play();
		        
	   demoStage.setScene(scene);
	   demoStage.show();
						
	}

	/*
	 * The second game mode: 1 player with 3 AI
	 */
	public static void single(){
		
		//Create stage for the current page
		Stage singlePlayerStage = new Stage();
		singlePlayerStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);

		/*
		 * Set up game first
		 */
		Game game = new Game();
		
		Grid grid = new Grid();

		DisplayingWall.init();
		
		//Set up ball
		Ball ball = new Ball();
		ball.setXPos(19);
		ball.setYPos(19);
		
		//Use a random number to generate a random initial directon for the ball 
		ball.setXVelocity(Game.setBalldirextionX());
		ball.setYVelocity(Game.setBalldirextionY());
		
		//Set up player's paddle
		Paddle paddle1 = new Paddle();
		paddle1.setXPos(14);
		paddle1.setYPos(25);
		paddle1.setPlayer(Grid.Object.PADDLE1);
		
		Paddle paddle2 = new Paddle();
		paddle2.setXPos(14);
		paddle2.setYPos(14);
		paddle2.setPlayer(Grid.Object.PADDLE2);
		
		Paddle paddle3 = new Paddle();
		paddle3.setXPos(25);
		paddle3.setYPos(14);
		paddle3.setPlayer(Grid.Object.PADDLE3);
		
		Paddle paddle4 = new Paddle();
		paddle4.setXPos(25);
		paddle4.setYPos(25);
		paddle4.setPlayer(Grid.Object.PADDLE4);
		
		//Set up warlord
		Warlord P1 = new Warlord();
		P1.setXPos(0);
		P1.setYPos(32);
		P1.setPlayer(Grid.Object.WARLORD1);
		for(int i = 32; i < 40; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD1);
			}
		}
		
		Warlord P2 = new Warlord();
		P2.setXPos(0);
		P2.setYPos(0);
		P2.setPlayer(Grid.Object.WARLORD2);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD2);
			}
		}
		
		Warlord P3 = new Warlord();
		P3.setXPos(32);
		P3.setYPos(0);
		P3.setPlayer(Grid.Object.WARLORD3);
		for(int i = 0; i < 8; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD3);
			}
		}
		
		Warlord P4 = new Warlord();
		P4.setXPos(32);
		P4.setYPos(32);
		P4.setPlayer(Grid.Object.WARLORD4);
		for(int i = 32; i < 40; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD4);
			}
		}
		
		//Create canvas for drawing on the current page
		Canvas canvas = new Canvas(600, 650);
	    GraphicsContext gameWindow = canvas.getGraphicsContext2D();
	    
	    //Animation start
	    Timeline TL = new Timeline();
        TL.setCycleCount(Animation.INDEFINITE);
        KeyFrame gameOn = new KeyFrame(Duration.seconds(.01),
        new EventHandler<ActionEvent>() {

        	int frameHold = 0;
        	int currentFrame = 0;
        	int countdownFrame = 500;
        	int run = 0;
        	
        	public void handle(ActionEvent event) {

        	   //clear the screen
        	   root.getChildren().clear();
        	   root.getChildren().add(canvas);
    		   gameWindow.clearRect(0, 0, 600, 650);
    		   
    		  
    		   //Countdown for start
    		   countdownFrame--;
    		   Interrupt.countdownForStart(countdownFrame); 
    		   
    		   //Check if "P" is press, if so pause or resume
    		   if (countdownFrame <= 0) {		    		   
	    		   run = Interrupt.pause(scene, run);
    		   }
    		   
    		   /*
	   		    * When it is not pause the controllers will kick in and keep updating the game according the game model,
	   		    * otherwise just displaying the current stage without updating
	   		    */
    		   if (run == 1){
    			 //The ball on get update every 5 frame instead of 1, so that the paddle can 
	   			   //speed up(higher frame rate) with speed the ball
	    		   if (frameHold == 5){
		    		   game.tick();
		    		   frameHold = 0;
	    		   } else {
	    			   frameHold++;
	    		   }
	   
	    		   //Time control,  fast foward (for testing) or normal, or exit the game straight away
	    		   scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		 			   
	    			 //When BACKSPACE is pressed, time will faster forward to the 
	    			    //last 1 seconds(For testing purpose)
	    				if(key.getCode() == KeyCode.BACK_SPACE) {
	    					currentFrame = 11900; 
	    					//When ESC is pressed, return to main menu, via set time to beyond the last second
	    				} else if (key.getCode() == KeyCode.ESCAPE){
	    					 currentFrame = 13000;
	    				}
	    			});
	    		    currentFrame++;
	    		    
	    		    //Escape back to the main menu
	    		    if (currentFrame == 13001){
	    		    	TL.pause();
   					 	singlePlayerStage.close();
		    			Pages.mainMenu();
	    		    }
	    			
	    		   //Determine if the game has finish
	    		   if (Game.isFinished()){
	    			  TL.pause();
	    			//Return to main menu	
	    			  singlePlayerStage.close();
	    			  Pages.endGame(P1, P2, P3, P4, 1);
	    			  
	    			  //if it is not refresh the time remaining
	    		   } else {
	    			  Game.setTimeRemaining(120 - (currentFrame / 100));
	    		   }

	    		   //Check if any warlord get hitted
	    		   P1.checkHitted(ball.getXPos(), ball.getYPos());
	    		   P2.checkHitted(ball.getXPos(), ball.getYPos());
	    		   P3.checkHitted(ball.getXPos(), ball.getYPos());
	    		   P4.checkHitted(ball.getXPos(), ball.getYPos());
	    			         
	    		   //Update players' paddle in the model
	    		   PaddleController.keybordInputP1(scene, paddle1);
	    		   AI.AIForP2(paddle2);
	    		   AI.AIForP3(paddle3);
	    		   AI.AIForP4(paddle4);
    		           
    		   }
    		   
    		   
    		   //Header
    		   gameWindow.setFill(Color.BLACK);
    		   gameWindow.fillRect(0, 45, 600, 5);
    		   
    		   //Display time
    		   DisplayTime.countDown(gameWindow);
    		   
    		   //Display game status
    		   DisplayTime.status(gameWindow, countdownFrame);
    		    	
    		   //Remove the destoried warlords' paddle
    		   PaddleController.destoryPaddle(P1, P2, P3, P4);
    		   
    		   //Move the ball
    		   MovingBall.drawBall(gameWindow);
    		   
    		   //Draw the warlords
    		   DisplayingWarlord.drawWarlord(P1, P2, P3, P4, gameWindow);
    		   
    		   //Move(or not move) the player's paddle
    		   MovingPaddle.drawPaddle(gameWindow);
	        	
    		   //Draw all the walls
    		   DisplayingWall.drawWall(gameWindow);
    	      		   
        	}	
        });

        TL.getKeyFrames().add(gameOn);
        TL.play();
        
        singlePlayerStage.setScene(scene);
        singlePlayerStage.show();
	
	}

	/*
	 * Menu for the player to select how human players are playing
	 */
	public static void playersNumber(){
	
		//By defalut the game select the first option for the user
		numberSelector = 1;
		
		//Create stage for the current page
		Stage playersNumberStage = new Stage();
		playersNumberStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create stage for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);
		
		//Create canvas for drawing on the current page
		Canvas playersNumber = new Canvas(600, 650);
	    GraphicsContext chooseNumber = playersNumber.getGraphicsContext2D();		
		
	    //Some "art work"
	    chooseNumber.setFill(Color.rgb(116,109,118));
	    chooseNumber.fillRect(0, 0, 120, 650);
	    chooseNumber.fillRect(480, 0, 120, 650);

	    //Sound effect, need extra part for it to play
	    /*String musicFile = "mainbgm.mp3";    
	    Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);*/
	    
    	root.getChildren().add(playersNumber);
    	
    	//Draw the page
    	DisplaySelector.selectPlayerNumber(chooseNumber, 1);
    	
    	//The selector mechanism
    	scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
    		/*    			 
			 * When UP pressed, selector go up(-1), if it already selecting the first option(1),
			 * go back to the last one(6)
			 */  
				if (key.getCode() == KeyCode.UP) {
					if (numberSelector - 1 < 1){
						numberSelector = 6;
					} else {
						numberSelector--;
					}
					DisplaySelector.selectPlayerNumber(chooseNumber, numberSelector);
					
				/*    			 
	   	    	 * When DOWN pressed, selector go down(+1), if it already selecting the last option(6),
	   	    	 * go back to the first one(1)
	   	    	*/   
				} else if (key.getCode() == KeyCode.DOWN) {
					if (numberSelector + 1 > 6){
						numberSelector = 1;
					} else {
						numberSelector++;
					}
					DisplaySelector.selectPlayerNumber(chooseNumber, numberSelector);
					
				/*
	   			 * Act the option that the selector select, while ENTER is pressed
	   			 */
				} else if (key.getCode() == KeyCode.ENTER) {
					if (numberSelector == 1){
						//To the demo page
						playersNumberStage.close();
						Pages.demo(); 
							
					} else if (numberSelector == 2){
						//To the single player page
						playersNumberStage.close();
						Pages.single(); 
							
					} else if (numberSelector == 3){
						//To the two players page
						playersNumberStage.close();
						Pages.twoPlayers(); 
						
					} else if (numberSelector == 4){
						//To the three players page
						playersNumberStage.close();
						Pages.threePlayers(); 
						
					} else if (numberSelector == 5){
						//To the four players page
						playersNumberStage.close();
						Pages.fourPlayers(); 
						
					} else if (numberSelector == 6){
						//Go back to the main menu
						playersNumberStage.close();
						Pages.mainMenu(); 
						
					}
		}
	});
    	
    	playersNumberStage.setScene(scene);
    	playersNumberStage.show();
	}
	
	/*
	 * The third game mode: 2 players with 2 AI
	 */
	public static void twoPlayers(){
		
		//Create stage for the current page
		Stage twoPlayerStage = new Stage();
		twoPlayerStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);

		/*
		 * Set up game first
		 */
		Game game = new Game();
				
		Grid grid = new Grid();

		DisplayingWall.init();
				
		//Set up ball
		Ball ball = new Ball();
		ball.setXPos(19);
		ball.setYPos(19);
				
		//Use a random number to generate a random initial directon for the ball 
		ball.setXVelocity(Game.setBalldirextionX());
		ball.setYVelocity(Game.setBalldirextionY());
				
		//Set up player's paddle
		Paddle paddle1 = new Paddle();
		paddle1.setXPos(14);
		paddle1.setYPos(25);
		paddle1.setPlayer(Grid.Object.PADDLE1);
				
		Paddle paddle2 = new Paddle();
		paddle2.setXPos(14);
		paddle2.setYPos(14);
		paddle2.setPlayer(Grid.Object.PADDLE2);
				
		Paddle paddle3 = new Paddle();
		paddle3.setXPos(25);
		paddle3.setYPos(14);
		paddle3.setPlayer(Grid.Object.PADDLE3);
				
		Paddle paddle4 = new Paddle();
		paddle4.setXPos(25);
		paddle4.setYPos(25);
		paddle4.setPlayer(Grid.Object.PADDLE4);
			
		//Set up warlord
		Warlord P1 = new Warlord();
		P1.setXPos(0);
		P1.setYPos(32);
		P1.setPlayer(Grid.Object.WARLORD1);
		for(int i = 32; i < 40; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD1);
			}
		}
				
		Warlord P2 = new Warlord();
		P2.setXPos(0);
		P2.setYPos(0);
		P2.setPlayer(Grid.Object.WARLORD2);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD2);
			}
		}
				
		Warlord P3 = new Warlord();
		P3.setXPos(32);
		P3.setYPos(0);
		P3.setPlayer(Grid.Object.WARLORD3);
		for(int i = 0; i < 8; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD3);
			}
		}
				
		Warlord P4 = new Warlord();
		P4.setXPos(32);
		P4.setYPos(32);
		P4.setPlayer(Grid.Object.WARLORD4);
		for(int i = 32; i < 40; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD4);
			}
		}
			
		//Create canvas for drawing on the current page
		Canvas canvas = new Canvas(600, 650);
		GraphicsContext gameWindow = canvas.getGraphicsContext2D();

			    
		//Animation start
		Timeline TL = new Timeline();
		TL.setCycleCount(Animation.INDEFINITE);
		KeyFrame gameOn = new KeyFrame(Duration.seconds(.01),
		new EventHandler<ActionEvent>() {

		    	int frameHold = 0;
		      	int currentFrame = 0;
		       	int countdownFrame = 500;
		       	int run = 0;
		        	
		       	public void handle(ActionEvent event) {

		     	   //clear the screen
		       	   root.getChildren().clear();
		       	   root.getChildren().add(canvas);
		   		   gameWindow.clearRect(0, 0, 600, 650);
		    		   
		   		   //Countdown for start
		   		   countdownFrame--;
		   		   Interrupt.countdownForStart(countdownFrame); 
		    		   
		   		   //Check if "P" is press, if so pause or resume
		   		   if (countdownFrame <= 0) {		    		   
		   			   run = Interrupt.pause(scene, run);
		   		   }
		    		   
		   		 /*
			     * When it is not pause the controllers will kick in and keep updating the game according the game model,
			     * otherwise just displaying the current stage without updating
			     */   		 
		   		   if (run == 1){
		   			//The ball on get update every 5 frame instead of 1, so that the paddle can 
		   			   //speed up(higher frame rate) with speed the ball
		    		   if (frameHold == 5){
			    		   game.tick();
			    		   frameHold = 0;
		    		   } else {
		    			   frameHold++;
		    		   }
			    		   
		    		 //Time control,  fast foward (for testing) or normal, or exit the game straight away
		    		   scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			 			   
		    				//When BACKSPACE is pressed, time will faster forward to the last 1 seconds(For testing purpose)
		    				if(key.getCode() == KeyCode.BACK_SPACE) {
		    					currentFrame = 11900; 
		    				//When ESC is pressed, return to main menu, via set time to the beyond last second
		    				} else if (key.getCode() == KeyCode.ESCAPE){
		    					currentFrame = 13000;
		    				}
		    			});
		    		    currentFrame++;
		    		    
		    		    //Escape back to the main menu
    					if (currentFrame == 13001) {
    						TL.pause();
			    			twoPlayerStage.close();
			    			Pages.mainMenu();
    					}
			    		   
		    		   //Determine if the game has finish, if it is not refresh the time remaining
		    		   if (Game.isFinished()){
		    			  TL.pause();
		    			  //Return to main menu
		    			  twoPlayerStage.close();
		    			  Pages.endGame(P1, P2, P3, P4, 2);
		    		
		    			 //if it is not finish refresh the time remaining
		    		   } else {
		    			  Game.setTimeRemaining(120 - (currentFrame / 100));
		    		   }

		    		   //Check if any warlord get hitted
		    		   P1.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P2.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P3.checkHitted(ball.getXPos(), ball.getYPos());
			   		   P4.checkHitted(ball.getXPos(), ball.getYPos());
			    			         
			   		   //Update players' paddle in the model
			   		   PaddleController.keybordInputP1(scene, paddle1);
			   		   PaddleController.keybordInputP2(scene, paddle2);
			   		   AI.AIForP3(paddle3);
			   		   AI.AIForP4(paddle4);
		    	           
		    	   }
		    		   
		    		   
		    	   //Header
		    	   gameWindow.setFill(Color.BLACK);
		    	   gameWindow.fillRect(0, 45, 600, 5);
		    	   
		    	   //Display time
		    	   DisplayTime.countDown(gameWindow);
		    	   
		    	   //Display game status
		    	   DisplayTime.status(gameWindow, countdownFrame);
		    		    	
		    	   //Remove the destoried warlords' paddle
		    	   PaddleController.destoryPaddle(P1, P2, P3, P4);
		    		   
		    	   //Move the ball
		    	   MovingBall.drawBall(gameWindow);
		    		   
		    	   //Draw the warlords
		    	   DisplayingWarlord.drawWarlord(P1, P2, P3, P4, gameWindow);
		    		   
		    	   //Move(or not move) the player's paddle
		    	   MovingPaddle.drawPaddle(gameWindow);
			        	
		    	   //Draw all the walls
		    	   DisplayingWall.drawWall(gameWindow);
		    	      		   
		        }	
		    });

		    TL.getKeyFrames().add(gameOn);
		    TL.play();
		        
	   twoPlayerStage.setScene(scene);
	   twoPlayerStage.show();

	}

	/*
	 * The forth game mode: 3 players 1 AI 
	 */
	public static void threePlayers(){
		
		//Create stage for the current page
		Stage threePlayerStage = new Stage();
		threePlayerStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);

		/*
		 * Set up game first
		 */
		Game game = new Game();
				
		Grid grid = new Grid();

		DisplayingWall.init();
				
		//Set up ball
		Ball ball = new Ball();
		ball.setXPos(19);
		ball.setYPos(19);
				
		//Use a random number to generate a random initial directon for the ball 
		ball.setXVelocity(Game.setBalldirextionX());
		ball.setYVelocity(Game.setBalldirextionY());
				
		//Set up player's paddle
		Paddle paddle1 = new Paddle();
		paddle1.setXPos(14);
		paddle1.setYPos(25);
		paddle1.setPlayer(Grid.Object.PADDLE1);
				
		Paddle paddle2 = new Paddle();
		paddle2.setXPos(14);
		paddle2.setYPos(14);
		paddle2.setPlayer(Grid.Object.PADDLE2);
				
		Paddle paddle3 = new Paddle();
		paddle3.setXPos(25);
		paddle3.setYPos(14);
		paddle3.setPlayer(Grid.Object.PADDLE3);
				
		Paddle paddle4 = new Paddle();
		paddle4.setXPos(25);
		paddle4.setYPos(25);
		paddle4.setPlayer(Grid.Object.PADDLE4);
			
		//Set up warlord
		Warlord P1 = new Warlord();
		P1.setXPos(0);
		P1.setYPos(32);
		P1.setPlayer(Grid.Object.WARLORD1);
		for(int i = 32; i < 40; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD1);
			}
		}
				
		Warlord P2 = new Warlord();
		P2.setXPos(0);
		P2.setYPos(0);
		P2.setPlayer(Grid.Object.WARLORD2);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD2);
			}
		}
				
		Warlord P3 = new Warlord();
		P3.setXPos(32);
		P3.setYPos(0);
		P3.setPlayer(Grid.Object.WARLORD3);
		for(int i = 0; i < 8; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD3);
			}
		}
				
		Warlord P4 = new Warlord();
		P4.setXPos(32);
		P4.setYPos(32);
		P4.setPlayer(Grid.Object.WARLORD4);
		for(int i = 32; i < 40; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD4);
			}
		}
				
		//Create canvas for drawing on the current page
		Canvas canvas = new Canvas(600, 650);
		GraphicsContext gameWindow = canvas.getGraphicsContext2D();

			    
		//Animation start
		Timeline TL = new Timeline();
		TL.setCycleCount(Animation.INDEFINITE);
		KeyFrame gameOn = new KeyFrame(Duration.seconds(.01),
		new EventHandler<ActionEvent>() {

		    	int frameHold = 0;
		      	int currentFrame = 0;
		       	int countdownFrame = 500;
		       	int run = 0;
		        	
		       	public void handle(ActionEvent event) {

		     	   //clear the screen
		       	   root.getChildren().clear();
		       	   root.getChildren().add(canvas);
		   		   gameWindow.clearRect(0, 0, 600, 650);
		    		   
		   		   //Countdown for start
		   		   countdownFrame--;
		   		   Interrupt.countdownForStart(countdownFrame); 
		    		   
		   		 //Check if "P" is press, if so pause or resume
		   		   if (countdownFrame <= 0) {		    		   
		    		   run = Interrupt.pause(scene, run);
		   		   }
		    		   
		    		
		   		 /*
				  * When it is not pause the controllers will kick in and keep updating the game according the game model,
				  * otherwise just displaying the current stage without updating
				  */   
		   		   if (run == 1){
		   			//The ball on get update every 5 frame instead of 1, so that the paddle can 
		   			   //speed up(higher frame rate) with speed the ball
		    		   if (frameHold == 5){
			    		   game.tick();
			    		   frameHold = 0;
		    		   } else {
		    			   frameHold++;
		    		   }
			    		   
		    		   //Time control,  fast foward (for testing) or normal, or exit the game straight away
		    		   scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			 			   
		    				//When BACKSPACE is pressed, time will faster forward to the last 1 seconds(For testing purpose)
		    				if(key.getCode() == KeyCode.BACK_SPACE) {
		    					currentFrame = 11900; 
		    					//When ESC is pressed, return to main menu, via set time to beyond the last second
		    				} else if (key.getCode() == KeyCode.ESCAPE){
		    					currentFrame = 13000; 
		    				}
		    			});
		    		    currentFrame++;
		    		    
		    		    //Escape back to the main menu
		    		    if (currentFrame == 13001){
		    		    	TL.pause();
			    			threePlayerStage.close();
			    			Pages.mainMenu();
		    		    }
			    		   
		    		   //Determine if the game has finish
		    		   if (Game.isFinished()){
		    			  TL.pause();
		    			  //Return to main menu
		    			  threePlayerStage.close();
		    			  Pages.endGame(P1, P2, P3, P4, 3);
		    			  
		    		   //if it is not refresh the time remaining
		    		   } else {
		    			  Game.setTimeRemaining(120 - (currentFrame / 100));
		    		   }

		    		   //Check if any warlord get hitted
		    		   P1.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P2.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P3.checkHitted(ball.getXPos(), ball.getYPos());
			   		   P4.checkHitted(ball.getXPos(), ball.getYPos());
			    			         
			   		   //Update players' paddle in the model
			   		   PaddleController.keybordInputP1(scene, paddle1);
			   		   PaddleController.keybordInputP2(scene, paddle2);
			   		   PaddleController.keybordInputP3(scene, paddle3);
			   		   AI.AIForP4(paddle4);
		    	           
		    	   }
		    		   
		    		   
		    	   //Header
		    	   gameWindow.setFill(Color.BLACK);
		    	   gameWindow.fillRect(0, 45, 600, 5);
		    	   
		    	   //Display time
		    	   DisplayTime.countDown(gameWindow);
		    	   
		    	   //Display game status
		    	   DisplayTime.status(gameWindow, countdownFrame);
		    		    	
		    	   //Remove the destoried warlords' paddle
		    	   PaddleController.destoryPaddle(P1, P2, P3, P4);
		    		   
		    	   //Move the ball
		    	   MovingBall.drawBall(gameWindow);
		    		   
		    	   //Draw the warlords
		    	   DisplayingWarlord.drawWarlord(P1, P2, P3, P4, gameWindow);
		    		   
		    	   //Move(or not move) the player's paddle
		    	   MovingPaddle.drawPaddle(gameWindow);
			        	
		    	   //Draw all the walls
		    	   DisplayingWall.drawWall(gameWindow);
		    	      		   
		        }	
		    });

		    TL.getKeyFrames().add(gameOn);
		    TL.play();
		        
		    threePlayerStage.setScene(scene);
		    threePlayerStage.show();
	}

	/*
	 * The fIFth game mode: 4 players no AI 
	 */
	public static void fourPlayers(){
		
		//Create stage for the current page
		Stage fourPlayerStage = new Stage();
		fourPlayerStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);

		/*
		 * Set up game first
		 */
		Game game = new Game();
				
		Grid grid = new Grid();

		DisplayingWall.init();
				
		//Set up ball
		Ball ball = new Ball();
		ball.setXPos(19);
		ball.setYPos(19);
				
		//Use a random number to generate a random initial directon for the ball 
		ball.setXVelocity(Game.setBalldirextionX());
		ball.setYVelocity(Game.setBalldirextionY());
				
		//Set up player's paddle
		Paddle paddle1 = new Paddle();
		paddle1.setXPos(14);
		paddle1.setYPos(25);
		paddle1.setPlayer(Grid.Object.PADDLE1);
				
		Paddle paddle2 = new Paddle();
		paddle2.setXPos(14);
		paddle2.setYPos(14);
		paddle2.setPlayer(Grid.Object.PADDLE2);
				
		Paddle paddle3 = new Paddle();
		paddle3.setXPos(25);
		paddle3.setYPos(14);
		paddle3.setPlayer(Grid.Object.PADDLE3);
				
		Paddle paddle4 = new Paddle();
		paddle4.setXPos(25);
		paddle4.setYPos(25);
		paddle4.setPlayer(Grid.Object.PADDLE4);
			
		//Set up warlord
		Warlord P1 = new Warlord();
		P1.setXPos(0);
		P1.setYPos(32);
		P1.setPlayer(Grid.Object.WARLORD1);
		for(int i = 32; i < 40; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD1);
			}
		}
				
		Warlord P2 = new Warlord();
		P2.setXPos(0);
		P2.setYPos(0);
		P2.setPlayer(Grid.Object.WARLORD2);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				grid.setObject(j, i, Grid.Object.WARLORD2);
			}
		}
				
		Warlord P3 = new Warlord();
		P3.setXPos(32);
		P3.setYPos(0);
		P3.setPlayer(Grid.Object.WARLORD3);
		for(int i = 0; i < 8; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD3);
			}
		}
				
		Warlord P4 = new Warlord();
		P4.setXPos(32);
		P4.setYPos(32);
		P4.setPlayer(Grid.Object.WARLORD4);
		for(int i = 32; i < 40; i++){
			for(int j = 32; j < 40; j++){
				grid.setObject(j, i, Grid.Object.WARLORD4);
			}
		}
				
		//Create canvas for drawing at the current page
		Canvas canvas = new Canvas(600, 650);
		GraphicsContext gameWindow = canvas.getGraphicsContext2D();

			    
		//Animation start
		Timeline TL = new Timeline();
		TL.setCycleCount(Animation.INDEFINITE);
		KeyFrame gameOn = new KeyFrame(Duration.seconds(.01),
		new EventHandler<ActionEvent>() {

		    	int frameHold = 0;
		      	int currentFrame = 0;
		       	int countdownFrame = 500;
		       	int run = 0;
		       	
		       	public void handle(ActionEvent event) {

		     	   //clear the screen
		       	   root.getChildren().clear();
		       	   root.getChildren().add(canvas);
		   		   gameWindow.clearRect(0, 0, 600, 650);
		    		   
		   		   //Countdown for start
		   		   countdownFrame--;
		   		   Interrupt.countdownForStart(countdownFrame); 
		    		   
		   		   //Check if "P" is press, if so pause or resume
	    		   if (countdownFrame <= 0) {		    		   
		    		   run = Interrupt.pause(scene, run);
		   		   }
		    		   
	    		   /*
					* When it is not pause the controllers will kick in and keep updating the game according the game model,
					* otherwise just displaying the current stage without updating
					*/   
		   		   if (run == 1){
		   			//The ball on get update every 5 frame instead of 1, so that the paddle can 
		   			   //speed up(higher frame rate) with speed the ball
		    		   if (frameHold == 5){
			    		   game.tick();
			    		   frameHold = 0;
		    		   } else {
		    			   frameHold++;
		    		   }
			    		   
		    		   
		    		   //Time control,  fast foward (for testing) or normal, or exit the game straight away
		    		   scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			 			   
		    			    //When BACKSPACE is pressed, time will faster forward to the last 1 seconds(For testing purpose)
		    				if(key.getCode() == KeyCode.BACK_SPACE) {
		    					currentFrame = 11900; 
		    				//When ESC is pressed, return to main menu, via set time to boyond the last second
		    				} else if (key.getCode() == KeyCode.ESCAPE){
		    					currentFrame = 13000;
		    				}
		    			});
		    		    currentFrame++;
			    		   
		    		    //Escape to the main menu
		    		    if (currentFrame == 13001){
		    		    	TL.pause();
			    			fourPlayerStage.close();
			    			Pages.mainMenu();
		    		    }
		    		   
		    		   //Determine if the game has finish
		    		   if (Game.isFinished()){
		    			  TL.pause();
		    			  //Return to main menu
		    			  fourPlayerStage.close();
		    			  Pages.endGame(P1, P2, P3, P4, 4);
		    		   //if it is not refresh the time remaining
		    		   } else {
		    			  Game.setTimeRemaining(120 - (currentFrame / 100));
		    		   }

		    		   //Check if any warlord get hitted
		    		   P1.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P2.checkHitted(ball.getXPos(), ball.getYPos());
		    		   P3.checkHitted(ball.getXPos(), ball.getYPos());
			   		   P4.checkHitted(ball.getXPos(), ball.getYPos());
			    			         
			   		   //Update players' paddle in the model
			   		   PaddleController.keybordInputP1(scene, paddle1);
			   		   PaddleController.keybordInputP2(scene, paddle2);
			   		   PaddleController.keybordInputP3(scene, paddle3);
			   		   PaddleController.keybordInputP4(scene, paddle4);
		    	           
		    	   }
		    		   
		    		   
		    	   //Header
		    	   gameWindow.setFill(Color.BLACK);
		    	   gameWindow.fillRect(0, 45, 600, 5);
		    	   
		    	   //Display time
		    	   DisplayTime.countDown(gameWindow);
		    	   
		    	   //Display game status
		    	   DisplayTime.status(gameWindow, countdownFrame);
		    		    	
		    	   //Remove the destoried warlords' paddle
		    	   PaddleController.destoryPaddle(P1, P2, P3, P4);
		    		   
		    	   //Move the ball
		    	   MovingBall.drawBall(gameWindow);
		    		   
		    	   //Draw the warlords
		    	   DisplayingWarlord.drawWarlord(P1, P2, P3, P4, gameWindow);
		    		   
		    	   //Move(or not move) the player's paddle
		    	   MovingPaddle.drawPaddle(gameWindow);
			        	
		    	   //Draw all the walls
		    	   DisplayingWall.drawWall(gameWindow);
		    	      		   
		        }	
		    });

		    TL.getKeyFrames().add(gameOn);
		    TL.play();
		        
		    fourPlayerStage.setScene(scene);
		    fourPlayerStage.show();
	}

	/*
	 * The menu that show in the end of each game, for the player to choose they want to restart the 
	 * game or back the the main menu
	 */
	public static void endGame(Warlord P1, Warlord P2, Warlord P3, Warlord P4, int playersNumber){
		
		//By defalut the game select the first option for the user
		endSelector = 1;
		
		//Create a stage for the current page
		Stage endGameStage = new Stage();
		endGameStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create a scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);
		
		//Create a canvas for drawing on the current page
		Canvas endGameWindow= new Canvas(600, 650);
	    GraphicsContext endGameMenu = endGameWindow.getGraphicsContext2D();		
		
		root.getChildren().add(endGameWindow);

	    //Sound effect, need extra part for it to play
	    /*String musicFile = "mainbgm.mp3";    
	    Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);*/
    	
		
		/*
		 * Display the last frame of the game in the back ground
		 */
    	//Header
		endGameMenu.setFill(Color.BLACK);
		endGameMenu.fillRect(0, 45, 600, 5);
 	   
 	    //Display time
 	    DisplayTime.countDown(endGameMenu);
 		    	
 	    //Remove the destoried warlords' paddle
 	    PaddleController.destoryPaddle(P1, P2, P3, P4);
 		   
  	    //Move the ball
   	    MovingBall.drawBall(endGameMenu);
 		   
 	    //Draw the warlords
 	    DisplayingWarlord.drawWarlord(P1, P2, P3, P4, endGameMenu);
 		   
 	    //Move(or not move) the player's paddle
 	    MovingPaddle.drawPaddle(endGameMenu);
	        	
 	    //Draw all the walls
 	    DisplayingWall.drawWall(endGameMenu);
    	
 	    //Display the pop-up menu
    	DisplaySelector.endGameMenu(endGameMenu, endSelector, Game.findWinner());
    	
    	//The options selecting mechanism 
    	scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
    			//When UP is pressed, the first option is selected
				if (key.getCode() == KeyCode.UP) {
					endSelector = 1;
					DisplaySelector.endGameMenu(endGameMenu, endSelector, Game.findWinner());
				
				//When DOWN is pressed, the first option is selected
				} else if (key.getCode() == KeyCode.DOWN) {
					endSelector = 2;
					DisplaySelector.endGameMenu(endGameMenu, endSelector, Game.findWinner());
					
				//Act the option that the selector select, while ENTER is pressed
				} else if (key.getCode() == KeyCode.ENTER) {
					if (endSelector == 1){
						endGameStage.close();
						
						//Check the current game mode and go to the page that with the current game mode
						if(playersNumber == 0){
							Pages.demo();
						} else if(playersNumber == 1){
							Pages.single();
						} else if(playersNumber == 2){
							Pages.twoPlayers();
						} else if(playersNumber == 3){
							Pages.threePlayers();
						} else if(playersNumber == 4){
							Pages.fourPlayers();
						}
					
					//Back to the main menu		
					} else if (endSelector == 2){
						endGameStage.close();
						Pages.mainMenu(); 
					} 
				}
    	});
    	
    	endGameStage.setScene(scene);
    	endGameStage.show();
		
	}


	/*
	 * Help centre, to show the button assigned
	 */
	public static void helpCentre(){
		
		//Create a stage for the current page
		Stage helpCentreStage = new Stage();
		helpCentreStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create a scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);
		
		//Create a canvas for drawing on the current page
		Canvas helpWindow = new Canvas(600, 650);
	    GraphicsContext helpCentre = helpWindow.getGraphicsContext2D();		
		
    	root.getChildren().add(helpWindow);
    	
	    //Sound effect, need extra part for it to play
	    /*String musicFile = "mainbgm.mp3";    
	    Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);*/
	    
	    /*
	     * Some "Art Work" since their is little user imput required, so we just code 
	     * the viewer under the same function
	     */
    	
    	//The back ground
	    helpCentre.setFill(Color.rgb(116,109,118));
	    helpCentre.fillRect(0, 0, 120, 650);
	    helpCentre.fillRect(480, 0, 120, 650);

	    
	    //The writing
    	helpCentre.setFill(Color.BLACK);
		Font bigFont = Font.font("Times New Roman", FontWeight.BOLD, 30.0);
		helpCentre.setFont(bigFont);
		helpCentre.fillText("Move paddle:", 140, 150);
		helpCentre.fillText("Pause : P", 140, 300);
		helpCentre.fillText("Return to main ", 140, 380);
		helpCentre.fillText("menu : ESC", 140, 420);
	
		Font smallFont = Font.font("Times New Roman", FontWeight.BOLD, 15.0);
		helpCentre.setFont(smallFont);
		helpCentre.fillText("P1: A & D          P2: LEFT & RIGHT", 140, 200);
		helpCentre.fillText("P3: T & Y          P4: I & O", 140, 230);
    	
		//Create a "button" for "return"
		helpCentre.setFill(Color.GRAY);
		helpCentre.fillRoundRect(230, 560, 140, 50, 20, 20);
		helpCentre.setStroke(Color.BLACK);
		helpCentre.setLineWidth(2);
		helpCentre.strokeRoundRect(230, 560, 140, 50, 20, 20);
		
		//Writing on the button
		helpCentre.setFill(Color.WHITE);
		Font whiteFont = Font.font("Times New Roman", FontWeight.BOLD, 18.0);
		helpCentre.setFont(whiteFont);
		helpCentre.fillText("Return", 263, 592);
		
		/*
		 * Once ENTER hit, the page will return to the main menu. This page does not
		 * needed a selector since there is only 1 option and have nothing to choose from
		 */
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			if (key.getCode() == KeyCode.ENTER) {
				helpCentreStage.close();
				Pages.mainMenu();
				
			}
		});
		
    	helpCentreStage.setScene(scene);
    	helpCentreStage.show();
	}
	

	/*
	 * About, to show developing update, news, new DLC etc.
	 */
	public static void about(){
		
		//Create a stage for the current page
		Stage aboutStage = new Stage();
		aboutStage.setTitle("Four Kingdoms: the Resurrection of Han");
		
		//Create a scene for the current page
		Group root = new Group();
		Scene scene = new Scene(root, 600, 650, Color.WHITE);
		
		//Create a canvas for drawing on the current page
		Canvas aboutWindow = new Canvas(600, 650);
	    GraphicsContext aboutUs = aboutWindow.getGraphicsContext2D();		
		
	 	root.getChildren().add(aboutWindow);
	 	
	    //Sound effect, need extra part for it to play
	    /*String musicFile = "mainbgm.mp3";    
	    Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);*/
	    
	 	//The back ground
	    aboutUs.setFill(Color.rgb(116,109,118));
	    aboutUs.fillRect(0, 0, 120, 650);
	    aboutUs.fillRect(480, 0, 120, 650);

	    
	    //The writing
    	aboutUs.setFill(Color.BLACK);
		Font bigFont = Font.font("Times New Roman", FontWeight.BOLD, 30.0);
		aboutUs.setFont(bigFont);
		aboutUs.fillText("Developers:", 200, 200);
		
		Font midFont = Font.font("Times New Roman", FontWeight.BOLD, 15.0);
		aboutUs.setFont(midFont);
		aboutUs.fillText("Jiaming Cen", 240, 250);
		aboutUs.fillText("Issac Lee", 250, 280);
		aboutUs.fillText("DLC will be released soon!", 185, 400);
		aboutUs.fillText("We can't wait!", 238, 425);
    	
		//Create a "button" for "return"
		aboutUs.setFill(Color.GRAY);
		aboutUs.fillRoundRect(230, 560, 140, 50, 20, 20);
		aboutUs.setStroke(Color.BLACK);
		aboutUs.setLineWidth(2);
		aboutUs.strokeRoundRect(230, 560, 140, 50, 20, 20);
		
		//Writing on the button
		aboutUs.setFill(Color.WHITE);
		Font whiteFont = Font.font("Times New Roman", FontWeight.BOLD, 18.0);
		aboutUs.setFont(whiteFont);
		aboutUs.fillText("Return", 263, 592);
		
		/*
		 * Once ENTER hit, the page will return to the main menu. This page does not
		 * needed a selector since there is only 1 option and have nothing to choose from
		 */
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			
			if (key.getCode() == KeyCode.ENTER) {
				aboutStage.close();
				Pages.mainMenu();
				
			}
		});
		
		aboutStage.setScene(scene);
    	aboutStage.show();
	}

}
