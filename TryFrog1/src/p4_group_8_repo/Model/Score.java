package p4_group_8_repo.Model;

import javafx.scene.image.Image;
import p4_group_8_repo.Controller.Player;

public class Score extends Actor {

	public Score() {
		
	}
	
	int dim;
	Image im1;
	
	public void setNumber(int n, String type) {
    	switch(type) {
    	  case "highscore":
    		  int shift = 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  getWorld().add(new Score(k, 30, 330 - shift, 25));
    	    		  shift+=30;
    	    		}
    	    break;
    	  case "score":
    		  int shift1= 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  getWorld().add(new Score(k, 30, 150 - shift1, 25));
    	    		  shift1+=30;
    	    		}
    	    break;
    	  default:
    	    // code block
    	}
    }

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().getObjects(Player.class).get(0).changeScore()) {
    		setNumber(getWorld().getObjects(Player.class).get(0).getPoints(), "score");
    	}
		
	}
	
	public  Score(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/View/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y); 
	}

}
