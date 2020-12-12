package p4_group_8_repo.Controller;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import p4_group_8_repo.View.SceneManager;

public class InfoController {
	SceneManager manager = new SceneManager();

	public void startGame(ActionEvent event) {
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow());	

	}
	
	public void showMenu(ActionEvent event) {
		manager.showMenu((Stage)((Node)event.getSource()).getScene().getWindow());	

	}
}
