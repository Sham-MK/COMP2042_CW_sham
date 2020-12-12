package p4_group_8_repo.Model;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class Fly extends Actor {
    Timer timer = new Timer();
    int shift = 0;
    public Fly() {
		// TODO Auto-generated constructor stub
    	timer.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
         	setImage(new Image("file:src/p4_group_8_repo/View/img/fly.png", 35, 28, true, true));
       	    setX(20+shift); 
       	    setY(86);
       	    if(shift==360) {
             	shift =0;
             }
            shift+=90;
  	
            }
        }, 6000, 12000);

	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getIntersectingObjects(End.class).size() >= 1) {
       	    if(getIntersectingObjects(End.class).get(0).isActivated()) {
  		     	setImage(null);
  			}
       	 }
	}

}
