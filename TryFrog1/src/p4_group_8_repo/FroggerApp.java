package p4_group_8_repo;



import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
	    BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/img/iKogsKW.png");
	    double w = froggerback.getWidth();
	    double h = froggerback.getHeight();
	    Scene scene  = new Scene(background, w , h);
		background.add(froggerback);
		background.add(new ProgressBar());
		background.add(new End(6,68));
		background.add(new End(95,68));
		background.add(new End(95 + 40 + 50, 68));
		background.add(new End(95 + (40 + 50)*2 ,68));
		background.add(new End(95 + (40 + 50)*3,68));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 0, 125, 1));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 200,125, 1));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 400, 125, 1));
		
		background.add(new Turtle(0, 150, -1.5, 60, 50,2));
		background.add(new WetTurtle(150,150, -1.5, 60, 50,2));
		background.add(new Turtle(250, 150, -1.5, 60, 50,2));
		background.add(new Turtle(350,150, -1.5, 60, 50,2));
		background.add(new WetTurtle(450, 150, -1.5, 60, 50,2)); 
		
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 0,198, 1.75));
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 350, 198, 1.75));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 0, 235, 2));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 200,235, 2));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 400, 235, 2));
		
		background.add(new Turtle(0, 262, -2, 90, 50,3));
		background.add(new WetTurtle(120,262, -2, 90, 50,3));
		background.add(new Turtle(240, 262, -2, 90, 50,3));
		background.add(new Turtle(360,262, -2, 90, 50,3));
		background.add(new WetTurtle(480, 262, -2, 90, 50,3));

		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0, 340, -1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2"+"left.png", 300, 340, -1.5));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 375, 4.5));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0, 412, -1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 150, 412, -1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 300, 412, -1.5));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 100, 450, 1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1right.png", 400, 450, 1.5));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 0, 490, -1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 150, 490, -1.5));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 300, 490, -1.5));
		
		background.add(new Life("life", 0));
		background.add(new Life("life", 25));
		background.add(new Life("life", 50));
		background.add(new Life("life", 75));

		
		
		
		animal = new Frogger();
		background.add(animal);

        startTimer();
		background.start();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		setNumber(new Highscore().read(), "highscore");
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(animal.getLives()>0) {
            		setLives(animal.getLives());
            	}
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), "score");
            	}
            	if(animal.gameover()) {
            		background.stopMusic();
            		background.stop();
            		animal.setNoMove(true);
            		background.add(new GameState());
            	}
            	if (animal.getStop()) {
            		background.stopMusic();
            		background.stop();
            		stop();
            		animal.setNoMove(true);
            		new Highscore().printscore(animal);
            	}
            	double p =background.getObjects(ProgressBar.class).get(0).getProgress();
            	if(animal.waterDeath || animal.carDeath || animal.win) {
            		background.getObjects(ProgressBar.class).get(0).setProgress(1);
            	} 
            	if(p<=0.0625 && !animal.win) {
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

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n, String type) {
    	switch(type) {
    	  case "highscore":
    		  int shift = 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  background.add(new Digit(k, 30, 210 - shift, 25));
    	    		  shift+=30;
    	    		}
    	    break;
    	  case "score":
    		  int shift1= 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  background.add(new Digit(k, 30, 60 - shift1, 25));
    	    		  shift1+=30;
    	    		}
    	    break;
    	  default:
    	    // code block
    	}
    }
    public void setLives(int l) {
    		  for(int i=3; i>l-1; i--) {
    			  background.getObjects(Life.class).get(i).setDead();
    		  }	    	
    }
    

 
    private void startTimer() {
        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
            	double p =background.getObjects(ProgressBar.class).get(0).getProgress();
            	if(p>0.0625) {
            	    background.getObjects(ProgressBar.class).get(0).setProgress(p-0.0625);
            	}else {
            		background.getObjects(ProgressBar.class).get(0).setProgress(1);
            	}
            	
            }
        }, 1000, 1000);
        
    }
    
}
