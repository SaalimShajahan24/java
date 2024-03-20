//sum of 2 numbers 
import java.io.*;

class num {

    int a;

    public void read() {
        DataInputStream din = new DataInputStream(System.in);
        try {
            System.out.print("Enter Number: ");
            a = Integer.parseInt(din.readLine());
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void disp() {
        System.out.println(a);
    }

    public num add(num q) {
        num t = new num();
        t.a = a + q.a;
        return t;
    }
}

public class SumTwo {
    public static void main(String[] args) {
        num p, q, r;
        p = new num();
        q = new num();
        p.read();
        q.read();
        r = p.add(q);
        p.disp();
        q.disp();
        r.disp();
    }

}
