package p4_group_8_repo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.model.enemies.Car;
import p4_group_8_repo.model.gameAttributes.Player;
import p4_group_8_repo.view.GameStage;


class PlayerTest {

	private JFXPanel panel = new JFXPanel();
	private Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player();
		player.setSwamps(5);
		player.setPoints(750);
	}


	@Test
	void testGetNewRound() {
		assertTrue("new round should return true if 5 ends are reached", player.getNewRound());
	}

	@Test
	void testGetEnd() {
		assertEquals("should return 5", 5, player.getSwamps());
	}

	@Test
	void testGameover() {
		assertFalse("lives initialized to 4 so should return false", player.gameover());
	}

	@Test
	void testGetPoints() {
		assertEquals("should return 750", 750, player.getPoints());
	}

	@Test
	void testGetLives() {
		assertEquals("lives initialized to 4 so should return 4",4, player.getLives());

	}




}
