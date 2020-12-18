package p4_group_8_repo.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.GameOverController;
import p4_group_8_repo.controller.GameStage;
import p4_group_8_repo.controller.InfoController;
/**
* <h1>Scene Manager Class</h1>
* <p>
* This class is responsible for switching and setting the scenes of the primary stage
* inside the window.
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/
public class SceneManager {

	
	/**
	 * This method is responsible for setting the menu scene.
	 * @param window which is the primary stage
	 */
	public void showMenu(Stage window) {
		try {
			AnchorPane menuView = FXMLLoader.load(getClass().getResource("/MenuView.fxml"));
			Scene menu = new Scene(menuView, 424 , 600);		
			window.setScene(menu);
			window.setResizable(false);
			window.getIcons().add(new Image("/img/icon.png"));
			window.setTitle("Frogger");
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
	 * This method is responsible for setting the game scene.
	 * @param window which is the primary stage
	 */
	public void startGame(Stage window,String username) {
		GameStage newGame = new GameStage(username);
		Scene game = new Scene(newGame, 424 , 600);	
		window.setScene(game);
		window.show();
	}
	/**
	 * This method is responsible for setting the info scene.
	 * @param window which is the primary stage
	 */
	public void showInfo(Stage window,String username) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/InfoView.fxml"));
	        AnchorPane root = loader.load();
	        
			InfoController controller2 = loader.getController();
	        controller2.setUsername(username);
			window.setScene(new Scene(root));
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	/**
	 * This method is responsible for setting the game over scene.
	 * @param window which is the primary stage
	 */
	public void showGameOver(Stage window, int points, int level,String name) {
		try {
	           FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameOverView.fxml"));
	           AnchorPane root = loader.load();
	           
	           GameOverController controller2 = loader.getController();
	           controller2.setText(points,level,name);
	           
	           window.setScene(new Scene(root));
	           window.show();
	   
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		
	}
}

