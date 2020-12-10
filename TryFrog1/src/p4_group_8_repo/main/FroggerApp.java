package p4_group_8_repo.main;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.gameStage.MyStage;


public class FroggerApp extends Application {

	AnimationTimer timer;
    int delay = 6000;
	MyStage background;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		
		try {
			AnchorPane menuView = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
			Scene menu = new Scene(menuView, 424 , 600);		
			window.setScene(menu);
			window.setResizable(false);
			window.setTitle("Frogger");
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	


    
    
   
    
}
