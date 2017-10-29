package week5.parta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaojie on 17/10/17.
 */

public class AirPollutionAlert extends Observable implements Subject{

    private float psi;

    public float getPsi() {
        return psi;
    }

    @Override
    public void unregister(Observer user){
        deleteObserver(user);
    }

    @Override
    public void register(Observer o) {
        this.addObserver(o);
    }

    public void setAirPollutionIndex(float psi){

        this.psi = psi;
        if (psi > 100){
            setChanged();
            notifyObservers();
        }
    }

}
