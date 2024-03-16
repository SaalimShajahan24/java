
//java supports multiple interfaces not multiple inheritance
import java.io.*;

interface i1 {
    public void disp();
}

interface i2 {
    public void print();
}

class c1 implements i1, i2 {
    public void disp() {
        System.out.println("Of interface i1");
    }

    public void print() {
        System.out.println("Of interface i2");
    }
}

public class MultipleInterface {
    public static void main(String[] args) {
        c1 obj = new c1();
                          
        obj.disp();
        obj.print();
    }
}
