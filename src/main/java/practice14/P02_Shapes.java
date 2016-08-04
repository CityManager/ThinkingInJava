package practice14;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuweiman on 16/7/26.
 * 子类型向上转型后再向下转型为其他子类, 此时运行会 ClassCastException
 * 向下转型前可以使用 instanceof 方法做检查
 */
public class P02_Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());

        for(Shape s: shapeList) {
            s.draw();
            if (s instanceof Circle) {
                System.out.println("Circle");
            }
            rotate(s);
        }



    }

    static void rotate(Shape s) {
        if (!(s instanceof Circle)) {
            System.out.println(s + " rotate.");
        }
    }

}

abstract class Shape {
    void draw() { System.out.println(this + ".draw()");}
    abstract public String toString();
}

class Circle extends Shape {

    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

