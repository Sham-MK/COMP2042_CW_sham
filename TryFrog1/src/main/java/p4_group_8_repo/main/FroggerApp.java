 package p4_group_8_repo.main;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import p4_group_8_repo.view.SceneManager;


public class FroggerApp extends Application {

	SceneManager manager = new SceneManager();

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		manager.showMenu(window);
		
	}
	
	
	


    
    
   
    
}
