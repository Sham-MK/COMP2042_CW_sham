package p4_group_8_repo;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class LadyFrog extends Actor {
	Image imgUP;
	Image imgLEFT;
	Image imgDOWN;
	Image imgRIGHT;
	Image imgUPJ;
	Image imgLEFTJ;
	Image imgDOWNJ;
	Image imgRIGHTJ;
	double movement = 0.05;
	int imgSize = 28;
	boolean show = true;		
	Timer timer = new Timer();
	public LadyFrog(double x, double y) {
		// TODO Auto-generated constructor stub
		imgUP = new Image("file:src/p4_group_8_repo/img/lUp.png", imgSize, imgSize, true, true);
		imgLEFT = new Image("file:src/p4_group_8_repo/img/lLeft.png", imgSize, imgSize, true, true);
		imgDOWN = new Image("file:src/p4_group_8_repo/img/lDown.png", imgSize, imgSize, true, true);
		imgRIGHT = new Image("file:src/p4_group_8_repo/img/lRight.png", imgSize, imgSize, true, true);
		imgUPJ = new Image("file:src/p4_group_8_repo/img/lUpJump.png", imgSize, imgSize, true, true);
		imgLEFTJ = new Image("file:src/p4_group_8_repo/img/lLeftJump.png", imgSize, imgSize, true, true);
		imgDOWNJ = new Image("file:src/p4_group_8_repo/img/lDownJump.png", imgSize, imgSize, true, true);
		imgRIGHTJ = new Image("file:src/p4_group_8_repo/img/lRightJump.png", imgSize, imgSize, true, true);
		setImage(imgUP);
		setX(x+50);
		setY(y);

		
	}
	@Override
	public void act(long now) {
		if (getX()>424) {
			 setX(-220);}
		if (getX()<-400) {
			 setX(524);}
	
		if(getIntersectingObjects(Log.class).size() >= 1) {
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);
		}
		if(getWorld().getObjects(Frogger.class).get(0).isAttached()) {
			setImage(null);
			
		}
		move(2,0);
		move(-1,0);
		
	}

		
	}

		

		
		

	



