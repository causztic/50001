package week5.designpatterns.libvisitor;

public interface Visitor {
    void visit(Book b);
    void visit(CD c);
    void visit(Clothing c);
}
