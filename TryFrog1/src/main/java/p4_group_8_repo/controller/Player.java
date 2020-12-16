package p4_group_8_repo.controller;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import p4_group_8_repo.model.enemies.Car;
import p4_group_8_repo.model.enemies.CrocodileHead;
import p4_group_8_repo.model.enemies.Snake;
import p4_group_8_repo.model.gameBase.Actor;
import p4_group_8_repo.model.gameBase.Floatable;
import p4_group_8_repo.model.gameBase.Life;
import p4_group_8_repo.model.scoreBoosters.Swamp;
import p4_group_8_repo.model.scoreBoosters.Fly;
import p4_group_8_repo.model.scoreBoosters.LadyFrog;


/**
* <h1>Player Class</h1>
* <p>
* The class is responsible for all the aspects
* of an objects of type player in the game scen
* it extends Actor class.
* @see p4_group_8_repo.model.gameBase.Actor Actor
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
*/


public class Player extends Actor {
	/*images of player*/
	Image imgUP;
	Image imgLEFT;
	Image imgDOWN;
	Image imgRIGHT;
	Image imgUPJ;
	Image imgLEFTJ;
	Image imgDOWNJ;
	Image imgRIGHTJ;
	Image imglUP;
	Image imglLEFT;
	Image imglDOWN;
	Image imglRIGHT;
	Image imglUPJ;
	Image imglLEFTJ;
	Image imglDOWNJ;
	Image imglRIGHTJ;
	String s;
    boolean win = false;// to store if player reached a swamp
	int lives = 4;// number of lives initialized to 4
	private int points = 0;//current score, initialized to 0
	int swamps = 0;// number of swamps reached, initialized to 0
	private boolean second = false;//boolean for switching between jumping and non-jumping images in key listeners
	boolean fly = false;//if ate a fly or not
	boolean noMove = false;//if is able to move or not
	boolean attached = false;//if attached to lady frog
	double movement = 18.5;//vertical movement
	double movementX = 18.5;//horizontal movement
	int imgSize = 28;//player image size
	boolean changeScore = false;//if score is changing
	double w = 530;//highest point reached horizontally
    private boolean dead = false;//if dead or not
    MediaPlayer media;//media player to play sounds
    Media sound;// a sound
    List<Image> carD = new ArrayList<>();//list of images for car death
    List<Image> waterD = new ArrayList<>();//list of images for water death


    /**
     * Constructor for the player object
     * which sets up the images, and creates a keylistener fro the player
     */

	public Player() {
		/*setting up image and initial location on pane*/
		setImage(new Image("/img/froggerUp.png", imgSize, imgSize, true, true));
		setX(195);
		setY(530);
		/*adding all images for movement*/
		imglUP = new Image("/img/lUp.png", imgSize, imgSize, true, true);
		imglLEFT = new Image("/img/lLeft.png", imgSize, imgSize, true, true);
		imglDOWN = new Image("/img/lDown.png", imgSize, imgSize, true, true);
		imglRIGHT = new Image("/img/lRight.png", imgSize, imgSize, true, true);
		imglUPJ = new Image("/img/lUpJump.png", imgSize, imgSize, true, true);
		imglLEFTJ = new Image("/img/lLeftJump.png", imgSize, imgSize, true, true);
		imglDOWNJ = new Image("/img/lDownJump.png", imgSize, imgSize, true, true);
		imglRIGHTJ = new Image("/img/lRightJump.png", imgSize, imgSize, true, true);
		imgUP = new Image("/img/froggerUp.png", imgSize, imgSize, true, true);
		imgLEFT = new Image("/img/froggerLeft.png", imgSize, imgSize, true, true);
		imgDOWN = new Image("/img/froggerDown.png", imgSize, imgSize, true, true);
		imgRIGHT = new Image("/img/froggerRight.png", imgSize, imgSize, true, true);
		imgUPJ = new Image("/img/froggerUpJump.png", imgSize, imgSize, true, true);
		imgLEFTJ = new Image("/img/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgDOWNJ = new Image("/img/froggerDownJump.png", imgSize, imgSize, true, true);
		imgRIGHTJ = new Image("/img/froggerRightJump.png", imgSize, imgSize, true, true);
		/*KeyListener to change images and move player when any of the arrow keys are pressed*/
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {//if boolean no move is true don't do anything 
					
				}
				else { 
				if (second) {//if second is true move according to key pressed and set moving images
					if (event.getCode() == KeyCode.UP) {	  
		                move(0, -movement);
		                setChangeScore(false);
		                if(attached)//if attached to lady frog set lady frog image
		                	setImage(imglUP);
		                else
		                    setImage(imgUP);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {	            	
		            	 move(-movementX, 0);
		            	 if(attached)
			                	setImage(imglLEFT);
			                else
			                    setImage(imgLEFT);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {	            	
		            	 move(0, movement);
		            	 if(attached)
			                	setImage(imglDOWN);
			                else
			                    setImage(imgDOWN);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {	            	
		            	 move(movementX, 0);
		            	 if(attached)
			                	setImage(imglRIGHT);
			                else
			                    setImage(imgRIGHT);
		            	 second = false;
		            } 
				}
				else if (event.getCode() == KeyCode.UP) {//if second is false set jumping images first, move and then set second to true          	
	                move(0, -movement);
	                if(attached)
	                	setImage(imglUPJ);
	                else
	                    setImage(imgUPJ);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 if(attached)
		                	setImage(imglLEFTJ);
		                else
		                    setImage(imgLEFTJ);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 if(attached)
		                	setImage(imglDOWNJ);
		                else
		                    setImage(imgDOWNJ);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 if(attached)
		                	setImage(imglRIGHTJ);
		                else
		                    setImage(imgRIGHTJ);
	            	 second = true;
	            }
	        }
			}
		});	

		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.UP) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                if(attached)
	                	setImage(imglUP);
	                else
	                    setImage(imgUP);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 if(attached)
		                	setImage(imglLEFT);
		                else
		                    setImage(imgLEFT);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 if(attached)
		                	setImage(imglDOWN);
		                else
		                    setImage(imgDOWN);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 if(attached)
		                	setImage(imglRIGHT);
		                else
		                    setImage(imgRIGHT);
	            	 second = false;
	            }
	        }
			}
			
		});
		/*add car death images*/
		carD.add(new Image("/img/cardeath1.png", imgSize,imgSize , true, true));
	    carD.add(new Image("/img/cardeath2.png", imgSize,imgSize , true, true));
	    carD.add(new Image("/img/cardeath3.png", imgSize,imgSize , true, true));
	    /*add water death images*/
	    waterD.add(new Image("/img/waterdeath1.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath2.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath3.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath4.png", imgSize,imgSize , true, true));

	}

	/**
	 * Act now method which instantiates all the player properties.
	 * @see p4_group_8_repo.model.gameBase.Actor#act(long) Acting method
	 * @see p4_group_8_repo.model.gameBase.Actor#getIntersectingObjects(Class) Intersection lists
	 * @param now, which is a long that stores current time frame in nanoseconds.
	 */
	@Override
	public void act(long now) {
		HandleOutOfBounds();
		/*check if player is in winning state*/
		if(win) {
			playMedia("win");//play winning sound
			points+=50;//increase points by 50
			if(attached || fly) {//if player is attached to lady frog or ate a fly reward with 200 points
				points+=200;
				attached = false;
				fly =false;
			}
			changeScore=true;
			w=530;	
			getIntersectingObjects(Swamp.class).get(0).setOccupied();//set the swamp to occupied
			swamps++;
			Restore();//restore player to defaults
			win = false;
			}
		/*checking intersections*/
		if (getIntersectingObjects(Car.class).size() >= 1 && !dead) {//if intersected a car call handle death with car death images
			HandleDeath(carD);
		}
		/*if intersected a snake or crocodile head call HandleDeath method*/
		if ((getIntersectingObjects(Snake.class).size() >= 1 || getIntersectingObjects(CrocodileHead.class).size() >= 1)  && !dead) {
			HandleDeath(waterD);
		}
        /*if intersected a lady frog set attached to true*/
		if (getIntersectingObjects(LadyFrog.class).size() >= 1) {
    	     setImage(imglUP);
			 attached  =true;
			 }
		/*handeling intersection with floatables*/
		if(getIntersectingObjects(Floatable.class).size() >= 1) {
			/*if its not a crocodile mouth or a diving turtle move with the same speed else die*/
			if ((this.intersects(getIntersectingObjects(Floatable.class).get(0).getMouth())||getIntersectingObjects(Floatable.class).get(0).isSunk() )&& !dead) {
				HandleDeath(waterD);
			}else {
				move(getIntersectingObjects(Floatable.class).get(0).getSpeed(),0);
			}
			/*handle intersection with swamps*/
		}else if (getIntersectingObjects(Swamp.class).size() >= 1) {
			if (getIntersectingObjects(Swamp.class).get(0).isActivated()) {//if swamp is occupied then minus points, lives and restore
                subtractlives();
                Restore();
			}else {
				win = true;//else win

			}
		}else if (getIntersectingObjects(Fly.class).size() >= 1) {//if intersected a fly win and set fly to true
			fly = true;
			win = true;
			/*if not intersected with floatables or swamps then call handleDeath method*/
		} else if(getY()<280  && !dead) {
			HandleDeath(waterD);
		} 
			

	}
	
	/**
	 * method to set boundaries of player
	 */
	
	private void HandleOutOfBounds() {
		// TODO Auto-generated method stub
		if ( getY()>530) {
			setY(530);	
		}	
		if (getY()>280 && getX()<0) {	
			move(movement, 0);	
		}	
		if (getY()>280 && getX()>400) {
			move(-movement, 0);	
		}
		if(getY()<280 && (getX()<0 || getX()>400) && !dead) {//if on water and touched edges then call HandleDeath method	
			HandleDeath(waterD);
		}
		
	}

	/**
	 * This method plays sounds when player intersects with certain objects
	 * @param s, which is a string that specifies the type of sound
	 */
	public void playMedia(String s) {
		String musicFile = "src/main/resources/"+s+".mp3";   
		sound = new Media(new File(musicFile).toURI().toString());
		media = new MediaPlayer(sound);
	    media.play();
		
	}

	/**
	 * HandleDeath method is responsible for handling death scene of player.
	 * @param images, which is a list of images to show when player dies according to type of death.
	 */
	public void HandleDeath(List<Image> images) {
			playMedia("dead");//play dead sound
		    dead = true;
			noMove = true;// set no move to true
			/*create transition animation of pictures*/
			Transition animation = new Transition() {
			    {
			        setCycleDuration(Duration.millis(1000)); // total time for animation
			    }

			    @Override
			    protected void interpolate(double fraction) {
			        int index = (int) (fraction*(images.size()-1));//show images of list every fraction of time
			        setImage(images.get(index)); 
			    }
			};
			animation.setOnFinished(e -> {Restore(); subtractlives();});//when animation is finished restore player defaults and subtract a life
			animation.play();
			
				
	}
	/**
	 * This method subtracts a life and points of player
	 */
	public void subtractlives() {
		getWorld().remove(getWorld().getObjects(Life.class).get(lives-1));//remove on life image from Game scene
		if (points>50) {
			points-=50;
			changeScore=true;
	}
		lives--;
		dead = false;	

	}
	/**
	 * This method determines if the player finished a round
	 * @return boolean 
	 */
	public boolean getNewRound() {
		if(swamps == 5) {//if five swamps are reached then restorte swamps and return true
			swamps = 0;
			return true;
		}
		return false;
	} 
	
	/**
	 * This method restores player's defaults
	 */
	
	public void Restore() {
		setImage(imgUP);//set initial image
		setX(195);//set initial y position
		setY(530);//set initial x position
		if(attached)//if attached to lady frog, unattach
			attached = false;
		noMove = false;
	}

 
	/**
	 * getter method for number of swamps 
	 * @return number of swamps reached
	 */
	public int getSwamps() {
		return swamps;
	}
	/**
	 * This method determines if player ran out of lives 
	 * @return boolean
	 */

	public boolean gameover() {
		return lives<=0;
		
	}
	
	/**
	 * getter method for number of points 
	 * @return points which is an int number of points 
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * This method determines if the score of the player is changing
	 * and resets it to false
	 * @return boolean which is changescore of player
	 */
	public boolean changeScore() {
		if (isChangeScore()) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	/**
	 * getter method for number of lives 
	 * @return lives which is an int number of lives 
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * getter method for attached
	 * @return boolean if lady frog is attached or not
	 */
	public boolean isAttached() {
		return attached;
	}

	/**
	 * setter method of noMove
	 * @param noMove
	 */
	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	/**
	 * getter method for changeScore 
	 * @return changeScore
	 */
	public boolean isChangeScore() {
		return changeScore;
	}
	
	/**
	 * setter method of changeScore
	 * @param changeScore
	 */
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

	/**
	 * getter method for win 
	 * @return win
	 */
	public boolean isWin() {
		return win;
	}
	
	/**
	 * setter of points
	 * @param points current points of player
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * setter for number of swaps
	 * @param end
	 */
	public void setSwamps(int end) {
		this.swamps = end;
	}

	/**
	 * getter method for dead 
	 * @return dead if player is dead or not
	 */
	public boolean isDead() {
		return dead;
	}
	/**
	 * getter for waterD
	 * @return waterD list of water death images
	 */
	public List<Image> getWaterD() {
		return waterD;
	}

}
