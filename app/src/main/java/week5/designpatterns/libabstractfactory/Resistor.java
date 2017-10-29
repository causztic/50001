package week5.designpatterns.libabstractfactory;

public class Resistor implements Component {
    @Override
    public void place () {
        System.out.println("In Resistor::place() method.");
    }
}
