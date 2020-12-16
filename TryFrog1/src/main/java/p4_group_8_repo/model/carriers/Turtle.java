package p4_group_8_repo.model.carriers;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Floatable;

public class Turtle extends Floatable{
	Image turtles1;
	Image turtles2;
	Image turtles3;
	protected int num_turtles;	

	
	public Turtle(int xpos, int ypos, double s, int num_turtles) {
		this.num_turtles = num_turtles;
		setX(xpos);
		setY(ypos);
		speed = s;
		addImages();
		setImage(turtles1);
	}
	
	@Override
	public void act(long now) {
		super.act(now);

		if (now/900000000  % 3 ==0) {
			setImage(turtles2);			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtles1);
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtles3);
		} 

	}
	
	public void addImages() {
		if(num_turtles == 2) {
			size = 60;
			turtles1 = new Image("/img/TurtleAnimation2-1.png", 60, 50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2-2.png", 60, 50, true, true);
			turtles3 = new Image("/img/TurtleAnimation2-3.png", 60, 50, true, true);
		}else if(num_turtles == 3) {
			size = 90;
			turtles1 = new Image("/img/TurtleAnimation1.png", 90, 50, true, true);
			turtles2 = new Image("/img/TurtleAnimation2.png", 90, 50, true, true);
			turtles3 = new Image("/img/TurtleAnimation3.png", 90, 50, true, true);
		}
	}



}
