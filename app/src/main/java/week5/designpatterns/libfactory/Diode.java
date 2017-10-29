package week5.designpatterns.libfactory;

public class Diode implements Component {
    @Override
    public void draw (){
        System.out.println ("In Diode::draw() method.");
    }
}
