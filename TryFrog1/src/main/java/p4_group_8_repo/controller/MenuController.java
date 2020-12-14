package p4_group_8_repo.controller;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import p4_group_8_repo.view.SceneManager;

public class MenuController {
	
	SceneManager manager = new SceneManager();

	public MenuController() {
		// TODO Auto-generated constructor stub
		
	}
	public void startGame(ActionEvent event) {	
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow());

	}
	
	public void showInfo(ActionEvent event) {
		manager.showInfo((Stage)((Node)event.getSource()).getScene().getWindow());


	}


}
