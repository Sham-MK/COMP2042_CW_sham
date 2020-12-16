package p4_group_8_repo.model.enemies;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import p4_group_8_repo.model.gameBase.Actor;
import p4_group_8_repo.model.gameBase.Floatable;

public class Crocodile extends Floatable {

	Image crocodile1;
	Image crocodile2;
    double x;
    double y;


	@Override
	public void act(long now) {

		super.act(now);

		if (now/900000000  % 2 ==0) {
			setImage(crocodile1);

		}
		else if (now/900000000 % 2 == 1) {
			setImage(crocodile2);
		}			
	
		x = this.getBoundsInLocal().getMaxX();
		y = this.getY();
	}
	public Crocodile(double xpos, int ypos, double s) {
		addImages();
		setX(xpos);
		setY(ypos);
		speed = s;
		size = 130;
	}

	public Bounds getMouth() {
		mouth.setX(x-45);
		mouth.setY(y);
		mouth.setWidth(45);
		mouth.setHeight(50);
		return mouth.getBoundsInLocal();
	}

	@Override
	public void addImages() {
		// TODO Auto-generated method stub
		crocodile1 = new Image("/img/crocodile.png", 130, 100, true, true);
		crocodile2 = new Image("/img/crocodile1.png", 130, 100, true, true);
	}
	
}
