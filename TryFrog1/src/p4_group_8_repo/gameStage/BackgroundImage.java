package p4_group_8_repo.gameStage;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 500, 600, true, true));
		
	}

}
