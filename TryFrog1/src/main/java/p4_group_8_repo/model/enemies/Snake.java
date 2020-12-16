package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

/**
* <h1>Snake class</h1>
* <p>
* This class is responsible for setting the snake in the game scene
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/
public class Snake extends Actor {

	/*images for snake animation*/
	Image snake1;
	Image snake2;
	double speed;//speed of snake
	/**
	 * constructor for snake
	 * @param xpos int that specifies initial x position of snake
	 * @param ypos int that specifies initial y position of snake
	 * @param s int that specifies the speed of snake
	 */
	public Snake(double xpos, int ypos, double s) {
		// TODO Auto-generated constructor stub
	     snake1 = new Image("/img/snake1.png", 80, 80, true, true);
	     snake2 = new Image("/img/snake2.png", 80, 80, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(snake1);
		
	}

	/**
	 * this method is responsible for moving and animating the snake.
	 * @param now long which is current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000  % 2 ==0) {
			setImage(snake1);

		}
		else if (now/900000000 % 2 == 1) {
			setImage(snake2);
		}				
	
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -145 && speed<0)
			setX(424);
	   }
	/**
	 * setter for speed
	 * @param i new speed
	 */

	public void setSpeed(int i) {
		// TODO Auto-generated method stub
		speed = i;
		
	}

}
