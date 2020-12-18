package p4_group_8_repo.model.gameBase;

import javafx.scene.image.Image;
/**
* <h1>Digit class</h1>
* <p>
* This class is responsible for setting current score 
* and highscore of the player in the game scene.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/
import p4_group_8_repo.controller.Player;

public class Digit extends Actor {
	int score;//Highscore
	int dim;//size of digit
	Image im1;//image of digit
	ScoreHandler scorePointer = new ScoreHandler();
	
	/**
	 * dummy constructor
	 */
	public Digit() {
		
	}
	/**
	 * constructor for score that sets digit images on the scene
	 * @param n digit number
	 * @param dim size
	 * @param x x position of digit.
	 * @param y y position of digit.
	 */
	public  Digit(int n, int dim, int x, int y) {
		im1 = new Image("/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y); 
	}
	/**
	 * This method is responsible for printing the Highscore on the screen;
	 */
	public void setHighScore() {
		int shift = 0;
		int n = scorePointer.readHighest();
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getWorld().add(new Digit(k, 30, 330 - shift, 25));
    		  shift+=30;
    		}
	}
	/**
	 * this method sets the images of the digits for current score in the right position
	 * it divides by tens and shifts the digit images by one position 
	 * @param n int for current points of player
	 */
	public void setscore(int n) {
    	int shift1= 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getWorld().add(new Digit(k, 30, 150 - shift1, 25));
    		  shift1+=30;
    		}
    }
	/**
	 * This method is responsible for updating the current score in the game scene
	 */

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().getObjects(Player.class).get(0).changeScore()) {//if player changes score then update it
    		setscore(getWorld().getObjects(Player.class).get(0).getPoints());
    	}

	}

}
