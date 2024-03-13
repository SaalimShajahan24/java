import java.io.*;

class Complex {
    double i;
    double r;

    public void read() {
        DataInputStream din = new DataInputStream(System.in);
        try {
            System.out.println("Enter the complex no:");
            r = Double.parseDouble(din.readLine());
            i = Double.parseDouble(din.readLine());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Complex add(Complex q) {
        Complex t = new Complex();
        t.r = r + q.r;
        t.i = i + q.i;
        return t;
    }

    public Complex mult(Complex q) {
        Complex t = new Complex();
        t.r = r * q.r - i * q.i;
        t.i = r * q.i + i * q.r;
        return t;
    }

    public void disp() {
        System.out.println("Real: " + r + ", Imaginary: " + i);
    }
}

class MComplex {
    public static void main(String args[]) {
        Complex i, r, result;
        i = new Complex();
        r = new Complex();
        result = new Complex();

        System.out.println("Enter the first complex number:");
        i.read();

        System.out.println("Enter the second complex number:");
        r.read();

        System.out.println("First Complex Number:");
        i.disp();

        System.out.println("Second Complex Number:");
        r.disp();


        result = i.add(r);
        System.out.println("Sum of Complex Numbers:");
        result.disp();


        result = i.mult(r);
        System.out.println("Product of Complex Numbers:");
        result.disp();
    }
}
