package week5.parta;

/**
 * Created by yaojie on 17/10/17.
 */

public class Square extends Rectangle implements ShapeVisitable {

    public Square(int length){
        super(length, length);
    }

    public int getSide(){
        return this.getLength();
    }

    @Override
    public void accept(ShapeVisitor v) {
        v.visit(this);
    }
}
