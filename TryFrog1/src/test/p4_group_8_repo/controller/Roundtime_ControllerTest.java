package p4_group_8_repo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.model.gameAttributes.Roundtime_Model;
import p4_group_8_repo.view.Roundtime_View;

class Roundtime_ControllerTest {

	private JFXPanel panel = new JFXPanel();
	Roundtime_Controller controller;
	Roundtime_Model model;
	Roundtime_View view;

	@BeforeEach
	void setUp() throws Exception {
		view = new Roundtime_View();
		model = new Roundtime_Model();
		controller = new Roundtime_Controller(model,view);
		controller.setTimer();
		view.setProgress(0.5);
	}



	@Test
	void testReset() {
		controller.reset();
		assertEquals(1,controller.getProgress());
	}
	
	@Test
	void testGetProgress() {
		assertEquals(0.5,controller.getProgress());
	}
}
