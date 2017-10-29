package week5.parta;

import java.util.Observer;

/**
 * Created by yaojie on 17/10/17.
 */

public interface Subject {
        void register(Observer o);
        void unregister(Observer o);
        void notifyObservers();
}
