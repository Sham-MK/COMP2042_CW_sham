package p4_group_8_repo.model.gameAttributes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreHandlerTest {

	ScoreHandler score;
	File file;
	Scanner scanner;
	int number;
	BufferedReader reader;
	
	@BeforeEach
	void setUp() throws Exception {
		score = new ScoreHandler();
        java.net.URL url = this.getClass().getResource("/score.txt");
        file = new File(url.getFile());
		reader = new BufferedReader(new FileReader(file));

	}

	@Test
    public void tesFileExists() {
        assertTrue(file.exists());
    }

	@Test
	void testReadHighest() throws IOException {	
        String line = reader.readLine();
        int n = 0;
        while (line != null)              
        {
                int number = Integer.parseInt(line.split("-")[1]);   
                if (number > n)                      
                { 
                	n = number;
                }

            line = reader.readLine();
        }
        reader.close();

	    assertEquals(n, score.readHighest());
	}


}
