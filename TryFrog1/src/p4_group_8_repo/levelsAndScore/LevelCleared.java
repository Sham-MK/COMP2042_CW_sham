package p4_group_8_repo.levelsAndScore;

import java.util.Timer;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;


public class LevelCleared extends Actor {
   
	Timer timer = new Timer();
	public LevelCleared() {
		// TODO Auto-generated constructor stub
			setImage(new Image("file:src/p4_group_8_repo/img/levelcleared.png"));
         	setX(140);
			setY(305);

	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(now % 61 == 0) {
        	setImage(null);

		}

}
}

