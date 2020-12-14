package p4_group_8_repo.model.gameBase;

import javafx.scene.image.Image;

public class Levels extends Actor {

	Image img;

	public Levels(int x) {
		// TODO Auto-generated constructor stub
		img = new Image("file:src/main/resources/img/level.png", 15, 15, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

}
