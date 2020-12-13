package p4_group_8_repo.main;


import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.view.SceneManager;


public class FroggerApp extends Application {

	SceneManager manager = new SceneManager();

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		manager.showMenu(window);
		
	}
	
	
	


    
    
   
    
}
