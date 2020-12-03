package p4_group_8_repo;

import java.util.Timer;
import java.util.TimerTask;
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
    Timer timer1 = new Timer();
	
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
		
		
		background.add(new End(6));
		background.add(new End(96));
		background.add(new End(96 + 40 + 50));
		background.add(new End(96 + (40 + 50)*2));
		background.add(new End(96 + (40 + 50)*3));
		
		background.add(new Fly());
		
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 0, 125, 1.5));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 200,125, 1.5));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 400, 125, 1.5));
		
		background.add(new Crocodile(background.getObjects(Log.class).get(1).getX(), 125, 1.5));
		
		background.add(new Turtle(0, 150, -1.5, 60, 50,2));
		background.add(new WetTurtle(120,150, -1.5, 60, 50,2));
		background.add(new Turtle(240, 150, -1.5, 60, 50,2));
		background.add(new Turtle(360,150, -1.5, 60, 50,2));
		background.add(new WetTurtle(480, 150, -1.5, 60, 50,2)); 
		
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 0,198, 1.5));
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 350, 198, 1.5));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 0, 235, 0.5));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 200,235, 0.5));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 400, 235, 0.5));
		
		background.add(new Crocodile(background.getObjects(Log.class).get(6).getX(), 235, 0.5));
	
		background.add(new Turtle(0, 262, -1.5, 90, 50,3));
		background.add(new WetTurtle(120,262, -1.5, 90, 50,3));
		background.add(new Turtle(240, 262, -1.5, 90, 50,3));
		background.add(new Turtle(360,262, -1.5, 90, 50,3));
		background.add(new WetTurtle(480, 262, -1.5, 90, 50,3));
		
        background.add(new LadyFrog(background.getObjects(Log.class).get(7).getX(),background.getObjects(Log.class).get(7).getY()));


		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2"+"left.png", 0, 340, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 260, 340, -1));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 375, 4));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0, 412, -0.75));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 120, 412, -0.75));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 240, 412, -0.75));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 100, 450, 1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1right.png", 400, 450, 1));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 0, 490, -0.75));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 150, 490, -0.75));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 300, 490, -0.75));
		
		background.add(new Life(0));
		background.add(new Life(25));
		background.add(new Life(50));
		background.add(new Life(75));
		
		
		int shift =0;
		for(int i=0; i<9; i++) {
			background.add(new Level(361-shift));
			shift+=15;
		}

		

		
		
		
		animal = new Frogger();
		background.add(animal);

        startTimer();
		background.start();
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false);
		setNumber(new Highscore().read(), "highscore");
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), "score");
            	}
            	if(animal.gameover()) {
            		background.stopMusic();
            		background.stop();
            		animal.setNoMove(true);
            		background.add(new LevelCleared(2));
            		timer1.cancel();

            	}
            	if (animal.getNewLevel()) {
                	background.add(new LevelCleared(1));
            		setNewLevel(animal.level);
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

    public void stop() {
        timer.stop();
        timer1.cancel(); 
    }
    
    public void setNumber(int n, String type) {
    	switch(type) {
    	  case "highscore":
    		  int shift = 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  background.add(new Digit(k, 30, 240 - shift, 25));
    	    		  shift+=30;
    	    		}
    	    break;
    	  case "score":
    		  int shift1= 0;
    	    	while (n > 0) {
    	    		  int d = n / 10;
    	    		  int k = n - d * 10;
    	    		  n = d;
    	    		  background.add(new Digit(k, 30, 90 - shift1, 25));
    	    		  shift1+=30;
    	    		}
    	    break;
    	  default:
    	    // code block
    	}
    }

 
    private void startTimer() {
        timer1.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
            	double p =background.getObjects(ProgressBar.class).get(0).getProgress();
            	if(p>0.0333) {
            	    background.getObjects(ProgressBar.class).get(0).setProgress(p-0.0333);
            	}else {
            		background.getObjects(ProgressBar.class).get(0).setProgress(1);
            	}
            	
            }
        }, 1500, 1000);
        
    }
    
    public void setNewLevel(int level) {
    	background.getObjects(Level.class).get(level-2).setImage(null);
    	animal.changeScore=true;
    	animal.points+=10*background.getObjects(ProgressBar.class).get(0).getProgress()*30;
    	for(int i =0; i<5;i++) {
        	background.getObjects(End.class).get(i).unsetEnd();
    	}
    	switch(level) {
    	  case 2:
    	    background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", background.getObjects(Obstacle.class).get(2).getX()+90, 375, 4));
    	    background.getObjects(Log.class).get(3).setImage(null);
    	    background.getObjects(Crocodile.class).get(0).setShow();
    	    background.getObjects(Log.class).get(1).setImage(null);
    	    background.getObjects(LadyFrog.class).get(0).setImage(null);
            background.add(new LadyFrog(background.getObjects(Log.class).get(0).getX(),background.getObjects(Log.class).get(0).getY()));
    	    break;
    	  case 3:
    		 background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", background.getObjects(Log.class).get(5).getX()+100, 412, -0.75));
    		 background.getObjects(Obstacle.class).get(2).setSpeed(2);
    		 background.getObjects(Obstacle.class).get(11).setSpeed(2);
     	     background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", background.getObjects(Obstacle.class).get(11).getX()+90, 375, 2));
             background.add(new Snake("snakew", 100,190,1));
             background.add(new Snake("snake", 0,280,1));
     	     background.getObjects(LadyFrog.class).get(0).setImage(null);
             background.add(new LadyFrog(background.getObjects(Log.class).get(1).getX(),background.getObjects(Log.class).get(1).getY()));
             break;
    	  case 4:
    		 background.getObjects(Obstacle.class).get(2).setSpeed(3);
     		 background.getObjects(Obstacle.class).get(11).setSpeed(3);
     		 background.getObjects(Obstacle.class).get(13).setSpeed(3);
     		 background.getObjects(Turtle.class).get(3).dontShow();
     	     background.getObjects(LadyFrog.class).get(0).setImage(null);
             background.add(new LadyFrog(background.getObjects(Log.class).get(2).getX(),background.getObjects(Log.class).get(2).getY()));
     		 break;
    	  case 5:
    		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", background.getObjects(Obstacle.class).get(9).getX()+150, 490, -0.75));
    	    background.getObjects(LadyFrog.class).get(0).setImage(null);
            background.add(new LadyFrog(background.getObjects(Log.class).get(3).getX(),background.getObjects(Log.class).get(3).getY()));
    	    break;
    	  case 6:
    		 background.getObjects(Turtle.class).get(5).dontShow();
    		 background.getObjects(Turtle.class).get(2).dontShow();
     	    background.getObjects(LadyFrog.class).get(0).setImage(null);
    	     background.add(new LadyFrog(background.getObjects(Log.class).get(4).getX(),background.getObjects(Log.class).get(4).getY()));

     	    break;

    	  case 7:
    		 background.getObjects(Obstacle.class).get(0).setSpeed(-2);
    		 background.getObjects(Obstacle.class).get(1).setSpeed(-2);
     	     background.getObjects(LadyFrog.class).get(0).setImage(null);
    	     background.add(new LadyFrog(background.getObjects(Log.class).get(5).getX(),background.getObjects(Log.class).get(5).getY()));
     	    break;

    	  case 8:
      	     background.getObjects(Crocodile.class).get(1).setShow();
      	     background.getObjects(Log.class).get(6).setImage(null);
     	     background.getObjects(LadyFrog.class).get(0).setImage(null);
             background.add(new LadyFrog(background.getObjects(Log.class).get(0).getX(),background.getObjects(Log.class).get(0).getY()));
     	    break;

    	  case 9:
     		 background.add(new Snake("snake",background.getObjects(Obstacle.class).get(6).getX(), 430, 1));
    		 background.getObjects(Obstacle.class).get(6).setImage(null);
     	     background.getObjects(LadyFrog.class).get(0).setImage(null);
    	     background.add(new LadyFrog(background.getObjects(Log.class).get(3).getX(),background.getObjects(Log.class).get(3).getY()));

    		 break;
    	  case 10:
    		  background.getObjects(Obstacle.class).get(8).setSpeed(-1.25);
    		  background.getObjects(Obstacle.class).get(9).setSpeed(-1.25);
    		  background.getObjects(Obstacle.class).get(10).setSpeed(-1.25);
    		  background.getObjects(Obstacle.class).get(14).setSpeed(-1.25);
      	      background.getObjects(LadyFrog.class).get(0).setImage(null);
    	      background.add(new LadyFrog(background.getObjects(Log.class).get(4).getX(),background.getObjects(Log.class).get(4).getY()));

     		 break;
    	  default:
    	    // code block
    	}
    	
    }
    
}
