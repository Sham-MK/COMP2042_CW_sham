package p4_group_8_repo.Model;

import java.util.Timer;
import java.util.TimerTask;


import javafx.scene.control.ProgressBar;

public class Roundtime_Model extends ProgressBar {
    Timer timerr = new Timer();
    
    ProgressBar bar;
    
    public void setBar(ProgressBar bar) {
		this.bar = bar;
	}

	double progress;

	
	public void UpdateTimer() {
        timerr.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
            	if(bar.getProgress()>0.0333) {
            	    bar.setProgress(bar.getProgress()-0.0333);
            	}else {
            		bar.setProgress(1);
            	}
            	
            }
        }, 1000, 1000);
        
    }
	
	public double progress() {
			return bar.getProgress();
	}
	
	public void resetProgress() {
		bar.setProgress(1);
	}
	
	public void stoptimer() {
		timerr.cancel();
	}
	

}
