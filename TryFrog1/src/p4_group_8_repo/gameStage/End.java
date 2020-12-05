package p4_group_8_repo.gameStage;

import javafx.scene.image.Image;
import p4_group_8_repo.Actor;

public class End extends Actor{
	boolean activated = false;
	@Override 
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x) {
		setX(x); 
		setY(67);
		setImage(new Image("file:src/p4_group_8_repo/img/End.png", 50, 50, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/img/FrogEnd.png", 50, 50, true, true));
		activated = true;
	}
	public void unsetEnd() {
		setImage(new Image("file:src/p4_group_8_repo/img/End.png", 50, 50, true, true));
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
