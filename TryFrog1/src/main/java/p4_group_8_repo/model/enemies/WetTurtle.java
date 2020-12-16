package p4_group_8_repo.model.enemies;

import javafx.scene.image.Image;
import p4_group_8_repo.model.carriers.Turtle;

public class WetTurtle extends Turtle{
	Image turtles1;
	Image turtles2;
	Image turtles3;
	Image turtles4;

	public WetTurtle(int xpos, int ypos, double s, int num_turtles) {
		super(xpos, ypos, s, num_turtles);
	}
	
	public void act(long now) {
		super.act(now);

		if (now/900000000  % 4 ==0) {
			setImage(turtles2);
			sunk = false;					
		}
		
		else if (now/900000000 % 4 == 1) {
			setImage(turtles3);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtles4);
			sunk = true;
		}
		else if (now/900000000 %4 == 3) {
			setImage(turtles1);
			sunk = false;
		}

		}
		
	
	@Override
	public void addImages() {
		if(num_turtles == 2) {
			size = 60;
			turtles1 = new Image("/img/TurtleAnimation2-1.png", size,50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2-2Wet.png",size,50, true, true);
			turtles3 = new Image("/img/TurtleAnimation2-3Wet.png",size,50, true, true);
			turtles4 = new Image("/img/TurtleAnimation4Wet.png",  size,50, true, true);
		}else if(num_turtles == 3) {
			size = 90;
			turtles1 = new Image("/img/TurtleAnimation1.png", size,50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2Wet.png", size,50, true, true);
			turtles3 = new Image("/img/TurtleAnimation3Wet.png", size,50, true, true);
			turtles4 = new Image("/img/TurtleAnimation4Wet.png", size,50, true, true);
		}
	}
	

}
