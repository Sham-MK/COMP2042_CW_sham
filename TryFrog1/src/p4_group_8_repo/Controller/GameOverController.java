package p4_group_8_repo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p4_group_8_repo.Model.Score;
import p4_group_8_repo.View.SceneManager;


public class GameOverController {
	SceneManager manager = new SceneManager();

	
    @FXML Text highscore;
	
	public void playAgain(ActionEvent event) {
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow());	

	}
    public void setText(int points) {
    	Score scorePointer = new Score();
		int score = scorePointer.read();
		if(points>score) {
		    highscore.setText("Old Highscore: "+score+"\n\nNew Highscore: "+points);
		    scorePointer.update(points);
		}else {
			highscore.setText("Highscore: "+score+"\n\nYour Score: "+points);

		}
     }  
	
	
}
