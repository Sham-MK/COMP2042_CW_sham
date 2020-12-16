package p4_group_8_repo.model.carriers;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import p4_group_8_repo.model.gameBase.Actor;
import p4_group_8_repo.model.gameBase.Floatable;

public class Log extends Floatable {

	Image img;

	
	public Log(String imageLink, int xpos, int ypos, double s) {
		img = new Image(imageLink);
		setImage(img);
		setX(xpos);
		setY(ypos);
		speed = s;
		size = img.getWidth();
	}



}
