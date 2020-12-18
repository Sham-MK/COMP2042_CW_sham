package p4_group_8_repo.model.gameAttributes;

import java.util.Timer;

import javafx.scene.image.Image;

/**
* <h1>Level Cleared class</h1>
* <p>
* This class is responsible for setting the level cleared
* image in the game scene whenever player reaches a new level.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class LevelCleared extends Actor {
   
	/*
	 * Constructor for level cleared
	 */
	public LevelCleared() {
		// TODO Auto-generated constructor stub
			setImage(new Image("/img/levelcleared.png"));
         	setX(140);
			setY(305);

	}


	/**
	 * The act now method her removes the image after some time
	 * @param now current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(now % 61 == 0) {
        	getWorld().remove(this);

		}

}
}

