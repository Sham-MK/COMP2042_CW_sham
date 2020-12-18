package p4_group_8_repo.model.gameAttributes;

import javafx.scene.image.Image;

/**
* <h1>Background Image class</h1>
* <p>
* This class is responsible for setting the background image game scene.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameAttributes.Actor Actor
*/
public class BackgroundImage extends Actor{

	/**
	 * constructor of background image
	 */
	public BackgroundImage() {
		setImage(new Image("/img/iKogsKW.png", 500, 600, true, true));
		
	}
	
	@Override
	public void act(long now) {
		
		
	}

}
