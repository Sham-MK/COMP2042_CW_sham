package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameAttributes.Actor;
/**
* <h1>Car class</h1>
* <p>
* This class is responsible for setting the cars in the game scene
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class Car extends Actor {
	private double speed;//speed of car


	/**
	 * this method is responsible for moving the car.
	 * @param now long which is current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -145 && speed<0)
			setX(424);
	} 
	
	/**
	 * Constructor for car
	 * @param imageLink image of car or truck
	 * @param xpos x position on pane
	 * @param ypos y position on pane
	 * @param s speed of car
	 */
	
	public Car(String imageLink, double xpos, int ypos, double s) {
		setImage(new Image(imageLink,getWidth(),30,true,true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * getter of speed
	 * @return speed speed of the car
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * setter of speed
	 * @param speed new speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
