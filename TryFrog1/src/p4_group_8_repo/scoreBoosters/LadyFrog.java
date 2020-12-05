package p4_group_8_repo.scoreBoosters;

import java.util.Timer;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;
import p4_group_8_repo.Player;
import p4_group_8_repo.carriers.Log;

public class LadyFrog extends Actor {
	Image imgUP;
	double movement = 0.05;
	int imgSize = 28;
	boolean show = true;		
	Timer timer = new Timer();
	public LadyFrog(double x, double y) {
		// TODO Auto-generated constructor stub
		imgUP = new Image("file:src/p4_group_8_repo/img/lUp.png", imgSize, imgSize, true, true);
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
		if(getWorld().getObjects(Player.class).get(0).isAttached()) {
			setImage(null);
			
		}

		
	}

		
	}

		

		
		

	



