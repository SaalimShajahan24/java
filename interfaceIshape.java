

import java.io.*;

interface ishape {
    public void draw();

    public void move();
}

class line implements ishape {
    public void draw() {
        System.out.println("Line is drawn");
    }

    public void move() {
        System.out.println("line is moved");
    }
}

class circle implements ishape {
    public void draw() {
        System.out.println("Circle is drawn");
    }

    public void move() {
        System.out.println("Circle is moved");
    }
}

public class interfaceIshape {
    public static void main(String[] args) {
        ishape obj = new line();
        obj.draw();
        obj.move();
        obj = new circle();
        obj.draw();
        obj.move();
       
    }

}
