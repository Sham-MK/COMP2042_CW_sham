package p4_group_8_repo;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -100 && speed<0)
			setX(424);
	} 
	
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
