package p4_group_8_repo.model.gameAttributes;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

/**
* <h1>Floatable class</h1>
* <p>
* This class is responsible for setting all the floatable objects in the game scene
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class Floatable extends Actor {
	
	protected double speed;//speed of floatable
	protected double size;//size of floatable
	protected boolean sunk = false;//if flaotable is sunk in water
	protected Rectangle mouth = new Rectangle();//mouth of crocodile


	/**
	 * this method is responsible for moving floatables.
	 * @param now long which is current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -size && speed<0)
			setX(424);

	}
	/**
	 * getter for speed
	 * @return speed
	 */
	
	public double getSpeed() {
		return speed;
	}
	/**
	 * setter for speed
	 * @param d double to set new speed
	 */

	public void setSpeed(double d) {
		// TODO Auto-generated method stub
		speed = d;
	}
	
	/**
	 * getter for sunk boolean
	 * @return sunk 
	 * @see p4_group_8_repo.model.enemies.WetTurtle Wet Turtle
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	public  void addImages() {
		
	}

	/**
	 * getter of mouth
	 * @return bounds of mouth
	 * @see p4_group_8_repo.model.enemies.Crocodile Crocodile
	 */
	public Bounds getMouth() {
		// TODO Auto-generated method stub
		return mouth.getBoundsInLocal();
	}
	
}


