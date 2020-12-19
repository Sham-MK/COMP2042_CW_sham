package p4_group_8_repo.model.enemies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;

class CrocodileTest {

	private JFXPanel panel = new JFXPanel();
	Crocodile crocodile;

	@BeforeEach
	void setUp() throws Exception {
		crocodile = new Crocodile(0, 150, 5);
	}

	@Test
	void testGetSpeed() {
		assertEquals(5,crocodile.getSpeed());
	}


	/*test if mouth position is correct*/
	@Test
	void testGetMouth() {
		crocodile.act(0);
		double crocodileMouthStart = crocodile.getBoundsInLocal().getMaxX()-45;
		double getMouthFunction = crocodile.getMouth().getMinX();
		assertEquals(crocodileMouthStart,getMouthFunction);
	}

}
