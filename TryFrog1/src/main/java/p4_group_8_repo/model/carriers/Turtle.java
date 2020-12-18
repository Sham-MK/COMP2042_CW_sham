package p4_group_8_repo.model.carriers;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import p4_group_8_repo.model.gameAttributes.Floatable;

/**
* <h1>Turtle class</h1>
* <p>
* This class is responsible for setting the turtles
* it extends Floatable 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Floatable Floatable
*/
public class Turtle extends Floatable{
	/*images for turtle animation*/
	Image turtles1;
	Image turtles2;
	Image turtles3;
	protected int num_turtles;	//number of turtles in group

	
	/**
	 * constructor of turtles.
	 * @param xpos int which specifies the initial x position of the turtles.
	 * @param ypos int which specifies the initial y position of the turtles.
	 * @param s int that specifies the speed of the turtles.
	 * @param num_turtles int that specifies the number of turtles in animation
	 */
	public Turtle(int xpos, int ypos, double s, int num_turtles) {
		this.num_turtles = num_turtles;
		setX(xpos);
		setY(ypos);
		speed = s;
		addImages();
		setImage(turtles1);
	}
	/**
	 * this method is responsible for moving and animating the turtles.
	 * @param now long which is current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		super.act(now);

		if (now/900000000  % 3 ==0) {
			setImage(turtles2);			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtles1);
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtles3);
		} 

	}
	/**
	 * This method is responsible for setting the images of the animation according to the number of turtles in the group.
	 */
	public void addImages() {
		if(num_turtles == 2) {
			size = 60;
			turtles1 = new Image("/img/TurtleAnimation2-1.png", 60, 50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2-2.png", 60, 50, true, true);
			turtles3 = new Image("/img/TurtleAnimation2-3.png", 60, 50, true, true);
		}else if(num_turtles == 3) {
			size = 90;
			turtles1 = new Image("/img/TurtleAnimation1.png", 90, 50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2.png", 90, 50, true, true);
			turtles3 = new Image("/img/TurtleAnimation3.png", 90, 50, true, true);
		}
	}



}
