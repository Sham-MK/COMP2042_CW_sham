package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;

public class Snake extends Actor {

	Image snake1;
	Image snake2;
	double speed;
	public Snake(String n, double xpos, int ypos, double s) {
		// TODO Auto-generated constructor stub
		if(n =="snake") {
		     snake1 = new Image("file:src/main/resources/img/snake1.png", 80, 80, true, true);
		     snake2 = new Image("file:src/main/resources/img/snake2.png", 80, 80, true, true);
		}else if(n =="snakew") {
			snake1 = new Image("file:src/main/resources/img/snakew.png", 25, 25, true, true);
			snake2 = new Image("file:src/main/resources/img/snakew1.png", 25, 25, true, true);
		}
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
