package p4_group_8_repo.model.enemies;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import p4_group_8_repo.model.scoreBoosters.Swamp;
import p4_group_8_repo.model.gameAttributes.Actor;
import p4_group_8_repo.model.scoreBoosters.Fly;
/**
* <h1>Crocodile Head class</h1>
* <p>
* This class is responsible for setting the crocodile head
* which periodically appears on one of the swamps
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class CrocodileHead extends Actor {
	private Timer timer = new Timer();//timer for shifting the crocodile head


	int shift = 0;//amount to be shifted
	/**
	 * Constructor of crocodile head
	 * in creates a scheduled timer that shows crocodile head 1 minute into the game 
	 * and shifts its position every 8 seconds
	 */

	public CrocodileHead() {
		// TODO Auto-generated constructor stub
		timer.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
         	setImage(new Image("/img/crocodilehead.png", 43, 43, true, true));
       	    setX(12+shift); 
       	    setY(73);
       	    if(shift==270) {
             	shift =0;
             }
            shift+=90;
  	
            }
        }, 60000, 8000);
	}

	/**
	 * This method is responsible for checking intersections of crocodile head
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
		if (getIntersectingObjects(Fly.class).size() >= 1) {//if intersected a fly disappear
  		     	setImage(null);
  		     	}
	}
	/**
	 * getter for timer
	 * @return timer
	 */
    public Timer getTimer() {
		return timer;
	}

}
