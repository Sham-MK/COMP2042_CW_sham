package p4_group_8_repo.levelsAndScore;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class Level extends Actor {

	Image img;

	public Level(int x) {
		// TODO Auto-generated constructor stub
		img = new Image("file:src/p4_group_8_repo/img/Level.png", 15, 15, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

}
