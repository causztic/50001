package week5.cohort;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaojie on 12/10/17.
 */

public class StockObserver implements Observer{

    private String name;
    private StockGrabber sg;
    private String latestChange;

    public String getLatestChange() {
        return latestChange;
    }

    public StockObserver(StockGrabber sg, String name){
        this.sg = sg;
        this.sg.addObserver(this);
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        sg = (StockGrabber) observable;
        latestChange = sg.getUpdate();
        System.out.printf("%s: Message received: %s \n", name, latestChange);
    }
}
