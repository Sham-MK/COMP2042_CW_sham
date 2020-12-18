package p4_group_8_repo.model.gameBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
* <h1>Score Handler class</h1>
* <p>
* This class is responsible for extracting data from the permanent highscore list file
* and updating it. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/

public class ScoreHandler   {
	static File file = new File("src/main/resources/score.txt");//file path
	ArrayList<Integer> highScores = new ArrayList<>();//array list to store highscores from file
	ArrayList<String> names = new ArrayList<String>();//array list to store names from file

	/**
	 * constructor for the score handler.
	 * makes sure that there is a score file.
	 * if not it creates one
	 * also stores the names and scores in array lists.
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
		 names = getNames();

	}

	

	/**
	 * This method is responsible for checking if the player's 
	 * score is higher than any highscore in the list.
	 * if it is true then update() method is called to update the list of scores
	 * in the file.
	 * @param points the current score of the player
	 * @param name the username of the player
	 * @return boolean if the player has a higher score or not
	 */
	
	public boolean isHigher(int points,String name) {
		for (int i=0; i<names.size();i++) {
			if(points>highScores.get(i)) {
				if(name == "") {
					names.set(i, "Player1");
				}else {
					names.set(i, name);
				}
				highScores.set(i, points);
				update();
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * This method is responsible for reading the highest score from a the
	 * list of highscores stored in a file. 
	 * @return highScor int int value of highscore stored in a file
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
	/**
	 * This method is responsible for getting the highscores from the highscore list file
	 * @return ArrayList<Integer> list og highscores.
	 */

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
	/**
	 * theis method is responsible for getting the names from the highscore list file.
	 * @return ArrayList<String> names list.
	 */
	
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
	
	
	

}
