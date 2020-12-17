package p4_group_8_repo.model.gameBase;


import javafx.scene.image.Image;

/**
* <h1>Level Cleared class</h1>
* <p>
* This class is responsible for setting the life 
* images of the player in the game scene.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/
public class Life extends Actor {

	Image img;/**image of life*/
	
	public Life() {
		
	}

	/**
	 * Constructor for Life
	 * @param x x position of Life on pane
	 */
	public Life(int x) {
		img = new Image("/img/Life-icon.png", 20, 20, true, true);
		setImage(img);
		
		setX(x); 
		setY(565);
	}
	
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	
	}
	


	

	
}
