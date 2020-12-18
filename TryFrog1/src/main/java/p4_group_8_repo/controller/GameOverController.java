package p4_group_8_repo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p4_group_8_repo.model.gameAttributes.ScoreHandler;
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

	ScoreHandler scorePointer = new ScoreHandler();
	String username;
	int level;
	@FXML Text heading;
	
	@FXML Text lead1;
	@FXML Text lead2;
	@FXML Text lead3;
	@FXML Text lead4;

    @FXML Text score;//text field that will show the score
    
    /**
     * This method is used get the game scene when play again button is clicked.
     * @param event which is ActionEvent when play again button is clicked.
     */
	public void playAgain(ActionEvent event) {
		manager.startGame((Stage)((Node)event.getSource()).getScene().getWindow(),username);	

	}

	 /**
     * This method is used to show the score and highscore at the screen on the text node.
     * It also does a comparison between highscore and score to show if the highscore was beaten
     * if so it calls a method of type score to update the file which stores the score.
     * @param points which is an integer of the score.
     * @param level final level reached by player
     * @param name username of player
	 * @throws IOException 
     */
    public void setText(int points, int level,String name) throws IOException {
    	username = name;
    	this.level = level;
		score.setText("Score: "+points+"\nLevel reached: "+level);
		if(scorePointer.isHigher(points, name)) {
			heading.setText("You made it to the leaderboard!");
		}else {
			heading.setText("Game Over");
		}
		ArrayList<String> names = scorePointer.getNames();
		ArrayList<Integer> score = scorePointer.getHighscores();
		
		lead1.setText(names.get(0)+"\t\t"+score.get(0));
		lead2.setText(names.get(1)+"\t\t"+score.get(1));
		lead3.setText(names.get(2)+"\t\t"+score.get(2));
		lead4.setText(names.get(3)+"\t\t"+score.get(3));

		
     }  
	
	
}
