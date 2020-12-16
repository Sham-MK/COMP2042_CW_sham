package p4_group_8_repo.model.gameBase;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
* <h1>Actor class</h1>
* <p>
* This class is responsible for setting every actor on the pane of game scene.
* it extends ImageView. 
* </p>
* @author  Sham Maatouk
* @version 1.0
* @since   2020
* @see javafx.scene.image.ImageView ImageView
*/
public abstract class Actor extends ImageView{
	

	/**
	 * This method is responsible for moving the actors
	 * @param dx amount to be moved horizontally
	 * @param dy amount to be moved vertically
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * getter method of World.
     * @return World the pane on which the actor node exists.
     */
    public World getWorld() {
        return (World) getParent();
    }   

    /**
     * width getter
     * @return width of actor
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * height getter
     * @return height of actor
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    /**
     * This method is responsible for returning a list of intersected actors
     * @param <A> type  Actor
     * @param cls class actor belongs to
     * @return array of Actors
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    /**
     * This method is responsible making actors move and act through an animation timer
     * @param now current time frame in nanoseconds
     * @see p4_group_8_repo.model.gameBase.World#createTimer() act timer.
     */

    public abstract void act(long now);

}
