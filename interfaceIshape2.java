
import java.io.*;

interface ishape {
    public double area();

    public double peremeter();
}

class rectangle implements ishape {
    double l, b;

    public rectangle(double le, double br) {
        l = le;
        b = br;
    }

    public double area() {

        return l * b;
    }

    public double peremeter() {

        return 2 * (l + b);
    }
}

class circle implements ishape {
    double r;

    public circle(double ra) {
        r = ra;
    }

    public double area() {

        return 3.14 * r * r;
    }

    public double peremeter() {

        return 2 * 3.14 * r;
    }
}

public class interfaceIshape2 {
    public static void main(String[] args) {
        ishape obj[];
        DataInputStream din = new DataInputStream(System.in);
        try {
            System.out.println("Enter Number of objects(Shapes): ");
            int n = Integer.parseInt(din.readLine());
            obj = new ishape[n];
            for (int i = 0; i < n; i++) {
                System.out.println("1.Rectangle\t2.Circle");
                int ch = Integer.parseInt(din.readLine());
                if (ch == 1) {
                    double l, b;
                    System.out.println("Enter the Length of the rectangle:");
                    l = Double.parseDouble(din.readLine());
                    System.out.println("Enter the Breadth of the rectangle:");
                    b = Double.parseDouble(din.readLine());
                    obj[i] = new rectangle(l, b);
                } else {
                    double r;
                    System.out.println("Enter the Radius of the circle: ");
                    r = Double.parseDouble(din.readLine());
                    obj[i] = new circle(r);
                }
            }
            for (int i = 0; i < n; i++) {
                double a, p;
                a = obj[i].area();
                p = obj[i].peremeter();
                System.out.println("area: " + a);
                System.out.println("peremeter " + p);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

}
