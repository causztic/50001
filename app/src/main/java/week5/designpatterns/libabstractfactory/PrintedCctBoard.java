package week5.designpatterns.libabstractfactory;

public class PrintedCctBoard implements Board {
    @Override
    public void configure() {
        System.out.println("In PrintCctBoard::configure() method.");
    }
}
