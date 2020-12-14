package p4_group_8_repo.model.gameBase;

import java.util.Timer;

import javafx.scene.image.Image;


public class LevelCleared extends Actor {
   
	Timer timer = new Timer();
	public LevelCleared() {
		// TODO Auto-generated constructor stub
			setImage(new Image("file:src/main/resources/img/levelcleared.png"));
         	setX(140);
			setY(305);

	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(now % 61 == 0) {
        	getWorld().remove(this);

		}

}
}

