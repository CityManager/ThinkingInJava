package practice08;

import java.util.Random;

/**
 * Created by xuweiman on 16/5/30.
 * 学习多态
 * Java中除了static方法和final方法(private属于final方法),其他方法均是后期绑定的
 */
public class P04_Shapes {
    static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String... args) {
        Shape[] shapes = new Shape[12];

        for(int i=0; i<shapes.length; ++i) {
            shapes[i] = gen.next();
        }

        for(Shape shape:shapes) {
            System.out.println("===========");
            shape.draw();
            shape.erase();
            shape.printInfo();
            System.out.println("===========");
        }
    }
}


class Shape {
    public void draw() {}
    public void erase() {}  // erase 擦除

    public void printInfo() {
        System.out.println("This is a Shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle is drawing.");
    }

    @Override
    public void erase() {
        System.out.println("Circle is erasing.");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("And to be precise, this is a Circle.");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square is drawing.");
    }

    @Override
    public void erase() {
        System.out.println("Square is erasing.");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle is drawing.");
    }

    public void erase() {
        System.out.println("Triangle is erasing.");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("And to be precise, this is a Triangle.");
    }
}

class Oval extends Circle {
    @Override
    public void draw() {
        System.out.println("Oval is drawing.");
    }

    @Override
    public void erase() {
        System.out.println("Oval is erasing.");
    }

    @Override
    public void printInfo() {
        System.out.println("To be precise, this is a Oval.");
    }
}

class RandomShapeGenerator {
    private Random random = new Random(47);
    Shape next() {
        switch(random.nextInt(4)) {
            case 0:
                return new Oval();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            default:
            case 3:
                return new Circle();
        }
    }
}


