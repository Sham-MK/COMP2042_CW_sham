package p4_group_8_repo.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.image.Image;
import p4_group_8_repo.Controller.Player;

public class Score extends Actor {

	public Score() {
		
	}
	File file = new File("src/p4_group_8_repo/Model/score.txt");
	int score;
	int dim;
	Image im1;
	
	public void setHighScore() {
		int shift = 0;
		int n = read();
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getWorld().add(new Score(k, 30, 330 - shift, 25));
    		  shift+=30;
    		}
	}
	
	public void setscore(int n) {
    	int shift1= 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getWorld().add(new Score(k, 30, 150 - shift1, 25));
    		  shift1+=30;
    		}
    }
	
	public int read() {

		try {
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextInt()) {
		      score = myReader.nextInt();
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("The file does not exist.");
		      e.printStackTrace();
		    }
		return score;
	}
	
	public void update(int newScore) {
		try { FileWriter writer = new FileWriter(file); 
		BufferedWriter bwr = new BufferedWriter(writer); 
		bwr.write(Integer.toString(newScore)); 
		bwr.close(); 
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
			}

	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().getObjects(Player.class).get(0).changeScore()) {
    		setscore(getWorld().getObjects(Player.class).get(0).getPoints());
    	}
		
	}
	
	public  Score(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/View/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y); 
	}

}
