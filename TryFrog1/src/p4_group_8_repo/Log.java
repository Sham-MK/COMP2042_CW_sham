package p4_group_8_repo;

import javafx.scene.image.Image;

public class Log extends Actor {

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
		if (getX()>424 && speed>0)
			setX(-220);
		if (getX()<-400 && speed<0)
			setX(524);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		
	}
	public boolean getRight() {
		return speed > 424;
	}
}
