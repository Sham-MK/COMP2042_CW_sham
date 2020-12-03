package p4_group_8_repo;

import javafx.scene.image.Image;

public class Crocodile extends Actor {

	Image crocodile1;
	Image crocodile2;
	boolean show=false;
	
    public void setShow() {
		show = true;
	}
	boolean jawopen =false;
	private double speed;
	
	public double getSpeed() {
		return speed;
	}

	@Override
	public void act(long now) {
		if(show) {
			crocodile1 = new Image("file:src/p4_group_8_repo/img/crocodile.png", 130, 100, true, true);
			crocodile2 = new Image("file:src/p4_group_8_repo/img/crocodile1.png", 130, 100, true, true);
		}
		else {
			crocodile1 = null;
			crocodile2 = null;
		}

			if (now/900000000  % 2 ==0) {
				setImage(crocodile1);
				jawopen = false;

			}
			else if (now/900000000 % 2 == 1) {
				setImage(crocodile2);
				jawopen = true;
			}			
			
		move(speed , 0);
		if (getX()>424 && speed>0)
			setX(-220);
		if (getX()<-400 && speed<0)
			setX(524);
	}
	public Crocodile(double xpos, int ypos, double s) {
		
		setX(xpos);
		setY(ypos);
		speed = s;
	}
}
