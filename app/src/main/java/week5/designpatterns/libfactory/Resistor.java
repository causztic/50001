package week5.designpatterns.libfactory;

public class Resistor implements Component {
    @Override
    public void draw () {
        System.out.println ("In Resistor::draw() method.");
    }
}

