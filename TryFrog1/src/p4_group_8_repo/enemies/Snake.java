package p4_group_8_repo.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class Snake extends Actor {

	Image snake1;
	Image snake2;
	double speed;
	public Snake(String n, double xpos, int ypos, double s) {
		// TODO Auto-generated constructor stub
		if(n =="snake") {
		     snake1 = new Image("file:src/p4_group_8_repo/img/snake1.png", 80, 80, true, true);
		     snake2 = new Image("file:src/p4_group_8_repo/img/snake2.png", 80, 80, true, true);
		}else if(n =="snakew") {
			snake1 = new Image("file:src/p4_group_8_repo/img/snakew.png", 35, 35, true, true);
			snake2 = new Image("file:src/p4_group_8_repo/img/snakew1.png", 35, 35, true, true);
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
        if (getX()>424 && speed>0)
	    setX(-220);
        if (getX()<-400 && speed<0)
	    setX(524);
	   }

}
