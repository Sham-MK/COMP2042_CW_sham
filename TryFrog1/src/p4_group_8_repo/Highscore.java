package p4_group_8_repo;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; // Import the Scanner class to read text files

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Highscore {
	
	int score;
	File file = new File("src/score.txt");

	
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
		System.out.println("succesfully written to a file"); 
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
			}

	}
	
	public void printscore(Frogger frog) {
		int old = new Highscore().read();
		int points = frog.getPoints();
		if(points>old) {
			new Highscore().update(points);
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("You Have Won The Game!");
    		alert.setHeaderText("New High Score: "+points+"!");
    		alert.setContentText("Old High Score: "+ old);
    		alert.show();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("You Have Won The Game!");
    		alert.setHeaderText("Your High Score: "+points+"!");
    		alert.setContentText("Highest Score: "+ old);
    		alert.show();
		}
	}
}
