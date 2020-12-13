package p4_group_8_repo.model.gameBase;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.GameOverController;
import p4_group_8_repo.controller.Player;

public class Life extends Actor {

	Image img;
	int lives = 4;
	
	public Life() {
		
	}
	public void setLives() {
		for(int i=0; i<4; i++) {
			getWorld().add(new Life(0+(25*i)));
		}
	}
	public Life(int x) {
		img = new Image("file:src/p4_group_8_repo/view/img/Life-icon.png", 20, 20, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}
	
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(getWorld().getObjects(Player.class).get(0).gameover()) {
    		getWorld().stop();


    		try {
    	           FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOverView.fxml"));
    	           AnchorPane root = loader.load();
    	   
    	           //The following both lines are the only addition we need to pass the arguments
    	           GameOverController controller2 = loader.getController();
    	           controller2.setText(getWorld().getObjects(Player.class).get(0).getPoints());
    	           
    	           Stage stage = (Stage)(this).getScene().getWindow(); 
    	           stage.setScene(new Scene(root));
    	           stage.show();
    	   
    	       } catch (IOException e) {
    	           e.printStackTrace();
    	       }
    		

    	}
	
	}
	


	

	
}
