package p4_group_8_repo.gameStage;

import java.io.File;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import p4_group_8_repo.Player;
import p4_group_8_repo.Roundtime_Controller;
import p4_group_8_repo.Roundtime_Model;
import p4_group_8_repo.Roundtime_View;
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
import p4_group_8_repo.levelsAndScore.Levels;
import p4_group_8_repo.levelsAndScore.LevelCleared;
import p4_group_8_repo.levelsAndScore.Life;
import p4_group_8_repo.main.GameOverController;
import p4_group_8_repo.scoreBoosters.Fly;
import p4_group_8_repo.scoreBoosters.LadyFrog;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
    AnimationTimer timerc;
    Roundtime_View timerView = new Roundtime_View();
    Roundtime_Model timerModel = new Roundtime_Model();
	Player animal;
    int i;
    
    Roundtime_Controller timerController = new Roundtime_Controller(timerModel, timerView);

	
	public MyStage() {
		
        BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/img/iKogsKW.png");

		add(froggerback);
		
		add(timerView);
		
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
				add(new WetTurtle(0+(150*i),155, -1.25, 60, 50,2));			
			}
			else {
				add(new Turtle(0+(150*i), 155, -1.25, 60, 50,2));
			}
		}

		for(i = 0; i <2; i++) {
			add(new Log("file:src/p4_group_8_repo/img/logs.png", 0+(350*i), 198, 1.5));			
		}
		
		for(i = 0; i <3; i++) {
			add(new Log("file:src/p4_group_8_repo/img/log3.png", 0+(200*i), 235, 0.75));			
		}
		
		add(new Crocodile(getObjects(Log.class).get(3).getX(), 198, 1.5));
		
		for(i = 1; i<5; i++) {
			if (i%2==0) {
				add(new WetTurtle(0+(140*i),262, -1.75, 90, 50,3));			
			}
			else {
				add(new Turtle(0+(140*i), 262, -1.75, 90, 50,3));
			}
		}
		
        add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY()));
        
        for(i = 0; i<2; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0+(260*i), 340, -1));
        }
		
		add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 375, 4));
		
        for(i = 0; i<3; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0+(180*i), 412, -0.75));
        }

        for(i = 0; i<2; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 0+(300*i), 450, 1));
        }
        
        for(i = 0; i<3; i++) {
    		add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 0+(180*i), 490, -0.75));
        }

		for(i=0; i<4; i++) {
			add(new Life(0+(25*i)));
		}

		
		int shift =15;
		for(int i=0; i<9; i++) {
			add(new Levels(361-(shift*i)));
		}
		
		animal = new Player();
		add(animal);
		
		timerController.setTimer();
    	timerController.UpdateTimer();
    	
		startGame();


	}
	
	
	private void add(Roundtime_View timerView2) {
		// TODO Auto-generated method stub
		getChildren().add(timerView2);
		
	}

	public void GameCheck() {
        timerc = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), "score");
            	}
            	if(animal.gameover()) {
            		animal.setNoMove(true);
            		stopGame();
            		stopMusic();
            		timerController.stopRoundTimer();
            		timerc.stop();

            		try {
            	           FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOverView.fxml"));
            	           AnchorPane root = loader.load();
            	   
            	           //The following both lines are the only addition we need to pass the arguments
            	           GameOverController controller2 = loader.getController();
            	           controller2.setText(animal.getPoints());
            	   
            	           Stage stage = (Stage)(animal).getScene().getWindow(); 
            	           stage.setScene(new Scene(root));
            	           stage.show();
            	   
            	       } catch (IOException e) {
            	           e.printStackTrace();
            	       }
            		


            	}
            	if (animal.getNewRound()) {
            		 for(i = 0; i<5; i++) {
	                    	getObjects(End.class).get(i).unsetEnd();
	                    }
	                    if(animal.getLevel()<=10) {
	                    	add(new LevelCleared());
		                	setNewLevel(animal.getLevel());
	                		GenerateNewLevel(animal.getLevel());
	                    }
            		}
            	if(animal.isWaterDeath() || animal.isCarDeath() || animal.isWin()) {
            		timerController.reset();
            	} 
            	if(timerController.getProgress()<=0.0333 && !animal.isWin()) {
            		animal.setWaterDeath(true);
            	}
            }
        };
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

	
	public void setNewLevel(int level) {
		getObjects(Levels.class).get(level-2).setImage(null);
    	getObjects(Player.class).get(0).setChangeScore(true);
    	getObjects(Player.class).get(0).setPoints((int) (getObjects(Player.class).get(0).getPoints() + 10*timerController.getProgress()*30));
		
	}
	
	 public void GenerateNewLevel(int level) {
	    	switch(level) {
	    	  case 2:
	    	    add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", getObjects(Obstacle.class).get(2).getX()-200, 375, 4));
	    	    remove(getObjects(Log.class).get(3));
	    	    getObjects(Crocodile.class).get(0).setShow();
	    	    remove(getObjects(Log.class).get(1));
	    	    if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
	    	    }
	    	    break;
	    	  case 3:
	    		 getObjects(Obstacle.class).get(2).setSpeed(2);
	    		 getObjects(Obstacle.class).get(11).setSpeed(2);
	     	     add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", getObjects(Obstacle.class).get(11).getX()-200, 375, 2));
	             add(new Snake("snakew", 200,235,0.75));
	             add(new Snake("snake", 200,280,1));
	             if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
		    	    }
	             break;
	    	  case 4:
	    		 getObjects(Obstacle.class).get(2).setSpeed(3);
	     		 getObjects(Obstacle.class).get(11).setSpeed(3);
	     		 getObjects(Obstacle.class).get(12).setSpeed(3);
	             add(new LadyFrog(getObjects(Log.class).get(2).getX(),getObjects(Log.class).get(2).getY()));
	     		 break;
	    	  case 5:
		      	getObjects(Crocodile.class).get(1).setShow();
	    	    if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(2).getX(),getObjects(Log.class).get(2).getY())); 	
	    	    }
	    	    break;
	    	  case 6:
		    	 if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
		    	    }
		    	 break;

	    	  case 7:
	    		 getObjects(Obstacle.class).get(0).setSpeed(-1.5);
	    		 getObjects(Obstacle.class).get(1).setSpeed(-1.5);
		    	 if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(5).getX(),getObjects(Log.class).get(5).getY())); 	
		    	    }
		    	 break;

	    	  case 8:
	    		  if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
		    	    }
	    		  break;

	    	  case 9:
	    		 getObjects(Obstacle.class).get(0).setSpeed(-1.25);
	    		 getObjects(Obstacle.class).get(1).setSpeed(-1.25);
		    	 remove(getObjects(Obstacle.class).get(6));
	     		 add(new Snake("snake",getObjects(Obstacle.class).get(7).getX()-300, 430, 1));
	     		if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY())); 	
	    	    }

	    		 break;
	    	  case 10:
	    		  getObjects(Obstacle.class).get(8).setSpeed(-1.25);
	    		  getObjects(Obstacle.class).get(9).setSpeed(-1.25);
	    		  getObjects(Obstacle.class).get(10).setSpeed(-1.25);
	    		  if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(4).getX(),getObjects(Log.class).get(4).getY())); 	
		    	    }
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
	 
	 
	 public void startGame() {
		    start();
			playMusic();
	    	GameCheck();
	        timerc.start();
	    }


}
