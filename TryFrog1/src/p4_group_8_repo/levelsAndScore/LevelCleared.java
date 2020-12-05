package p4_group_8_repo.levelsAndScore;

import java.util.Timer;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;


public class LevelCleared extends Actor {
   
	Timer timer = new Timer();
	public LevelCleared(int i) {
		// TODO Auto-generated constructor stub
		if(i==1) {
			setImage(new Image("file:src/p4_group_8_repo/img/levelcleared.png"));
         	setX(140);
			setY(305);
			
			
		}
		
			else {
			setImage(new Image("file:src/p4_group_8_repo/img/game-over.png"));
			setX(85);
			setY(285);			
		}

	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(now % 31 == 0) {
        	setImage(null);

		}

}
}

