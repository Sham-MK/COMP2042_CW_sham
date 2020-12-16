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
import p4_group_8_repo.model.carriers.Log;
import p4_group_8_repo.model.carriers.Turtle;
import p4_group_8_repo.model.enemies.Car;
import p4_group_8_repo.model.enemies.Crocodile;
import p4_group_8_repo.model.enemies.CrocodileHead;
import p4_group_8_repo.model.enemies.Snake;
import p4_group_8_repo.model.enemies.WetTurtle;
import p4_group_8_repo.model.gameBase.Actor;
import p4_group_8_repo.model.gameBase.Floatable;
import p4_group_8_repo.model.gameBase.Life;
import p4_group_8_repo.model.scoreBoosters.End;
import p4_group_8_repo.model.scoreBoosters.Fly;
import p4_group_8_repo.model.scoreBoosters.LadyFrog;


public class Player extends Actor {
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
    boolean win = false;
	int lives = 4;
	private int points = 0;
	int end = 0;
	private boolean second = false;
	boolean fly = false;
	boolean noMove = false;
	boolean attached = false;
	double movement = 18.5;
	double movementX = 18.5;
	int imgSize = 28;
	boolean carDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int D = 0;
	double w = 530;
    private boolean dead = false;
    MediaPlayer media;
    Media sound;
    List<Image> carD = new ArrayList<>();
    List<Image> waterD = new ArrayList<>();



	public Player() {
		
		setImage(new Image("/img/froggerUp.png", imgSize, imgSize, true, true));
		setX(195);
		setY(530);
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
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) { 
					
				}
				else { 
				if (second) {
					if (event.getCode() == KeyCode.UP) {	  
		                move(0, -movement);
		                setChangeScore(false);
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
				else if (event.getCode() == KeyCode.UP) {	            	
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
		carD.add(new Image("/img/cardeath1.png", imgSize,imgSize , true, true));
	    carD.add(new Image("/img/cardeath2.png", imgSize,imgSize , true, true));
	    carD.add(new Image("/img/cardeath3.png", imgSize,imgSize , true, true));

	    waterD.add(new Image("/img/waterdeath1.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath2.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath3.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("/img/waterdeath4.png", imgSize,imgSize , true, true));

	}
	
	
	@Override
	public void act(long now) {
		HandleOutOfBounds();
		
		if(win) {
			playMedia("win");
			points+=50;
			if(attached || fly) {
				points+=200;
				attached = false;
				fly =false;
			}
			changeScore=true;
			w=530;	
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			Restore();
			win = false;
			}
		
		if (getIntersectingObjects(Car.class).size() >= 1 && !dead) {
			HandleDeath(carD);
		}
		if ((getIntersectingObjects(Snake.class).size() >= 1 || getIntersectingObjects(CrocodileHead.class).size() >= 1)  && !dead) {
			HandleDeath(waterD);
		}

		if (getIntersectingObjects(LadyFrog.class).size() >= 1) {
    	     setImage(imglUP);
			 attached  =true;
			 }
		if(getIntersectingObjects(Floatable.class).size() >= 1) {
			if (this.intersects(getIntersectingObjects(Floatable.class).get(0).getMouth())||getIntersectingObjects(Floatable.class).get(0).isSunk() && !dead) {
				HandleDeath(waterD);
			}else {
				move(getIntersectingObjects(Floatable.class).get(0).getSpeed(),0);
			}
		}else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			win = true;
		}else if (getIntersectingObjects(Fly.class).size() >= 1) {
			fly = true;
			win = true;
		} else if(getY()<280  && !dead) {
			HandleDeath(waterD);
		} 
			

	}
	
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
		
		if(getY()<280 && (getX()<0 || getX()>400) && !dead) {
			HandleDeath(waterD);
		}
		
	}

	public void playMedia(String s) {
		String musicFile = "src/main/resources/"+s+".mp3";   
		sound = new Media(new File(musicFile).toURI().toString());
		media = new MediaPlayer(sound);
	    media.play();
		
	}

	public void HandleDeath(List<Image> images) {
			playMedia("dead");
		    dead = true;
			noMove = true;
			Transition animation = new Transition() {
			    {
			        setCycleDuration(Duration.millis(1000)); // total time for animation
			    }

			    @Override
			    protected void interpolate(double fraction) {
			        int index = (int) (fraction*(images.size()-1));
			        setImage(images.get(index)); 
			    }
			};
			animation.setOnFinished(e -> {Restore(); subtractlives();});
			animation.play();
			
				
	}
	public void subtractlives() {
		getWorld().remove(getWorld().getObjects(Life.class).get(lives-1));
		if (points>50) {
			points-=50;
			changeScore=true;
	}
		lives--;
		dead = false;	

	}
	
	public boolean getNewRound() {
		if(end == 5) {
			end = 0;
			return true;
		}
		return false;
	} 
	
	public void Restore() {
		setImage(imgUP);
		setX(195);
		setY(530);
		if(attached)
			attached = false;
		noMove = false;
	}

 
	public int getEnd() {
		return end;
	}

	public boolean gameover() {
		return lives<=0;
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (isChangeScore()) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	public int getLives() {
		return lives;
	}
	
	public boolean isAttached() {
		return attached;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public boolean isChangeScore() {
		return changeScore;
	}

	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}



	public boolean isWin() {
		return win;
	}
	

	public void setPoints(int points) {
		this.points = points;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isDead() {
		return dead;
	}
	public List<Image> getWaterD() {
		return waterD;
	}

}
