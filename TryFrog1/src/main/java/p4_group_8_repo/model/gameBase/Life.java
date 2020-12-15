package p4_group_8_repo.model.gameBase;


import javafx.scene.image.Image;


public class Life extends Actor {

	Image img;
	int lives = 4;
	
	public Life() {
		
	}
	public void setLives() {
		for(int i=0; i<4; i++) {
			getWorld().add(new Life(0+(25*i)));
		}
	}
	public Life(int x) {
		img = new Image("file:src/main/resources/img/Life-icon.png", 20, 20, true, true);
		setImage(img);
		
		setX(x); 
		setY(565);
	}
	
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	
	}
	


	

	
}
