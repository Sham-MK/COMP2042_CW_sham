package p4_group_8_repo.model.scoreBoosters;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

/**
* <h1>Swamp class</h1>
* <p>
* This class is responsible for setting the swamps 
* in the game scene.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/
public class Swamp extends Actor{
	boolean activated = false;//if swamp is occupied
	
	/**
	 * constructor for the swamp
	 * @param x x position on pane
	 */
	public Swamp(int x) {
		setX(x); 
		setY(67);
		setImage(new Image("/img/End.png", 50, 50, true, true));
	}
	
	/**
	 * setting swamp to occupied when player reaches it.
	 */
	public void setOccupied() {
		setImage(new Image("/img/FrogEnd.png", 50, 50, true, true));
		activated = true;
	}
	
	/**
	 * restore swamp to defaults in new round
	 */
	public void unOccupy() {
		setImage(new Image("/img/End.png", 50, 50, true, true));
		activated = false;
	}
	/**
	 * getter for activated.
	 * @return activated if swamp is occupied or not
	 */
	public boolean isActivated() {
		return activated;
	}
	
	@Override 
	public void act(long now) {
		// TODO Auto-generated method 

	}

}
