package p4_group_8_repo.controller;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import p4_group_8_repo.model.carriers.Log;
import p4_group_8_repo.model.carriers.Turtle;
import p4_group_8_repo.model.enemies.Car;
import p4_group_8_repo.model.enemies.Crocodile;
import p4_group_8_repo.model.enemies.CrocodileHead;
import p4_group_8_repo.model.enemies.Snake;
import p4_group_8_repo.model.enemies.WetTurtle;
import p4_group_8_repo.model.gameBase.BackgroundImage;
import p4_group_8_repo.model.gameBase.Digit;
import p4_group_8_repo.model.gameBase.LevelCleared;
import p4_group_8_repo.model.gameBase.Levels;
import p4_group_8_repo.model.gameBase.Life;
import p4_group_8_repo.model.gameBase.Roundtime_Model;
import p4_group_8_repo.model.gameBase.World;
import p4_group_8_repo.model.scoreBoosters.Swamp;
import p4_group_8_repo.model.scoreBoosters.Fly;
import p4_group_8_repo.model.scoreBoosters.LadyFrog;
import p4_group_8_repo.view.Roundtime_View;
import p4_group_8_repo.view.SceneManager;
/**
* <h1>The Game Scene</h1>
* <p>
* This class extends World and sets the main game scene.
* It adds all the game elements to a Pane
* </p>
* @see p4_group_8_repo.model.gameBase.World World
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/
public class GameStage extends World{
	SceneManager manager = new SceneManager();//scene manager for switching scenes
	private MediaPlayer mediaPlayer;//media player to play music
    AnimationTimer timerc;// timer to check game aspects
    Roundtime_View timerview = new Roundtime_View();//view of the round timer
    Roundtime_Model timerModel = new Roundtime_Model();// model of the round timer
    Digit score = new Digit();// score object to show highscore and current score
	Player 	animal = new Player();// the Frogger main player
    int i;// dummy integer for loops
	int round = 1;// number of rounds, initialised to 1.
    String name;
    Roundtime_Controller timerController = new Roundtime_Controller(timerModel, timerview);

    /**
     * This is the constructor for GameStage.
     * It adds in all the Cars, Floatables, and game elements
     */
    
	
	public GameStage(String username) {
		name = username;
		/*adding background image*/
        BackgroundImage froggerback = new BackgroundImage();
		add(froggerback);
		
		/*adding high score*/
		add(score);
		score.setHighScore();
		
		/*adding the view of the round timer*/
		add(timerview);
		
        /*adding the swamps*/
		int shiftend = 90;
		for(int i=0; i<5; i++) {
			add(new Swamp(6+(shiftend*i)));			
		}
		/*adding the fly and crocodile head that appear on the swamps*/				
		add(new Fly());
		add(new CrocodileHead());
		
		/*adding logs and turtles*/
		for(i = 0; i<3; i++) {
			add(new Log("/img/log2.png", 0+(180*i), 125, 1.5));
		}
				
		for(i = 1; i<5; i++) {
			if (i%2==0) {
				add(new WetTurtle(0+(106*i),155, -2,2));			
			}
			else {
				add(new Turtle(0+(106*i), 155, -2,2));
			}
		}

		for(i = 0; i <2; i++) {
			add(new Log("/img/logs.png", 0+(360*i), 198, 1.5));			
		}
		
		for(i = 0; i <3; i++) {
			add(new Log("/img/log3.png", 0+(180*i), 235, 1));			
		}
		
		
		for(i = 1; i<5; i++) {
			if (i%2==0) {
				add(new WetTurtle(0+(120*i),262, -1.75,3));			
			}
			else {
				add(new Turtle(0+(120*i), 262, -1.75,3));
			}
		}
		/*adding a lady frog on a log*/
        add(new LadyFrog(getObjects(Log.class).get(3).getX(),getObjects(Log.class).get(3).getY()));
        
        /*adding cars and trucks*/
		add(new Car("/img/truck1left.png", 0, 340, -1));
		add(new Car("/img/truck2left.png", 300, 340, -1));
        	
		add(new Car("/img/car1right.png", 0, 375, 4));
		
        for(i = 0; i<3; i++) {
    		add(new Car("/img/car1Left.png", 0+(180*i), 412, -0.75));
        }

		add(new Car("/img/truck1Right.png", 0, 450, 1));
		add(new Car("/img/truck2Right.png", 300, 450, 1));
        
        for(i = 0; i<3; i++) {
    		add(new Car("/img/car1left.png", 0+(180*i), 490, -0.75));
        }

        /*adding player lives*/
		for(i=0; i<animal.getLives(); i++) {
			add(new Life(0+(25*i)));
		}

		/*adding blocks on levels, each will be removed in every new levek*/
		int shift =15;
		for(int i=0; i<9; i++) {
			add(new Levels(361-(shift*i)));
		}
		
		/*adding the player*/
		add(animal);
		
		/*setting up the round timer using the controller*/
		timerController.setTimer();
    	timerController.UpdateTimer();
    	
    	/*method call to all animation timers to start game*/
		startGame();


	}
	/**
	 * This method adds a round timer view on the pane
	 * @param timerview2
	 */
	
	public void add(Roundtime_View timerview2) {
		// TODO Auto-generated method stub
		getChildren().add(timerview2);
		
	}
	
	/**
	 * This is a method which instantiates an animation timer
	 * to check for gameover, new levels, and timer updates.
	 * @see p4_group_8_repo.controller.Player#gameover() Game Over method
	 * @see p4_group_8_repo.controller.Player#getNewRound() New Round Method
	 * @see p4_group_8_repo.controller.Player#isWin()  win getter
	 * @see p4_group_8_repo.controller.Player#isDead() dead getter
	 */

	public void GameCheck() {
        timerc = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {           	
            	if(animal.gameover()) {//check if player died four times
        	 		stopGame();
            		manager.showGameOver((Stage)animal.getScene().getWindow(),animal.getPoints(),round,name);

            	}
            	if (animal.getNewRound()) {//check if player finished a round
            		round++;
            		 for(i = 0; i<5; i++) {
	                    	getObjects(Swamp.class).get(i).unOccupy(); //return all swamps to default
	                    }
	                    if(round<=10) {//set up the new level if levels is less than or equal to 10
	                    	add(new LevelCleared());
		                	setNewLevel(round);
	                		GenerateNewLevel(round);
	                    }
            		}
            	if(animal.isDead() || animal.isWin()) {//reset the round timer if player wins or loses
            		timerController.reset();
            	} 
            	if(timerController.getProgress()<=0.0333 && !animal.isWin()) {//raise death flag if round time is over
    				animal.HandleDeath(animal.getWaterD());
            	}
            }
        };
    }
	

	/**
	 * This method modifies game elements for the new level.
	 * and rewards points to the player, 10 points for every second left.
	 * @param level an integer which is the player's current level.
	 */
	public void setNewLevel(int level) {
		getObjects(Levels.class).get(level-2).setImage(null);//remove block to show new level symbol
		/*reward points to the player, 10 points for every second left*/
    	getObjects(Player.class).get(0).setChangeScore(true);
    	getObjects(Player.class).get(0).setPoints((int) (getObjects(Player.class).get(0).getPoints() + 10*timerController.getProgress()*30));
		
	}
	
	/**
	 * This method generates a new level.
	 * It has a switch case which checks which level the player reached and generates
	 * new objects on the pane accordingly. eg. new crocodiles, snakes, a lady frog
	 * and even change actors speeds
	 * @param level
	 */
	
	 public void GenerateNewLevel(int level) {
	    	switch(level) {
	    	  case 2:
	    	    add(new Car("file:src/main/resources/img/car1right.png", getObjects(Car.class).get(2).getX()-200, 375, 4));
	    	    remove(getObjects(Log.class).get(3));
	    		add(new Crocodile(getObjects(Log.class).get(1).getX(), 115, 1.5));
	    		animal.toFront();
	    	    remove(getObjects(Log.class).get(1));
	    	    if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
	    	    }
	    	    break;
	    	  case 3:
	    		 getObjects(Car.class).get(2).setSpeed(2);
	    		 getObjects(Car.class).get(11).setSpeed(2);
	     	     add(new Car("/img/car1right.png", getObjects(Car.class).get(11).getX()-200, 375, 2));
	             add(new Snake(200,280,1));
	             break;
	    	  case 4:
	    		 add(new Crocodile(getObjects(Log.class).get(4).getX()-360, 198, 1.5));
		    	animal.toFront();
	             if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
		    	    }
	             break;
	    	  case 5:
	    	    if(getObjects(LadyFrog.class).size()>0) {
		    	    remove(getObjects(LadyFrog.class).get(0));
		            add(new LadyFrog(getObjects(Log.class).get(2).getX(),getObjects(Log.class).get(2).getY())); 	
	    	    }
	    	    break;
	    	  case 6:
			     getObjects(Snake.class).get(0).setSpeed(2);
		    	 if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
		    	    }
		    	 break;

	    	  case 7:
	    		  getObjects(Car.class).get(6).setSpeed(2);
		     	  getObjects(Car.class).get(7).setSpeed(2);

		    	 break;

	    	  case 8:
	    		  if(getObjects(LadyFrog.class).size()>0) {
			    	    remove(getObjects(LadyFrog.class).get(0));
			            add(new LadyFrog(getObjects(Log.class).get(0).getX(),getObjects(Log.class).get(0).getY())); 	
		    	    }
	    		  break;

	    	  case 9:
	     		 add(new Snake(getObjects(Car.class).get(6).getX(), 430, 2));
                 remove(getObjects(Car.class).get(6));
	    		 break;
	    	  case 10:
	    		 getObjects(Car.class).get(2).setSpeed(2);
	     		 getObjects(Car.class).get(11).setSpeed(2);
	     		 getObjects(Car.class).get(12).setSpeed(2);

	     		 break;
	    	  default:
	    	    // code block
	    	}
	    	
	    }
	 
	 /**
	  * This method plays music in the game scene.
	  * @param volume which is a double representing the music volume.
	  */
		
	 public void playMusic(double volume) {
			String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";   
			Media sound = new Media(new File(musicFile).toURI().toString());
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.setVolume(volume);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		}
	 /**
	  * method to stop the music
	  */
		
		public void stopMusic() {
			mediaPlayer.stop();
		}
	 /**
	  * This method starts all the animation timers to start the game.
	  */
	 
	 public void startGame() {
		    start(); //act timer in World class
			playMusic(0.1);//play music with volume og 0.1
	    	GameCheck();//start game check animation timer
	        timerc.start();
	    }
	 /**
	  * This method stops the game when called
	  */
	 
	 public void stopGame() {
	 		stopMusic();//stops music
		    animal.setNoMove(true);//stops player from moving
	 		timerController.stopRoundTimer();//stops round timer
    		timerc.stop();
    		getObjects(CrocodileHead.class).get(0).getTimer().cancel();//stops crocodile head timer
    		getObjects(Fly.class).get(0).getTimer().cancel();//stops fly timer
	 		stop();//stop acting
	 }
	 
	 


}
