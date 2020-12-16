package p4_group_8_repo.controller;


import javafx.event.ActionEvent;

import javafx.scene.Node;
import javafx.stage.Stage;
import p4_group_8_repo.view.SceneManager;

/**
* <h1>Controller for the Menu view</h1>
* <p>
* The Menu controller is responsible for all the actions
* in the menu scene
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/
public class MenuController {
	
	SceneManager manager = new SceneManager();//scene manager for switching scenes

	public MenuController() {
		// TODO Auto-generated constructor stub
		
	}
	/**
     * This method is used get the game scene when start button is clicked.
     * @param event which is ActionEvent when start button is clicked.
     */
	public void startGame(ActionEvent event) {	
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow());

	}
	/**
     * This method is used get the info scene when How To Play button is clicked.
     * @param event which is ActionEvent when How To Play button is clicked.
     */
	
	public void showInfo(ActionEvent event) {
		manager.showInfo((Stage)((Node)event.getSource()).getScene().getWindow());


	}


}
