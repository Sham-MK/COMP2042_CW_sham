package p4_group_8_repo;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
public class Fly extends Actor {
    Timer timer = new Timer();
    int shift = 0;
    public Fly() {
		// TODO Auto-generated constructor stub
    	timer.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
         	setImage(new Image("file:src/p4_group_8_repo/img/fly.png", 30, 25, true, true));
       	    setX(21+shift); 
       	    setY(80);
       	    if(shift==360) {
             	shift =0;
             }
            shift+=90;
  	
            }
        }, 7000, 15000);

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
