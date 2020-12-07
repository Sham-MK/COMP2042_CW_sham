package p4_group_8_repo.gameStage;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import p4_group_8_repo.Player;
import p4_group_8_repo.World;
import p4_group_8_repo.carriers.Log;
import p4_group_8_repo.carriers.Turtle;
import p4_group_8_repo.carriers.WetTurtle;
import p4_group_8_repo.enemies.Crocodile;
import p4_group_8_repo.enemies.CrocodileHead;
import p4_group_8_repo.enemies.Obstacle;
import p4_group_8_repo.enemies.Snake;
import p4_group_8_repo.levelsAndScore.Digit;
import p4_group_8_repo.levelsAndScore.Highscore;
import p4_group_8_repo.levelsAndScore.Level;
import p4_group_8_repo.levelsAndScore.Life;
import p4_group_8_repo.scoreBoosters.Fly;
import p4_group_8_repo.scoreBoosters.LadyFrog;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
    public Timer timer = new Timer();
    int i;
    
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
		
        BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/img/iKogsKW.png");

		add(froggerback);
		
		add(new ProgressBar());
		
		setNumber(new Highscore().read(), "highscore");

		int shiftend = 90;
		for(int i=0; i<5; i++) {
			add(new End(6+(shiftend*i)));			
		}
				
		add(new Fly());
		add(new CrocodileHead());
		
		for(i = 0; i<3; i++) {
			add(new Log("file:src/p4_group_8_repo/img/log2.png", 0+(200*i), 125, 2));
		}
		
		add(new Crocodile(getObjects(Log.class).get(1).getX(), 115, 2));
		
		for(i = 1; i<5; i++) {
			if (i%2==0) {
				add(new WetTurtle(0+(130*i),155, -1.25, 60, 50,2));			
			}
			else {
				add(new Turtle(0+(130*i), 155, -1.25, 60, 50,2));
			}
		}

		for(i = 0; i <2; i++) {
			add(new Log("file:src/p4_group_8_repo/img/logs.png", 0+(350*i), 198, 1.25));			
		}
		
		for(i = 0; i <3; i++) {
			add(new Log("file:src/p4_group_8_repo/img/log3.png", 0+(200*i), 235, 0.75));			
		}
		
		add(new Crocodile(getObjects(Log.class).get(6).getX(), 235, 0.5));
		
		for(i = 1; i<5; i++) {
			if (i%2==0) {
				add(new WetTurtle(0+(120*i),262, -1.75, 90, 50,3));			
			}
			else {
				add(new Turtle(0+(120*i), 262, -1.75, 90, 50,3));
			}
		}
		
        add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY()));
        
        for(i = 0; i<2; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0+(260*i), 340, -1));
        }
		
		add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 375, 4));
		
        for(i = 0; i<3; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0+(120*i), 412, -0.75));
        }

        for(i = 0; i<2; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 0+(300*i), 450, 1));
        }
        
        for(i = 0; i<3; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 0+(150*i), 490, -0.75));
        }

		for(i=0; i<4; i++) {
			add(new Life(0+(25*i)));
		}

		
		int shift =15;
		for(int i=0; i<9; i++) {
			add(new Level(361-(shift*i)));
		}

	}
	
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/gameStage/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

	public void add(ProgressBar pb) {
		pb.setProgress(1);
		pb.setPrefWidth(242);
	    pb.setTranslateX(120);
	    pb.setTranslateY(580);
	    pb.setStyle("-fx-accent: #21de00; -fx-rotate: 180;");
        getChildren().add(pb);
    }
	
	public void setNewLevel(int level) {
		getObjects(Level.class).get(level-2).setImage(null);
    	getObjects(Player.class).get(0).setChangeScore(true);
    	getObjects(Player.class).get(0).points+=10*getObjects(ProgressBar.class).get(0).getProgress()*30;
    	for(int i =0; i<5;i++) {
    	getObjects(End.class).get(i).unsetEnd();
	}
		
	}
	
	 public void GenerateNewLevel(int level) {
	    	switch(level) {
	    	  case 2:
	    	    add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", getObjects(Obstacle.class).get(2).getX()+90, 375, 4));
	    	    getObjects(Log.class).get(3).setImage(null);
	    	    getObjects(Crocodile.class).get(0).setShow();
	    	    getObjects(Log.class).get(1).setImage(null);
	    	    getObjects(LadyFrog.class).get(0).setImage(null);
	            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY()));
	    	    break;
	    	  case 3:
	    		 getObjects(Obstacle.class).get(2).setSpeed(2);
	    		 getObjects(Obstacle.class).get(11).setSpeed(2);
	     	     add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", getObjects(Obstacle.class).get(11).getX()+120, 375, 2));
	             add(new Snake("snakew", 100,190,1));
	             add(new Snake("snake", 0,280,1));
	     	     getObjects(LadyFrog.class).get(1).setImage(null);
	             break;
	    	  case 4:
	    		 getObjects(Obstacle.class).get(2).setSpeed(3);
	     		 getObjects(Obstacle.class).get(11).setSpeed(3);
	     		 getObjects(Obstacle.class).get(12).setSpeed(3);
	     		 getObjects(Turtle.class).get(3).dontShow();
	             add(new LadyFrog(getObjects(Log.class).get(2).getX(),getObjects(Log.class).get(2).getY()));
	     		 break;
	    	  case 5:
	    		add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", getObjects(Obstacle.class).get(9).getX()+150, 490, -0.75));
	    	    getObjects(LadyFrog.class).get(2).setImage(null);
	            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY()));
	    	    break;
	    	  case 6:
	    		 getObjects(Turtle.class).get(2).dontShow();
	     	     getObjects(LadyFrog.class).get(3).setImage(null);
	    	     add(new LadyFrog(getObjects(Log.class).get(4).getX(),getObjects(Log.class).get(4).getY()));
	     	    break;

	    	  case 7:
	    		 getObjects(Obstacle.class).get(0).setSpeed(-1.5);
	    		 getObjects(Obstacle.class).get(1).setSpeed(-1.5);
	     	     getObjects(LadyFrog.class).get(4).setImage(null);
	    	     add(new LadyFrog(getObjects(Log.class).get(5).getX(),getObjects(Log.class).get(5).getY()));
	     	    break;

	    	  case 8:
	      	     getObjects(Crocodile.class).get(1).setShow();
	      	     getObjects(Log.class).get(6).setImage(null);
	     	     getObjects(LadyFrog.class).get(5).setImage(null);
	     	    break;

	    	  case 9:
	    		 getObjects(Obstacle.class).get(0).setSpeed(-1.25);
	    		 getObjects(Obstacle.class).get(1).setSpeed(-1.25);
	     		 add(new Snake("snake",getObjects(Obstacle.class).get(6).getX(), 430, 1));
	    		 getObjects(Obstacle.class).get(6).setImage(null);
	    	     add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY()));

	    		 break;
	    	  case 10:
	    		  getObjects(Obstacle.class).get(8).setSpeed(-1.25);
	    		  getObjects(Obstacle.class).get(9).setSpeed(-1.25);
	    		  getObjects(Obstacle.class).get(10).setSpeed(-1.25);
	    		  getObjects(Obstacle.class).get(13).setSpeed(-1.25);
	      	      getObjects(LadyFrog.class).get(6).setImage(null);
	    	      add(new LadyFrog(getObjects(Log.class).get(4).getX(),getObjects(Log.class).get(4).getY()));

	     		 break;
	    	  default:
	    	    // code block
	    	}
	    	
	    }
	 public void setNumber(int n, String type) {
	    	switch(type) {
	    	  case "highscore":
	    		  int shift = 0;
	    	    	while (n > 0) {
	    	    		  int d = n / 10;
	    	    		  int k = n - d * 10;
	    	    		  n = d;
	    	    		  add(new Digit(k, 30, 270 - shift, 25));
	    	    		  shift+=30;
	    	    		}
	    	    break;
	    	  case "score":
	    		  int shift1= 0;
	    	    	while (n > 0) {
	    	    		  int d = n / 10;
	    	    		  int k = n - d * 10;
	    	    		  n = d;
	    	    		  add(new Digit(k, 30, 120 - shift1, 25));
	    	    		  shift1+=30;
	    	    		}
	    	    break;
	    	  default:
	    	    // code block
	    	}
	    }
	 
	 public void startTimer() {
	        timer.scheduleAtFixedRate(new TimerTask() {
	            public void run() { 
	            	double p =getObjects(ProgressBar.class).get(0).getProgress();
	            	if(p>0.0333) {
	            	    getObjects(ProgressBar.class).get(0).setProgress(p-0.0333);
	            	}else {
	            		getObjects(ProgressBar.class).get(0).setProgress(1);
	            	}
	            	
	            }
	        }, 1500, 1000);
	        
	    }


}
