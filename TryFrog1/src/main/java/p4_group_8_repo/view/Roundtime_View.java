package p4_group_8_repo.view;

import javafx.scene.control.ProgressBar;
/**
* <h1>Round Time View class</h1>
* <p>
* This class is responsible for showing the view of
* the round timer which is a progress bar that updates every second. 
* it extends ProgressBar. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see javafx.scene.control.ProgressBar ProgressBar
*/
public class Roundtime_View extends ProgressBar {
	/**
	 * constructor of the roundtime_view
	 */
	public Roundtime_View() {
		setProgress(1);//it is set to 1 initially
		setPrefWidth(242);
	    setTranslateX(120);
	    setTranslateY(580);
	    setStyle("-fx-accent: #21de00; -fx-rotate: 180;");//set color and rotate on x axis
	}

}
