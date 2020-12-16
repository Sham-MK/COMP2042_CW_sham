package p4_group_8_repo.model.gameBase;

import java.util.Timer;
import java.util.TimerTask;


import javafx.scene.control.ProgressBar;
/**
* <h1>Round Time Model class</h1>
* <p>
* This class is responsible for manipulating the view of
* the round timer which is a progress bar that updates every second. 
* it extends ProgressBar. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see javafx.scene.control.ProgressBar ProgressBar
*/
public class Roundtime_Model extends ProgressBar {
    Timer timerr = new Timer();//timer to update progress bar every second
	double progress;//progress of timer
    ProgressBar bar;//progress bar to be manipulated
    
    /**
     * This method sets the progress bar to be manipulated
     * @param bar bar to be manipulated
     */
    public void setBar(ProgressBar bar) {
		this.bar = bar;
	}

	/**
	 * This method updates the bar every one second
	 * it minuses 0.0333, which means that it will reach 0
	 * after 30 seconds.
	 */
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
	/**
	 * getter for progress
	 * @return progress progress of bar
	 */
	
	public double progress() {
			return bar.getProgress();
	}
	/**
	 * this method resets the bar to 1.
	 */
	public void resetProgress() {
		bar.setProgress(1);
	}
	/**
	 * this method stops the timer.
	 */
	public void stoptimer() {
		timerr.cancel();
	}
 
   
}
