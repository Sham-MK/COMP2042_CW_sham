package p4_group_8_repo.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.model.carriers.Log;

class LogTest {

	private JFXPanel panel = new JFXPanel();
	Log log;
	@BeforeEach
	void setUp() throws Exception {
		log = new Log("/img/logs.png", 0, 198, 2);
	}

	@Test
	void imageInvalidTest() {	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			log = new Log("not an image link", 0, 0, 0);
		 });
	}
	
	@Test
	void getSpeedTest() {
		log.setSpeed(6);
		assertEquals(6,log.getSpeed());
	}
	
}
