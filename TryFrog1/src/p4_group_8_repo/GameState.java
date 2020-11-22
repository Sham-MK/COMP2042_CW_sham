package p4_group_8_repo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GameState extends Actor {
	
	
	

	public GameState() {
		// TODO Auto-generated constructor stub
		setImage(new Image("file:src/p4_group_8_repo/img/game-over.png", 250, 250, true, true));
		setX(85);
		setY(265);
	}
	
	public void gameOver() {
	
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}

