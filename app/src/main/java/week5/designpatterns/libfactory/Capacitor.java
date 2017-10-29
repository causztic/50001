package week5.designpatterns.libfactory;

public class Capacitor implements Component {
    @Override
    public void draw () {
        System.out.println("In Capacitor:draw() method.");
    }
}
