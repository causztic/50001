package week5.designpatterns.libtestmessageboard;

public interface Subject {
	void register(Observer o);
	void unregister(Observer o);
	void notifyObservers();
	

}
