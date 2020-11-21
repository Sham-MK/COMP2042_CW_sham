package p4_group_8_repo;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private double speed;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 424 && speed>0)
			setX(-100);
		if (getX() < -200 && speed<0) {
			setX(424);
		}
		
	}
	public WetTurtle(int xpos, int ypos, double s, int w, int h, int num_turtles) {
		if(num_turtles == 3) {
			turtle1 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation1.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2Wet.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation3Wet.png", w, h, true, true);
			turtle4 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation4Wet.png", w, h, true, true);
		}else if(num_turtles == 2) {
			turtle1 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-1.png", w, h, true, true);
			turtle2 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-2Wet.png", w, h, true, true);
			turtle3 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-3Wet.png", w, h, true, true);
			turtle4 = new Image("file:src/p4_group_8_repo/img/TurtleAnimation2-4Wet.png", w, h, true, true);
		}
	
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);

	}
	
	public boolean isSunk() {
		return sunk;
	}
}
