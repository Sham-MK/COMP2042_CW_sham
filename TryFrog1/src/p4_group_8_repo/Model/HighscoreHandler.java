package p4_group_8_repo.Model;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import p4_group_8_repo.Controller.Player;

public class HighscoreHandler {
	
	int score;
	File file = new File("src/p4_group_8_repo/Model/score.txt");

	
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
	
	public void printscore(Player frog) {
		int old = new HighscoreHandler().read();
		int points = frog.getPoints();
		if(points>old) {
			new HighscoreHandler().update(points);
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
