package threads;

public class SameAverage {
    public static void main(String args[]) {
        PrintClassNameHelper<Shape> shapeClass = new PrintClassNameHelper<Shape>(new Shape());
        print(shapeClass);
    }

    static void print(PrintClassNameHelper<? super Rectangle> printName) {
        printName.print();
    }
}
class Shape {
    void printName() {
        System.out.println("This is shape class");
    }
}

class Rectangle extends Shape {
    void printName() {
        System.out.println("This is Rectangle class");
    }
}
class Square extends Rectangle {
    void printName() {
        System.out.println("This is Square class");
    }
}
class PrintClassNameHelper<T extends Shape> {
    T shape;
    PrintClassNameHelper(T shape) {
        this.shape = shape;
    }
    void print() {
        shape.printName();
    }
}