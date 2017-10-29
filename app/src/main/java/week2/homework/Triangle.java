package week2.homework;
// Question 2
// total: 10 points

//===============================================
// todo: complete the following program. please find the GeometricObject.java in the same folder.
//===============================================

class Triangle extends GeometricObject {
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public String toString(){
        return String.format("Triangle: side1 = %d side2 = %d side3 = %d", side1, side2, side3);
    }
}

class TestTriangle {
    public static void main(String[] args) {
        Triangle myTri = new Triangle();
        myTri.setColor("red");
        myTri.setFilled(true);
        System.out.println(myTri);
        System.out.println(myTri.isFilled());

        Triangle myTri2 = new Triangle(2.0, 4.0, 5.5);
        System.out.println(myTri2);
        System.out.println("area : " + myTri2.getArea() + " perimeter: " + myTri2.getPerimeter());

    }
}


//===============================================
// test case
//===============================================

/*

Input:

public class TestTriangle {
	public static void main(String[] args) {
		Triangle myTri = new Triangle();
		myTri.setColor("red");
		myTri.setFilled(true);
		System.out.println(myTri);
		System.out.println(myTri.isFilled());

		Triangle myTri2 = new Triangle(2.0, 4.0, 5.5);
		System.out.println(myTri2);
		System.out.println("area : " + myTri2.getArea() + " perimeter: " + myTri2.getPerimeter());

	}
}

Expected Output:

Triangle: side1 = 1.0 side2 = 1.0 side3 = 1.0
true
Triangle: side1 = 2.0 side2 = 4.0 side3 = 5.5
area : 3.0714155938264036 perimeter: 11.5

*/
