package p4_group_8_repo.model.carriers;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import p4_group_8_repo.model.gameAttributes.Actor;
import p4_group_8_repo.model.gameAttributes.Floatable;

/**
* <h1>Log class</h1>
* <p>
* This class is responsible for setting the logs
* it extends Floatable 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Floatable Floatable
*/
public class Log extends Floatable {

	Image img;//image of log

	/**
	 * constructor for a log
	 * @param imageLink, string of image location of log. 
	 * @param xpos int that specifies initial x position of log.
	 * @param ypos int that specifies initial y position of log.
	 * @param s int that specifies the speed of the log.
	 */
	
	public Log(String imageLink, int xpos, int ypos, double s) {
		img = new Image(imageLink);
		setImage(img);
		setX(xpos);
		setY(ypos);
		speed = s;
		size = img.getWidth();
	}



}
