package p4_group_8_repo.model.carriers;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

public class Log extends Actor {

	private double speed;
	public double getSpeed() {
		return speed;
	}



	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>424 && speed>0)
			setX(-220);
		if (getX()<-400 && speed<0)
			setX(524);
	}
	
	public Log(String imageLink, int xpos, int ypos, double s) {
		setImage(new Image(imageLink));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}



	public void setSpeed(double i) {
		// TODO Auto-generated method stub
		speed = i;
		
	}
}
