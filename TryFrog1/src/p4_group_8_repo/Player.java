package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.carriers.Log;
import p4_group_8_repo.carriers.Turtle;
import p4_group_8_repo.carriers.WetTurtle;
import p4_group_8_repo.enemies.Crocodile;
import p4_group_8_repo.enemies.CrocodileHead;
import p4_group_8_repo.enemies.Obstacle;
import p4_group_8_repo.enemies.Snake;
import p4_group_8_repo.gameStage.End;
import p4_group_8_repo.levelsAndScore.Life;
import p4_group_8_repo.scoreBoosters.Fly;
import p4_group_8_repo.scoreBoosters.LadyFrog;


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
	int level = 1;
	public int points = 0;
	int end = 0;
	private boolean second = false;
	boolean fly = false;
	boolean noMove = false;
	boolean attached = false;
	double movement = 18.5;
	double movementX = 18.5;
	int imgSize = 28;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int D = 0;
	double w = 600;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Player() {

		setImage(new Image("file:src/p4_group_8_repo/img/froggerUp.png", imgSize, imgSize, true, true));
		setX(195);
		setY(530);
		imglUP = new Image("file:src/p4_group_8_repo/img/lUp.png", imgSize, imgSize, true, true);
		imglLEFT = new Image("file:src/p4_group_8_repo/img/lLeft.png", imgSize, imgSize, true, true);
		imglDOWN = new Image("file:src/p4_group_8_repo/img/lDown.png", imgSize, imgSize, true, true);
		imglRIGHT = new Image("file:src/p4_group_8_repo/img/lRight.png", imgSize, imgSize, true, true);
		imglUPJ = new Image("file:src/p4_group_8_repo/img/lUpJump.png", imgSize, imgSize, true, true);
		imglLEFTJ = new Image("file:src/p4_group_8_repo/img/lLeftJump.png", imgSize, imgSize, true, true);
		imglDOWNJ = new Image("file:src/p4_group_8_repo/img/lDownJump.png", imgSize, imgSize, true, true);
		imglRIGHTJ = new Image("file:src/p4_group_8_repo/img/lRightJump.png", imgSize, imgSize, true, true);
		imgUP = new Image("file:src/p4_group_8_repo/img/froggerUp.png", imgSize, imgSize, true, true);
		imgLEFT = new Image("file:src/p4_group_8_repo/img/froggerLeft.png", imgSize, imgSize, true, true);
		imgDOWN = new Image("file:src/p4_group_8_repo/img/froggerDown.png", imgSize, imgSize, true, true);
		imgRIGHT = new Image("file:src/p4_group_8_repo/img/froggerRight.png", imgSize, imgSize, true, true);
		imgUPJ = new Image("file:src/p4_group_8_repo/img/froggerUpJump.png", imgSize, imgSize, true, true);
		imgLEFTJ = new Image("file:src/p4_group_8_repo/img/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgDOWNJ = new Image("file:src/p4_group_8_repo/img/froggerDownJump.png", imgSize, imgSize, true, true);
		imgRIGHTJ = new Image("file:src/p4_group_8_repo/img/froggerRightJump.png", imgSize, imgSize, true, true);
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
						setChangeScore(true);
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
	}
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>530) {
			setY(530);
		}
		if (getY()>280 && getX()<0) {
			move(movement, 0);
		}
		if (getY()>280 && getX()>400) {
			move(-movement, 0);
		}
			
		if (isWaterDeath() || isCarDeath()) {
			noMove = true;
			if (isWaterDeath()) {
				 s = "waterdeath";
			}else {
				 s = "cardeath";
			}
			if ((now)% 11 == 0) {
				D++;
			}
			if (D==1) {
				setImage(new Image("file:src/p4_group_8_repo/img/"+s+"1.png", imgSize,imgSize , true, true));
			}
			if (D==2) {
				setImage(new Image("file:src/p4_group_8_repo/img/"+s+"2.png", imgSize,imgSize , true, true));
			}
			if (D==3) {
				setImage(new Image("file:src/p4_group_8_repo/img/"+s+"3.png", imgSize,imgSize , true, true));
			}
			if (D == 4) {
				setImage(new Image("file:src/p4_group_8_repo/img/"+s+"4.png", imgSize,imgSize , true, true));
			}
			if (D == 5) {
				getWorld().getObjects(Life.class).get(lives-1).setDead();
				lives--;
				if(attached)
					attached = false;
				setX(195);
				setY(530);
				setWaterDeath(false);
				setCarDeath(false);
				D = 0;
				setImage(new Image("file:src/p4_group_8_repo/img/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					setChangeScore(true);
				}
			}
			
		}
	    
		
		
		if(getY()<280 && (getX()<0 || getX()>400)) {
			setWaterDeath(true);
		}
		if(isWin()) {
			points+=50;
			if(attached)
				points+=200;
				attached = false;
			if(fly) {
				points+=200;
			}
			setChangeScore(true);
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setImage(new Image("file:src/p4_group_8_repo/img/froggerUp.png", imgSize, imgSize, true, true));
			setX(195);
			setY(530);
			win = false;
			fly =false;
			}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}

		if (getIntersectingObjects(LadyFrog.class).size() >= 1) 
			attached  =true;
		if (getIntersectingObjects(Log.class).size() >= 1) 
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 ) {
			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				setWaterDeath(true);
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
			}
		}
		else if (getIntersectingObjects(Crocodile.class).size() >= 1) {
			if (getIntersectingObjects(Crocodile.class).get(0).isJawopen()) {
				setWaterDeath(true);
			} else {
				move(getIntersectingObjects(Crocodile.class).get(0).getSpeed(),0);
			}
		}
		else if (getIntersectingObjects(Snake.class).size() >= 1) {
			setWaterDeath(true);
		}
		else if (getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			setWaterDeath(true);
		}
		else if (getIntersectingObjects(Fly.class).size() >= 1) {
			win = true;
			fly = true;
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			win = true;
		}
		else if (getY()<280){
			setWaterDeath(true);
		}
	}
	private void setCarDeath(boolean b) {
		// TODO Auto-generated method stub
		carDeath = b;
		
	}

	public boolean getNewLevel() {
		if(end==5) {
			if(getLevel()<10) {
				level = getLevel() + 1;
			}
			end = 0;
			return true;
		}
		return false;
	} 
	
	public boolean gameover() {
		return lives<=0;
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (isChangeScore()) {
			setChangeScore(false);
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

	public boolean isWaterDeath() {
		return waterDeath;
	}

	public boolean isCarDeath() {
		return carDeath;
	}

	public boolean isWin() {
		return win;
	}

	public int getLevel() {
		return level;
	}

	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

}
