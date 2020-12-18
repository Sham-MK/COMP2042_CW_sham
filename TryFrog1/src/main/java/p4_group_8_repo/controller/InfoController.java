package p4_group_8_repo.controller;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import p4_group_8_repo.view.SceneManager;
/**
* <h1>Controller for the How To Play view</h1>
* <p>
* The info controller is responsible for all the actions
* in the info scene
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/
public class InfoController {
	String username;

	SceneManager manager = new SceneManager();//scene manager for switching scenes
	/**
	  This method is used get the game scene when play now! button is clicked.
     * @param event which is ActionEvent when play now! button is clicked.
     */

	public void startGame(ActionEvent event) {
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow(),username);	

	}
	/**
	  This method is used get the menu scene when go back button is clicked.
   * @param event which is ActionEvent when go back button is clicked.
   */
	
	public void showMenu(ActionEvent event) {
		manager.showMenu((Stage)((Node)event.getSource()).getScene().getWindow());	

	}
	public void setUsername(String username) {
		this.username = username;
	}
}
