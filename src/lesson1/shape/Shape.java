package lesson1.shape;

public abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Circle!");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Square!");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw Triangle!");
    }
}

class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        circle.draw();
        square.draw();
        triangle.draw();

    }
}
