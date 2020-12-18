package p4_group_8_repo.controller;

import p4_group_8_repo.model.gameAttributes.Roundtime_Model;
import p4_group_8_repo.view.Roundtime_View;
/**
* <h1>Controller for the Round timer</h1>
* <p>
* The controller is responsible for connecting round timer view and model
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/

public class Roundtime_Controller {
	private Roundtime_Model model;
	private Roundtime_View view;

	/**
	 * Controller constructor which sets model and view
	 * @param model type Roundtime_Model
	 * @param view type Roundtime_View
	 */
	public Roundtime_Controller(Roundtime_Model model, Roundtime_View view){
	      this.model = model;
	      this.view = view;
	   }
	
	/**
	 * calls model method on view to connect model with view
	 */
	public void setTimer() {
		model.setBar(view);
	}
	/**
	 * calls model method on view to update timer every second
	 */
	public void UpdateTimer() {
		model.UpdateTimer();
	}
	/**
	 * getter for timer progress
	 * @return timer progress
	 */
	public double getProgress() {
		return model.progress();
	}
	/**
	 * call model method on view to reset the timer
	 */
	
	public void reset() {
		model.resetProgress();
	}
	
	/**
	 * call model method to stop the timer
	 */
	
	public void stopRoundTimer() {
		model.stoptimer();
	}
	
}
