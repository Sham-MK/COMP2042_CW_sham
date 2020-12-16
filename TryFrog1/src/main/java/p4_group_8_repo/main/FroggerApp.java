 package p4_group_8_repo.main;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import p4_group_8_repo.view.SceneManager;

/**
*<h1>Frogger main and start methods</h1>
*<p> For COMP2042 individual assignment</p> 
* @author  Sham Maatouk
* @version 1.0
* @since   2020 
*/


public class FroggerApp extends Application {

	SceneManager manager = new SceneManager();//scene manager to set scene

	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	   * start method. to set up the menu scene.
	   * @param Stage window.
	   * @exception Exception On error.
	   */
	
	@Override
	public void start(Stage window) throws Exception {
		/*Event Handler to kill all threads on window exit*/
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		manager.showMenu(window);//SceneManger call to set up menu scene on window
		
	}
	
	
	


    
    
   
    
}
