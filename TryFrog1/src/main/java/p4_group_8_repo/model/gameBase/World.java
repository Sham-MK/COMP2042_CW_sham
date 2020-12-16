package p4_group_8_repo.model.gameBase;
import java.util.ArrayList;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
* <h1>World class</h1>
* <p>
* This class is responsible for setting the main pane of the game scene
* and adding listeners to all the actors act methods
* it extends Pane. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see javafx.scene.layout.Pane Pane
*/
public abstract class World extends Pane {
    private AnimationTimer timer; //animation timer for invoking Actors' act method

    /**
     * Constructor of world.
     * it sets a listener that invokes methods for moving actors
     * on key pressed and released.
     */
    
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }
    /**
     * Animation timer that invokes actors act methods when started
     * @see p4_group_8_repo.model.gameBase.Actor#act(long)
     */

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * method for starting the animation timer
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * method for stopping the animation timer
     */
    public void stop() {
        timer.stop();
    }
    /**
     * this method is responsible for adding actors on the game scene pane.
     * @param actor, a node of type Actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }
    

    /**
     * this method is responsible for removing actors from the game scene pane
     * @param actor, a node of type Actor
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * This method is responsible for getting a list of specific class of nodes
     * from the game scene pane
     * @param <A> list of Objects 
     * @param cls class to which node belongs to
     * @return array of nodes
     */
    public <A>List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    

}
