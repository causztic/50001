package week5.parta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaojie on 17/10/17.
 */

public class RoadUser implements Observer{

    private String name;
    private Traffic traffic;

    public RoadUser(String name, Traffic traffic){
        this.name = name;
        this.traffic = traffic;
        this.traffic.register(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println(String.format("%s receives alert: %s", name, ((Traffic)observable).getStatus()));
    }
}
