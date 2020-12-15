package p4_group_8_repo.model.scoreBoosters;

import java.util.Timer;

import javafx.scene.image.Image;
import p4_group_8_repo.controller.Player;
import p4_group_8_repo.model.carriers.Log;
import p4_group_8_repo.model.gameBase.Actor;

public class LadyFrog extends Actor {
	Image imgUP, imgLEFT, imgDOWN, imgRIGHT;
	double movement = 0.05;
	int imgSize = 28;
	boolean show = true;		
	Timer timer = new Timer();
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
	
		if(getIntersectingObjects(Log.class).size() >= 1) {
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);
		}
		if(getWorld().getObjects(Player.class).get(0).isAttached()) {
			getWorld().getObjects(Player.class).get(0).playMedia("bonus");
			getWorld().remove(this);
		}

		
	}

		
	}

		

		
		

	



