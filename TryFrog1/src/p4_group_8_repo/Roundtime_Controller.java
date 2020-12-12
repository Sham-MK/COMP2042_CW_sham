package p4_group_8_repo;

public class Roundtime_Controller {
	private Roundtime_Model model;
	private Roundtime_View view;

	public Roundtime_Controller(Roundtime_Model model, Roundtime_View view){
	      this.model = model;
	      this.view = view;
	   }
	
	public void setTimer() {
		model.setBar(view);
	}
	public void UpdateTimer() {
		model.UpdateTimer();
	}
	
	public double getProgress() {
		return model.progress();
	}
	
	public void reset() {
		model.resetProgress();
	}
	
	public void stopRoundTimer() {
		model.stoptimer();
	}
	
}
