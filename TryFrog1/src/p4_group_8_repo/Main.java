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
		
		background.add(new End(7,60));
		background.add(new End(97,60));
		background.add(new End(97 + 42 + 50,60));
		background.add(new End(97 + (42 + 50)*2 ,60));
		background.add(new End(97 + (42 + 50)*3,60));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 0, 110, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 200,110, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 400, 110, 0.75));
		
		background.add(new Turtle(0, 143, -1, 60, 50,2));
		background.add(new WetTurtle(150,143, -1, 60, 50,2));
		background.add(new Turtle(250, 143, -1, 60, 50,2));
		background.add(new Turtle(350,143, -1, 60, 50,2));
		background.add(new WetTurtle(450, 143, -1, 60, 50,2)); 
		
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 180, 0,193, 2));
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 180, 350, 193, 2));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 85, 0, 230, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 85, 200,230, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 85, 400, 230, 0.75));
		
		background.add(new Turtle(0, 260, -1.25, 90, 50,1));
		background.add(new WetTurtle(120,260, -1.25, 90, 50,1));
		background.add(new Turtle(240, 260, -1.25, 90, 50,1));
		background.add(new Turtle(360,260, -1.25, 90, 50,1));
		background.add(new WetTurtle(480, 260, -1.25, 90, 50,1));

		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0, 345, -1, 90, 100));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2"+"left.png", 300, 345, -1, 140, 100));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/redcar.png", 0, 370, 4, 40, 40));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0, 415, -1, 40, 40));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 150, 415, -1, 40, 40));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 300, 415, -1, 40, 40));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 100, 455, 1, 140, 100));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1right.png", 400, 455, 1, 90, 100));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 495, 1, 40, 40));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 150, 495, 1, 40, 40));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 300, 495, 1, 40, 40));
		
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
