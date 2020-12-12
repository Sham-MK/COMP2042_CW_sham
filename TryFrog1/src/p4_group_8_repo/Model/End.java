package p4_group_8_repo.Model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override 
	public void act(long now) {
		// TODO Auto-generated method 

	}
	
	public End(int x) {
		setX(x); 
		setY(67);
		setImage(new Image("file:src/p4_group_8_repo/View/img/End.png", 50, 50, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/View/img/FrogEnd.png", 50, 50, true, true));
		activated = true;
	}
	public void unsetEnd() {
		setImage(new Image("file:src/p4_group_8_repo/View/img/End.png", 50, 50, true, true));
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
