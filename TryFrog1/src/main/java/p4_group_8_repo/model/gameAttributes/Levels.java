package p4_group_8_repo.model.gameAttributes;

import javafx.scene.image.Image;

/**
* <h1>Level Cleared class</h1>
* <p>
* This class is responsible for setting the levels 
* images in the game scene whenever player reaches a new level.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class Levels extends Actor {

	Image img;//image of levels block

	/**
	 * constructor of levels
	 * @param x x position of level
	 */
	public Levels(int x) {
		// TODO Auto-generated constructor stub
		img = new Image("/img/level.png", 15, 15, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

}
