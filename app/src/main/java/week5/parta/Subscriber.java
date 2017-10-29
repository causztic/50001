package week5.parta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaojie on 17/10/17.
 */

public class Subscriber implements Observer{

    private String name;
    private AirPollutionAlert alert;

    public Subscriber(String name, AirPollutionAlert alert){
        this.name = name;
        this.alert = alert;
        this.alert.register(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println(String.format("%s received notification: %.1f", name, ((AirPollutionAlert)observable).getPsi()));
    }
}
