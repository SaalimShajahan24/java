import java.io.*;

interface Ishape {
    public void disp();
}

class c1 implements Ishape {
    public void disp() {
        System.out.println("In c1");
    }
}

class c2 implements Ishape {
    public void disp() {
        System.out.println("In c2");
    }
}

public class InstanceOfOperator {
    public static void main(String[] args) {
        Ishape obj[] = new Ishape[3];
        obj[0] = new c1();
        obj[1] = new c2();
        obj[2] = new c1();
        for (int i = 0; i < 3; i++) {
            if (obj[i] instanceof c1) {
                c1 p = (c1) obj[i];
                p.disp();
            } else if (obj[i] instanceof c2) {
                c2 q = (c2) obj[i];
                q.disp();
            }
        }
    }
}
