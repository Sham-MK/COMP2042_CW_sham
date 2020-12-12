package p4_group_8_repo.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p4_group_8_repo.gameStage.MyStage;
import p4_group_8_repo.levelsAndScore.Highscore;
import java.io.IOException;


public class GameOverController {

	
    @FXML Text highscore;
	
	public void playAgain(ActionEvent event) {
		MyStage newGame = new MyStage();
		Scene game = new Scene(newGame, 424 , 600);	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		window.setScene(game);
		window.setResizable(false);
		window.setTitle("Frogger");
		window.show();
	}
    public void setText(int points) {
    	Highscore scorePointer = new Highscore();
		int score = scorePointer.read();
		if(points>score) {
		    highscore.setText("Old Highscore: "+score+"\nNew Highscore: "+points);
		    scorePointer.update(points);
		}else {
			highscore.setText("Highscore: "+score+"\nYour Score: "+points);

		}
     }  
	
	
}
