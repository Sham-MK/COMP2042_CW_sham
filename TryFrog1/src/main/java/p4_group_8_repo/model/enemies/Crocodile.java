package p4_group_8_repo.model.enemies;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import p4_group_8_repo.model.gameBase.Actor;
import p4_group_8_repo.model.gameBase.Floatable;

/**
* <h1>Crocodile class</h1>
* <p>
* This class is responsible for setting the crocodile
* it extends Floatable 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Floatable Floatable
*/
public class Crocodile extends Floatable {

	/*images of crocodile animation*/
	Image crocodile1;
	Image crocodile2;
    double x;//x position on pane
    double y;//y position on pane


    /**
	 * this method is responsible for moving and animating the crocodile.
	 * @param now long which is current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {

		super.act(now);

		if (now/900000000  % 2 ==0) {
			setImage(crocodile1);

		}
		else if (now/900000000 % 2 == 1) {
			setImage(crocodile2);
		}			
	
		x = this.getBoundsInLocal().getMaxX();//position of mouth tip.
		y = this.getY();
	}
	/**
	 * crocodile constructor
	 * @param xpos int that specifies initial x position of crocodile
	 * @param ypos int that specifies initial y position of crocodile
	 * @param s int that specifies the speed of crocodile
	 */
	public Crocodile(double xpos, int ypos, double s) {
		addImages();
		setX(xpos);
		setY(ypos);
		speed = s;
		size = 130;
	}
	/**
	 * This method is responsible for returning the exact position of the crocodile mouth
	 * @return mouth Bounds
	 */

	public Bounds getMouth() {
		mouth.setX(x-45);
		mouth.setY(y);
		mouth.setWidth(45);
		mouth.setHeight(50);
		return mouth.getBoundsInLocal();
	}

	/**
	 * This method is responsible for setting the images of the animation.
	 */
	@Override
	public void addImages() {
		// TODO Auto-generated method stub
		crocodile1 = new Image("/img/crocodile.png", 130, 100, true, true);
		crocodile2 = new Image("/img/crocodile1.png", 130, 100, true, true);
	}
	
}
