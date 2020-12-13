package p4_group_8_repo.controller;



import java.util.ArrayList;
import java.util.List;

import javafx.animation.Transition;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import p4_group_8_repo.model.carriers.Log;
import p4_group_8_repo.model.carriers.Turtle;
import p4_group_8_repo.model.enemies.Car;
import p4_group_8_repo.model.enemies.Crocodile;
import p4_group_8_repo.model.enemies.CrocodileHead;
import p4_group_8_repo.model.enemies.Snake;
import p4_group_8_repo.model.enemies.WetTurtle;
import p4_group_8_repo.model.gameBase.Actor;
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
    List<Image> carD = new ArrayList<>();
    List<Image> waterD = new ArrayList<>();



	public Player() {
		
		

		setImage(new Image("file:src/p4_group_8_repo/View/img/froggerUp.png", imgSize, imgSize, true, true));
		setX(195);
		setY(530);
		imglUP = new Image("file:src/p4_group_8_repo/View/img/lUp.png", imgSize, imgSize, true, true);
		imglLEFT = new Image("file:src/p4_group_8_repo/View/img/lLeft.png", imgSize, imgSize, true, true);
		imglDOWN = new Image("file:src/p4_group_8_repo/View/img/lDown.png", imgSize, imgSize, true, true);
		imglRIGHT = new Image("file:src/p4_group_8_repo/View/img/lRight.png", imgSize, imgSize, true, true);
		imglUPJ = new Image("file:src/p4_group_8_repo/View/img/lUpJump.png", imgSize, imgSize, true, true);
		imglLEFTJ = new Image("file:src/p4_group_8_repo/View/img/lLeftJump.png", imgSize, imgSize, true, true);
		imglDOWNJ = new Image("file:src/p4_group_8_repo/View/img/lDownJump.png", imgSize, imgSize, true, true);
		imglRIGHTJ = new Image("file:src/p4_group_8_repo/View/img/lRightJump.png", imgSize, imgSize, true, true);
		imgUP = new Image("file:src/p4_group_8_repo/View/img/froggerUp.png", imgSize, imgSize, true, true);
		imgLEFT = new Image("file:src/p4_group_8_repo/View/img/froggerLeft.png", imgSize, imgSize, true, true);
		imgDOWN = new Image("file:src/p4_group_8_repo/View/img/froggerDown.png", imgSize, imgSize, true, true);
		imgRIGHT = new Image("file:src/p4_group_8_repo/View/img/froggerRight.png", imgSize, imgSize, true, true);
		imgUPJ = new Image("file:src/p4_group_8_repo/View/img/froggerUpJump.png", imgSize, imgSize, true, true);
		imgLEFTJ = new Image("file:src/p4_group_8_repo/View/img/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgDOWNJ = new Image("file:src/p4_group_8_repo/View/img/froggerDownJump.png", imgSize, imgSize, true, true);
		imgRIGHTJ = new Image("file:src/p4_group_8_repo/View/img/froggerRightJump.png", imgSize, imgSize, true, true);
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
		carD.add(new Image("file:src/p4_group_8_repo/View/img/cardeath1.png", imgSize,imgSize , true, true));
	    carD.add(new Image("file:src/p4_group_8_repo/View/img/cardeath2.png", imgSize,imgSize , true, true));
	    carD.add(new Image("file:src/p4_group_8_repo/View/img/cardeath3.png", imgSize,imgSize , true, true));

	    waterD.add(new Image("file:src/p4_group_8_repo/View/img/waterdeath1.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("file:src/p4_group_8_repo/View/img/waterdeath2.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("file:src/p4_group_8_repo/View/img/waterdeath3.png", imgSize,imgSize , true, true));
	    waterD.add(new Image("file:src/p4_group_8_repo/View/img/waterdeath4.png", imgSize,imgSize , true, true));

	}
	
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>530) {
			setY(530);
		}	
		
		if(getY()<280 && (getX()<0 || getX()>400) && !dead) {
			HandleDeath(now,waterD);
		}
		
		if(win) {
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
			HandleDeath(now,carD);
		}

		if (getIntersectingObjects(LadyFrog.class).size() >= 1) {
    	     setImage(imglUP);
			 attached  =true;
			 }
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !dead) 
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);	
		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !dead ) {
			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
		}
		
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1 && !dead) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				HandleDeath(now,waterD);
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
			}
		}
		
		else if (getIntersectingObjects(Crocodile.class).size() >= 1 && !dead) {
			if (this.intersects(getIntersectingObjects(Crocodile.class).get(0).getMouth())) {
				HandleDeath(now,waterD);
			} else {
				move(getIntersectingObjects(Crocodile.class).get(0).getSpeed(),0);
			}
		}
		
		else if (getIntersectingObjects(Snake.class).size() >= 1) {
			HandleDeath(now,waterD);
		}
		
		else if (getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			HandleDeath(now,waterD);
		}
		
		else if (getIntersectingObjects(Fly.class).size() >= 1) {
			fly = true;
			win = true;
		}
		
		else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			win = true;
		}
		
		else if (getY()<280 && !dead){
			HandleDeath(now,waterD);
		}
	}
	
	public void HandleDeath(long now, List<Image> images) {
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
		if (points>50) {
			points-=50;
			changeScore=true;
	}
		getWorld().remove(getWorld().getObjects(Life.class).get(lives-1));
		lives--;
		dead = false;	

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
