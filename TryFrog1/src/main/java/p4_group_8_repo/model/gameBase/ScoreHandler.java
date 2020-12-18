package p4_group_8_repo.model.gameBase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class ScoreHandler extends Actor {
	static File file = new File("src/main/resources/score.txt");//file path
	int score;//Highscore
	int dim;//size of digit
	Image im1;//image of digit
	ArrayList<Integer> highScores = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();

	/**
	 * default dummy constructor
	 */
	public ScoreHandler() {
		 if (!file.exists()) {
	          try {
				file.createNewFile();
				FileWriter myWriter = new FileWriter(file);
			    myWriter.write("Empty\t0\nEmpty\t0\nEmpty\t0\nEmpty\t0\nEmpty\t0");
			    myWriter.close();
			    System.out.println("Successfully wrote to the file.");
	          }
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          System.out.println("File created: " + file.getName());
		 }
		 highScores = getHighscores();


	}

	
	/**
	 * this method sets the images of the digits for highscore in the right position
	 * it divides by tens and shifts the digit images by one position
	 */
	public void setHighScore() {
		int shift = 0;
		int n = readHighest();
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  getWorld().add(new ScoreHandler(k, 30, 330 - shift, 25));
    		  shift+=30;
    		}
	}
	
	public boolean isHigher(int points,String name) {
		 names = getNames();
		for (int i=0; i<highScores.size();i++) {
			if(points>highScores.get(i)) {
				highScores.set(i, points);
				update();
				names.set(i, name);
				return true;
			}
		}
		return false;
		
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
    		  getWorld().add(new ScoreHandler(k, 30, 150 - shift1, 25));
    		  shift1+=30;
    		}
    }
	/**
	 * This method is responsible for reading the highscore from a textfile 
	 * @return score highscore stored in a file
	 */
    public int readHighest() {
    	int highScore = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null)                 // read the score file line by line
            {
                try {
                    int score = Integer.parseInt(line.split("-")[1]);   // parse each line as an int
                    if (score > highScore)                       //  keep track of the largest
                    { 
                        highScore = score; 
                    }
                } catch (NumberFormatException e1) {
                    // ignore invalid scores
                    System.err.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }
        return highScore;

    }

	/**
	 * This method is responsible for updating the highscore in the text file.
	 * @param newScore new score to be updated in file
	 */
	public void update() {
		  Path filePath = Paths.get(file.toURI());
		  ArrayList<String> lines = new ArrayList<>();
		  for (int i=0; i<highScores.size();i++) {
			  lines.add(names.get(i)+"-"+highScores.get(i));		  
		  }
          try{
              System.out.println("File Saved");
              Files.write(filePath, lines , Charset.defaultCharset());
          }catch(IOException e){
              e.printStackTrace();
          }

	}

	public ArrayList<Integer> getHighscores(){
			 List<String> list = new ArrayList<>();
			 ArrayList<Integer> listnum = new ArrayList<>();

	            try {
	    			list= Files.readAllLines(Paths.get(file.toURI()),StandardCharsets.UTF_8 );
	    		} catch (IOException e) {
	    			System.out.println("Can't read file into list");
	    		}
	            for(String str:list) {
	            	listnum.add(Integer.parseInt(str.split("-")[1]));
	            }
	            return listnum;		          
		}
	
	public ArrayList<String> getNames(){
		 List<String> list = new ArrayList<>();
		 ArrayList<String> listname = new ArrayList<>();

            try {
    			list= Files.readAllLines(Paths.get(file.toURI()),StandardCharsets.UTF_8 );
    		} catch (IOException e) {
    			System.out.println("Can't read file into list");
    		}
            for(String str:list) {
            	listname.add(str.substring(0, str.indexOf("-")));
            }
            return listname;
	          
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
	public  ScoreHandler(int n, int dim, int x, int y) {
		im1 = new Image("/img/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y); 
	}
	

}
