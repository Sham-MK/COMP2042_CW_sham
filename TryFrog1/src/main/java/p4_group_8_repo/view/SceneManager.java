package p4_group_8_repo.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.GameOverController;
import p4_group_8_repo.controller.MyStage;

public class SceneManager {

	
	
	public void showMenu(Stage window) {
		try {
			AnchorPane menuView = FXMLLoader.load(getClass().getResource("/MenuView.fxml"));
			Scene menu = new Scene(menuView, 424 , 600);		
			window.setScene(menu);
			window.setResizable(false);
			window.setTitle("Frogger");
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void startGame(Stage window) {
		MyStage newGame = new MyStage();
		Scene game = new Scene(newGame, 424 , 600);	
		window.setScene(game);
		window.setResizable(false);
		window.setTitle("Frogger");
		window.show();
	}
	
	public void showInfo(Stage window) {
		
		try {
			AnchorPane InfoView = FXMLLoader.load(getClass().getResource("/InfoView.fxml"));
			Scene info = new Scene(InfoView, 424 , 600);	
			window.setScene(info);
			window.setResizable(false);
			window.setTitle("Frogger");
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void showGameOver(Stage window, int points) {
		try {
	           FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameOverView.fxml"));
	           AnchorPane root = loader.load();
	           
	           GameOverController controller2 = loader.getController();
	           controller2.setText(points);
	           
	           window.setScene(new Scene(root));
	           window.show();
	   
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		
	}
}

