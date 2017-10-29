package week5.parta;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaojie on 17/10/17.
 */

public class Traffic extends Observable implements Subject{

    private String status;


    public String getStatus() {
        return status;
    }

    @Override
    public void unregister(Observer user){
        deleteObserver(user);
    }

    @Override
    public void register(Observer o) {
        this.addObserver(o);

    }

    public void changeCondition(String status){
        this.status = status;
        setChanged();
        notifyObservers();
    }

}
