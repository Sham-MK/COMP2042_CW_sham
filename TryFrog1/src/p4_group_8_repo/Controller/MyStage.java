package p4_group_8_repo.Controller;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import p4_group_8_repo.Model.BackgroundImage;
import p4_group_8_repo.Model.Crocodile;
import p4_group_8_repo.Model.CrocodileHead;
import p4_group_8_repo.Model.End;
import p4_group_8_repo.Model.Fly;
import p4_group_8_repo.Model.HighscoreHandler;
import p4_group_8_repo.Model.LadyFrog;
import p4_group_8_repo.Model.LevelCleared;
import p4_group_8_repo.Model.Levels;
import p4_group_8_repo.Model.Life;
import p4_group_8_repo.Model.Log;
import p4_group_8_repo.Model.Car;
import p4_group_8_repo.Model.Roundtime_Model;
import p4_group_8_repo.Model.Score;
import p4_group_8_repo.Model.Snake;
import p4_group_8_repo.Model.Turtle;
import p4_group_8_repo.Model.WetTurtle;
import p4_group_8_repo.Model.World;
import p4_group_8_repo.View.Roundtime_View;
import p4_group_8_repo.View.SceneManager;

public class MyStage extends World{
	SceneManager manager = new SceneManager();
	MediaPlayer mediaPlayer;
    AnimationTimer timerc;
    Roundtime_View timerView = new Roundtime_View();
    Roundtime_Model timerModel = new Roundtime_Model();
    Score score = new Score();
	Player animal;
    int i;
	int round = 1;
    
    Roundtime_Controller timerController = new Roundtime_Controller(timerModel, timerView);

	
	public MyStage() {
        BackgroundImage froggerback = new BackgroundImage();

		add(froggerback);
		add(score);
		score.setNumber(new HighscoreHandler().read(), "highscore");
		
		add(timerView);
		
        
		int shiftend = 90;
		for(int i=0; i<5; i++) {
			add(new End(6+(shiftend*i)));			
		}
				
		add(new Fly());
		add(new CrocodileHead());
		
		for(i = 0; i<3; i++) {
			add(new Log("file:src/p4_group_8_repo/View/img/log2.png", 0+(200*i), 125, 2));
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
			add(new Log("file:src/p4_group_8_repo/View/img/logs.png", 0+(350*i), 198, 1.5));			
		}
		
		for(i = 0; i <3; i++) {
			add(new Log("file:src/p4_group_8_repo/View/img/log3.png", 0+(200*i), 235, 0.75));			
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
    		add(new Car("file:src/p4_group_8_repo/View/img/truck1"+"left.png", 0+(260*i), 340, -1));
        }
		
		add(new Car("file:src/p4_group_8_repo/View/img/car1right.png", 0, 375, 4));
		
        for(i = 0; i<3; i++) {
    		add(new Car("file:src/p4_group_8_repo/View/img/car1Left.png", 0+(180*i), 412, -0.75));
        }

        for(i = 0; i<2; i++) {
    		add(new Car("file:src/p4_group_8_repo/View/img/truck2Right.png", 0+(300*i), 450, 1));
        }
        
        for(i = 0; i<3; i++) {
    		add(new Car("file:src/p4_group_8_repo/View/img/car1left.png", 0+(180*i), 490, -0.75));
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
            	
            	if(animal.gameover()) {
            		stopGame();
            		manager.showGameOver((Stage)animal.getScene().getWindow(),animal.getPoints());

            	}
            	if (getNewRound()) {
            		 for(i = 0; i<5; i++) {
	                    	getObjects(End.class).get(i).unsetEnd();
	                    }
	                    if(round<=10) {
	                    	add(new LevelCleared());
		                	setNewLevel(round);
	                		GenerateNewLevel(round);
	                    }
            		}
            	if(animal.isDead() || animal.isWin()) {
            		timerController.reset();
            	} 
            	if(timerController.getProgress()<=0.0333 && !animal.isWin()) {
    				animal.HandleDeath(now,"waterdeath");
            	}
            }
        };
    }
	
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/View/Frogger Main Song Theme (loop).mp3";   
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
	    	    add(new Car("file:src/p4_group_8_repo/View/img/car1right.png", getObjects(Car.class).get(2).getX()-200, 375, 4));
	    	    remove(getObjects(Log.class).get(3));
	    	    getObjects(Crocodile.class).get(0).setShow();
	    	    remove(getObjects(Log.class).get(1));
	    	    getObjects(Turtle.class).get(0).setSpeed(-2);
	    	    getObjects(Turtle.class).get(1).setSpeed(-2);
	    		getObjects(WetTurtle.class).get(0).setSpeed(-2);
	    		getObjects(WetTurtle.class).get(1).setSpeed(-2);
	    	    if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
	    	    }
	    	    break;
	    	  case 3:
	    		 getObjects(Car.class).get(2).setSpeed(2);
	    		 getObjects(Car.class).get(11).setSpeed(2);
	     	     add(new Car("file:src/p4_group_8_repo/View/img/car1right.png", getObjects(Car.class).get(11).getX()-200, 375, 2));
	             add(new Snake("snakew", 200,235,0.75));
	             add(new Snake("snake", 200,280,1));
	             if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
		    	    }
	             break;
	    	  case 4:
	    		 getObjects(Car.class).get(2).setSpeed(2);
	     		 getObjects(Car.class).get(11).setSpeed(2);
	     		 getObjects(Car.class).get(12).setSpeed(2);
	             add(new LadyFrog(getObjects(Log.class).get(2).getX(),getObjects(Log.class).get(2).getY()));
	     		 break;
	    	  case 5:
	    		getObjects(Log.class).get(3).setSpeed(2);
		    	getObjects(Log.class).get(4).setSpeed(2);
		    	getObjects(Log.class).get(5).setSpeed(2);
		    	getObjects(Snake.class).get(0).setSpeed(2);
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
	    		 getObjects(Car.class).get(0).setSpeed(-1.5);
	    		 getObjects(Car.class).get(1).setSpeed(-1.5);
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
	    		 getObjects(Car.class).get(0).setSpeed(-1.25);
	    		 getObjects(Car.class).get(1).setSpeed(-1.25);
		    	 remove(getObjects(Car.class).get(6));
	     		 add(new Snake("snake",getObjects(Car.class).get(7).getX()-300, 430, 1));
	     		if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY())); 	
	    	    }

	    		 break;
	    	  case 10:
	    		  getObjects(Car.class).get(8).setSpeed(-1.25);
	    		  getObjects(Car.class).get(9).setSpeed(-1.25);
	    		  getObjects(Car.class).get(10).setSpeed(-1.25);
	    		  if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(4).getX(),getObjects(Log.class).get(4).getY())); 	
		    	    }
	     		 break;
	    	  default:
	    	    // code block
	    	}
	    	
	    }
	 
	 public boolean getNewRound() {
			if(animal.getEnd()==5) {
				animal.setEnd(0);
				round += 1;
				return true;
			}
			return false;
		} 
		
	 
	 
	 
	 public void startGame() {
		    start();
			playMusic();
	    	GameCheck();
	        timerc.start();
	    }
	 
	 public void stopGame() {
		    animal.setNoMove(true);
	 		stop();
	 		stopMusic();
	 		timerController.stopRoundTimer();
    		timerc.stop();
	 }
	 
	 


}
