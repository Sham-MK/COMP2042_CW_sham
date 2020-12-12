package p4_group_8_repo.levelsAndScore;

import java.util.ArrayList;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class Life extends Actor {

	Image img;
	

	public Life(int x) {
		// TODO Auto-generated constructor stub
		img = new Image("file:src/p4_group_8_repo/img/Life-icon.png", 20, 20, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}
	
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	

	

	
}
