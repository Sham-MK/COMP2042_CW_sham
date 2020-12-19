package p4_group_8_repo.model.scoreBoosters;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameAttributes.Actor;
/**
* <h1>Fly class</h1>
* <p>
* This class is responsible for setting the fly 
* which periodically appears on one of the swamps 
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class Fly extends Actor {
    private Timer timer = new Timer();//timer to change location of fly every while
    int shift = 0;//amount to be shifted
    /**
	 * Constructor of Fly
	 * in creates a scheduled timer that shows Fly 6 seconds into the game 
	 * and shifts its position every 12 seconds
	 */
    public Fly() {
		// TODO Auto-generated constructor stub
    	timer.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
         	setImage(new Image("/img/fly.png", 35, 28, true, true));
       	    setX(20+shift); 
       	    setY(92);
       	    if(shift==360) {
             	shift =0;
             }
            shift+=90;
  	
            }
        }, 6000, 12000);

	}
    
    /**
	 * This method is responsible for checking intersections of Fly
	 * @param now a long which returns the current time frame in nanoseconds
	 */

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getIntersectingObjects(Swamp.class).size() >= 1) {
       	    if(getIntersectingObjects(Swamp.class).get(0).isActivated()) {//if swamp is activated disappear 
  		     	setImage(null);
  			}
       	 }
	}
	/**
	 * getter for timer
	 * @return timer fly timer
	 */
    public Timer getTimer() {
		return timer;
	}

}
