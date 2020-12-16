package p4_group_8_repo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p4_group_8_repo.model.gameBase.Score;
import p4_group_8_repo.view.SceneManager;

/**
* <h1>Controller for the game over view</h1>
* <p>
* The game over controller is responsible for all the actions
* in the game over scene
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/
public class GameOverController {
	SceneManager manager = new SceneManager();//initializing a scene manager

	
    @FXML Text highscore;//text field that will show the score
    
    /**
     * This method is used get the game scene when play again button is clicked.
     * @param event which is ActionEvent when play again button is clicked.
     */
	public void playAgain(ActionEvent event) {
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow());	

	}
	 /**
     * This method is used to show the score and highscore at the screen on the text node.
     * It also does a comparison between highscore and score to show if the highscore was beaten
     * if so it calls a method of type score to update the file which stores the score.
     * @param points which is an integer of the score.
     */
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
