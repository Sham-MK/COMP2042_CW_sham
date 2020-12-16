package p4_group_8_repo.model.gameBase;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class Floatable extends Actor {
	
	protected double speed;
	protected double size;
	protected boolean sunk = false;
	protected Rectangle mouth = new Rectangle();


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -size && speed<0)
			setX(424);

	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double d) {
		// TODO Auto-generated method stub
		speed = d;
	}
	public boolean isSunk() {
		return sunk;
	}
	
	public  void addImages() {
		
	}

	public Bounds getMouth() {
		// TODO Auto-generated method stub
		return mouth.getBoundsInLocal();
	}
	
}


