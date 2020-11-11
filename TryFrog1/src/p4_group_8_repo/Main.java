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
	Animal animal;
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
		
		background.add(new Digit(0, 30, 60, 28));
		background.add(new Digit(0, 30, 180, 28));

		
		background.add(new End(8,73));
		background.add(new End(98,73));
		background.add(new End(98 + 40 + 50,73));
		background.add(new End(98 + (40 + 50)*2 ,73));
		background.add(new End(98 + (40 + 50)*3,73));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 0, 125, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 200,125, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log2.png", 120, 400, 125, 0.75));
		
		background.add(new Turtle(0, 150, -1, 65, 50,2));
		background.add(new WetTurtle(100,150, -1, 65, 50,2));
		background.add(new Turtle(200, 150, -1, 65, 50,2));
		background.add(new Turtle(300,150, -1, 65, 50,2));
		background.add(new WetTurtle(400, 150, -1, 65, 50,2));
		
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 200, 0, 190, 2));
		background.add(new Log("file:src/p4_group_8_repo/img/logs.png", 200, 350, 190, 2));
		
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 90, 0, 230, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 90, 200,230, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/img/log3.png", 90, 400, 230, 0.75));
		
		background.add(new Turtle(0, 260, -1.25, 90, 50,1));
		background.add(new WetTurtle(120,260, -1.25, 90, 50,1));
		background.add(new Turtle(240, 260, -1.25, 90, 50,1));
		background.add(new Turtle(360,260, -1.25, 90, 50,1));
		background.add(new WetTurtle(480, 260, -1.25, 90, 50,1));

		animal = new Animal("file:src/p4_group_8_repo/img/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 0, 340, -1, 100, 100));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck1"+"left.png", 300, 340, -1, 100, 100));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/redcar.png", 0, 370, 4, 50, 50));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 0, 420, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 150, 420, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1Left.png", 300, 420, -1, 50, 50));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 100, 470, 1, 150, 100));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/truck2Right.png", 400, 470, 1, 150, 100));
		
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 0, 510, 1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 150, 510, 1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/img/car1right.png", 300, 510, 1, 50, 50));


		background.start();
		primaryStage.setScene(scene);
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
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
