package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


public class FroggerApp extends Application {

	AnimationTimer timer;
    int delay = 6000;
	MyStage background;
	Frogger animal;
    Timeline timeline = new Timeline();
    IntegerProperty timeSeconds = new SimpleIntegerProperty((delay) * 100);
    Group root = new Group();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	    background = new MyStage(); 
	    Scene scene  = new Scene(background, 424 , 600);
		background.add(new ProgressBar());
		animal = new Frogger();
		background.add(animal);
        background.startTimer();
		background.start();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		background.setNumber(new Highscore().read(), "highscore");
		primaryStage.show();
		start();  
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		background.setNumber(animal.getPoints(), "score");
            	}
            	if(animal.gameover()) {
            		background.add(new LevelCleared(2));
            		background.stopMusic();
            		background.stop();
            		animal.setNoMove(true);
            		background.timer.cancel();
            		timer.stop();

            	}
            	if (animal.getNewLevel()) {
                	background.add(new LevelCleared(1));
            		background.setNewLevel(animal.level);
            		}
            	double p =background.getObjects(ProgressBar.class).get(0).getProgress();
            	if(animal.waterDeath || animal.carDeath || animal.win) {
            		background.getObjects(ProgressBar.class).get(0).setProgress(1);
            	} 
            	if(p<=0.0333 && !animal.win) {
            		animal.waterDeath = true;
            	}
            }
        };
    }
	
	
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    
    
   
    
}
