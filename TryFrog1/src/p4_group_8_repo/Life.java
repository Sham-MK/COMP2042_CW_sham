package p4_group_8_repo;

import java.util.ArrayList;


import javafx.scene.image.Image;

public class Life extends Actor {

	Image img;
	

	public Life(String n, int x) {
		// TODO Auto-generated constructor stub
		img = new Image("file:src/p4_group_8_repo/img/"+n+"-icon.png", 20, 20, true, true);
		setImage(img);
		setX(x); 
		setY(565);
	}
	
	public void setDead() {
		setImage( new Image("file:src/p4_group_8_repo/img/dead-icon.png", 20, 20, true, true));
		
	}
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	

	

	
}
