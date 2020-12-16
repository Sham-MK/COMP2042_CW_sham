package p4_group_8_repo.model.scoreBoosters;

import java.util.Timer;

import javafx.scene.image.Image;
import p4_group_8_repo.controller.Player;
import p4_group_8_repo.model.carriers.Log;
import p4_group_8_repo.model.gameBase.Actor;
/**
* <h1>Lady Frog class</h1>
* <p>
* This class is responsible for setting the lady frog 
* which periodically appears on different logs in the game scene 
* it extends Actor 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/
public class LadyFrog extends Actor {
	Image imgUP, imgLEFT, imgDOWN, imgRIGHT;//images of lady frog
	int imgSize = 28;//size of lady frog
	/**
	 * Constructor for lady frog
	 * @param x x position on pane
	 * @param y y position on pane
	 */
	public LadyFrog(double x, double y) {
		// TODO Auto-generated constructor stub
		imgLEFT = new Image("/img/lLeft.png", imgSize, imgSize, true, true);
		imgDOWN = new Image("/img/lDown.png", imgSize, imgSize, true, true);
		imgRIGHT = new Image("/img/lRight.png", imgSize, imgSize, true, true);
		imgUP = new Image("/img/lUp.png", imgSize, imgSize, true, true);
		setImage(imgUP);
		setX(x+50);
		setY(y);

		
	}
	/**
	 * This act method is responsible for moving, animating lady frog and checking its intersections.
	 * @param now current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(imgRIGHT);
			
		}
		else if (now/900000000 % 4 == 2) {
			setImage(imgUP);
			
		}


		if (getX()>424) {
			 setX(-170);}
		if (getX()<-400) {
			 setX(470);}
	
		if(getIntersectingObjects(Log.class).size() >= 1) {//if on the log, then move with its speed.
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);
		}
		if(getWorld().getObjects(Player.class).get(0).isAttached()) {//if intersected player then play bonus sound and remove this from pane
			getWorld().getObjects(Player.class).get(0).playMedia("bonus");
			getWorld().remove(this);
		}

		
	}

		
	}

		

		
		

	



