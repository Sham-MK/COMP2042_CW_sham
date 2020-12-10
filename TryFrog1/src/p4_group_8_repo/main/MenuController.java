package p4_group_8_repo.main;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.gameStage.MyStage;

public class MenuController {
	
	

	public MenuController() {
		// TODO Auto-generated constructor stub
		
	}
	public void startGame(ActionEvent event) {
		MyStage newGame = new MyStage();
		Scene game = new Scene(newGame, 424 , 600);	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(game);
		window.setResizable(false);
		window.setTitle("Frogger");
		window.show();
		

	}
	
	public void showInfo(ActionEvent event) {
		try {
			AnchorPane InfoView = FXMLLoader.load(getClass().getResource("InfoView.fxml"));
			Scene info = new Scene(InfoView, 424 , 600);	
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
			window.setScene(info);
			window.setResizable(false);
			window.setTitle("Frogger");
			window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}


}
