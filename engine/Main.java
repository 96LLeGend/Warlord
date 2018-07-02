package engine;
	
import javafx.application.Application;
import javafx.stage.Stage;
import engine.Pages;

/*
 * Main class, it just a starting point, only gets to use once
 */


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Pages.mainMenu();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		launch(args);
		
	}	
	
}
