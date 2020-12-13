package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

public class Car extends Actor {
	private double speed;
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -145 && speed<0)
			setX(424);
	} 
	
	public Car(String imageLink, double xpos, int ypos, double s) {
		setImage(new Image(imageLink,getWidth(),30,true,true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
