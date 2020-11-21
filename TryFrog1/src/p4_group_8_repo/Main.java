package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Frogger animal;
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
		
		background.add(new End(7,68));
		background.add(new End(96,68));
		background.add(new End(96 + 40 + 50, 68));
		background.add(new End(96 + (40 + 50)*2 ,68));
		background.add(new End(96 + (40 + 50)*3,68));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 0, 125, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 200,125, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 400, 125, 0.75));
		
		background.add(new Turtle(0, 150, -1, 60, 50,2));
		background.add(new WetTurtle(150,150, -1, 60, 50,2));
		background.add(new Turtle(250, 150, -1, 60, 50,2));
		background.add(new Turtle(350,150, -1, 60, 50,2));
		background.add(new WetTurtle(450, 150, -1, 60, 50,2)); 
		
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 0,198, 2));
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 350, 198, 2));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 0, 235, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 200,235, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 400, 235, 0.75));
		
		background.add(new Turtle(0, 262, -1.25, 90, 50,3));
		background.add(new WetTurtle(120,262, -1.25, 90, 50,3));
		background.add(new Turtle(240, 262, -1.25, 90, 50,3));
		background.add(new Turtle(360,262, -1.25, 90, 50,3));
		background.add(new WetTurtle(480, 262, -1.25, 90, 50,3));

		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0, 340, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2"+"left.png", 300, 340, -1));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 375, 3));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0, 410, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 150, 410, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 300, 410, -1));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 100, 450, 1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1right.png", 400, 450, 1));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 0, 490, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 150, 490, -1));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1left.png", 300, 490, -1));
		
		animal = new Frogger();
		background.add(animal);


		background.start();
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
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
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 60 - shift, 25));
    		  shift+=30;
    		}
    }
}
