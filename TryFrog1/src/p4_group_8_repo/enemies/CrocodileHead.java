package p4_group_8_repo.enemies;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;
import p4_group_8_repo.gameStage.End;
import p4_group_8_repo.scoreBoosters.Fly;

public class CrocodileHead extends Actor {
	Timer timer = new Timer();
    int shift = 0;

	public CrocodileHead() {
		// TODO Auto-generated constructor stub
		timer.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
         	setImage(new Image("file:src/p4_group_8_repo/img/crocodilehead.png", 43, 43, true, true));
       	    setX(12+shift); 
       	    setY(73);
       	    if(shift==270) {
             	shift =0;
             }
            shift+=90;
  	
            }
        }, 60000, 8000);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getIntersectingObjects(End.class).size() >= 1) {
       	    if(getIntersectingObjects(End.class).get(0).isActivated()) {
  		     	setImage(null);
  			}
       	 }
		if (getIntersectingObjects(Fly.class).size() >= 1) {
  		     	setImage(null);
  		     	}
	}

}
