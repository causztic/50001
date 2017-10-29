package week5.cohort;

import java.util.ArrayList;
import java.util.Observable;
/**
 * Created by yaojie on 12/10/17.
 */

public class StockGrabber extends Observable{

    private String update;

    public StockGrabber(){
        this.update = "";
    }

    public String getUpdate() {
        return update;
    }


    public void stockUpdate(String update){
        this.update = update;
        setChanged(); // set the Observable has changed.
        notifyObservers(); // notify observers of change.
    }
}
