package p4_group_8_repo.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import p4_group_8_repo.model.gameBase.ScoreHandler;

class ScoreTest {

	ScoreHandler score;
	File file;
	Scanner scanner;
	int number;
	
	@BeforeEach
	void setUp() throws Exception {
		score = new ScoreHandler();
        java.net.URL url = this.getClass().getResource("/score.txt");
        file = new File(url.getFile());
		Scanner scanner = new Scanner(file);

	}

	@Test
    public void tesFileExists() {
        assertTrue(file.exists());
    }

	@Test
	void testRead() throws FileNotFoundException {	
		while(scanner.hasNextInt())
		{
			number = scanner.nextInt();
		}
	    assertEquals(number, score.readHighest());
	}



}
