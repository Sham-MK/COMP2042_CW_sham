package p4_group_8_repo.model.gameBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.image.Image;
import p4_group_8_repo.controller.Player;

/**
* <h1>Score class</h1>
* <p>
* This class is responsible for setting current score 
* and highscore of the player in the game scene.
* it extends Actor. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see p4_group_8_repo.model.gameBase.Actor Actor
*/

public class Score extends Actor {

	/**
	 * default dummy constructor
	 */
	public Score() {
		
	}
	File file = new File("src/main/resources/score.txt");//file path
	int score;//Highscore
	int dim;//size of digit
	Image im1;//image of digit
	
	/**
	 * this method sets the images of the digits for highscore in the right position
	 * it divides by tens and shifts the digit images by one position
	 */
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
	
	/**
	 * this method sets the images of the digits for current score in the right position
	 * it divides by tens and shifts the digit images by one position 
	 * @param n int for current points of player
	 */
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
	/**
	 * This method is responsible for reading the highscore from a textfile 
	 * @return score highscore stored in a file
	 */
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
	/**
	 * This method is responsible for updating the highscore in the text file.
	 * @param newScore new score to be updated in file
	 */
	public void update(int newScore) {
		try { FileWriter writer = new FileWriter(file); 
		BufferedWriter bwr = new BufferedWriter(writer); 
		bwr.write(Integer.toString(newScore)); 
		bwr.close(); 
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
			}

	}
	/**
	 * This method is responsible for updating the current score in the game scene
	 */

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().getObjects(Player.class).get(0).changeScore()) {//if player changes score then update it
    		setscore(getWorld().getObjects(Player.class).get(0).getPoints());
    	}
		
	}
	
	/**
	 * constructor for score that sets digit images on the scene
	 * @param n digit number
	 * @param dim size
	 * @param x x position of digit.
	 * @param y y position of digit.
	 */
	public  Score(int n, int dim, int x, int y) {
		im1 = new Image("/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y); 
	}

}
