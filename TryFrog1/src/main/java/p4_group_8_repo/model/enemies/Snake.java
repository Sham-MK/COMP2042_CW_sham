package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

public class Snake extends Actor {

	Image snake1;
	Image snake2;
	double speed;
	public Snake(double xpos, int ypos, double s) {
		// TODO Auto-generated constructor stub
	     snake1 = new Image("/img/snake1.png", 80, 80, true, true);
	     snake2 = new Image("/img/snake2.png", 80, 80, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(snake1);
		
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000  % 2 ==0) {
			setImage(snake1);

		}
		else if (now/900000000 % 2 == 1) {
			setImage(snake2);
		}				
	
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-200);
		if (getX() < -145 && speed<0)
			setX(424);
	   }

	public void setSpeed(int i) {
		// TODO Auto-generated method stub
		speed = i;
		
	}

}
