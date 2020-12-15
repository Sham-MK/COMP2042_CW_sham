package p4_group_8_repo.model.enemies;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import p4_group_8_repo.model.gameBase.Actor;

public class Crocodile extends Actor {

	Image crocodile1;
	Image crocodile2;
	boolean show=false;
    Rectangle mouth = new Rectangle();
    double x;
    double y;
	public void setShow() {
		show = true;
	}
	private double speed;
	
	public double getSpeed() {
		return speed;
	}

	@Override
	public void act(long now) {

			if (now/900000000  % 2 ==0) {
				setImage(crocodile1);

			}
			else if (now/900000000 % 2 == 1) {
				setImage(crocodile2);
			}			
			
		move(speed , 0);
		if (getX()>424 && speed>0)
			setX(-220);
		if (getX()<-400 && speed<0)
			setX(524);
		
		x = this.getBoundsInLocal().getMaxX();
		y = this.getY();
	}
	public Crocodile(double xpos, int ypos, double s) {

			crocodile1 = new Image("/img/crocodile.png", 130, 100, true, true);
			crocodile2 = new Image("/img/crocodile1.png", 130, 100, true, true);


		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public Bounds getMouth() {
		mouth.setX(x-45);
		mouth.setY(y);
		mouth.setWidth(45);
		mouth.setHeight(50);
		return mouth.getBoundsInLocal();
	}
	
}
