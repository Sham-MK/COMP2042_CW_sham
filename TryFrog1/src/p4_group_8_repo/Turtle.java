package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private double speed;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-100);
		if (getX() < -200 && speed<0)
			setX(424);
	}
	public Turtle(int xpos, int ypos, double s, int w, int h, int num_turtles) {
		if(num_turtles == 2) {
			turtle1 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-1.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-2.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-3.png", w, h, true, true);
		}else if(num_turtles == 1) {
			turtle1 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation1.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation3.png", w, h, true, true);
		}
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle1);
	}
}
