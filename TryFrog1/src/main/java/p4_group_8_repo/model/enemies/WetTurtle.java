package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.carriers.Turtle;

/**
* <h1>Wet Turtle class</h1>
* <p>
* This class is responsible for setting the diving turtles
* it extends Floatable 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.carriers.Turtle Turtle
*/
public class WetTurtle extends Turtle{
	/*images for turtle animation*/

	Image turtles1;
	Image turtles2;
	Image turtles3;
	Image turtles4;

	/**
	 * constructor of wet turtles. calls super constructor Turtle
	 * @param xpos int which specifies the initial x position of the turtles.
	 * @param ypos int which specifies the initial y position of the turtles.
	 * @param s int that specifies the speed of the turtles.
	 * @param num_turtles int that specifies the number of turtles in animation
	 */
	public WetTurtle(int xpos, int ypos, double s, int num_turtles) {
		super(xpos, ypos, s, num_turtles);
	}
	/**
	 * this method is responsible for moving and animating the wet turtles.
	 * @param now long which is current time frame in nanoseconds.
	 */
	public void act(long now) {
		super.act(now);

		if (now/900000000  % 4 ==0) {
			setImage(turtles2);
			sunk = false;					
		}
		
		else if (now/900000000 % 4 == 1) {
			setImage(turtles3);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtles4);
			sunk = true;//if the last image is reached set sunk to true
		}
		else if (now/900000000 %4 == 3) {
			setImage(turtles1);
			sunk = false;
		}

		}
		
	/**
	 * This method is responsible for setting the images of the animation according to the number of turtles in the group.
	 */
	
	@Override
	public void addImages() {
		if(num_turtles == 2) {
			size = 60;
			turtles1 = new Image("/img/TurtleAnimation2-1.png", size,50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2-2Wet.png",size,50, true, true);
			turtles3 = new Image("/img/TurtleAnimation2-3Wet.png",size,50, true, true);
			turtles4 = new Image("/img/TurtleAnimation4Wet.png",  size,50, true, true);
		}else if(num_turtles == 3) {
			size = 90;
			turtles1 = new Image("/img/TurtleAnimation1.png", size,50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2Wet.png", size,50, true, true);
			turtles3 = new Image("/img/TurtleAnimation3Wet.png", size,50, true, true);
			turtles4 = new Image("/img/TurtleAnimation4Wet.png", size,50, true, true);
		}
	}
	

}
