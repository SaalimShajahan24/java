import java.io.*;

class Cthread implements Runnable {
    int n, m;

    public Cthread(int a, int b) {
        m = a;
        n = b;
    }

    public void run() {
        while (m != n) {
            System.out.println("\t" + m);
            if (m < n)
                m++;
            else
                m--;
        }
        System.out.println("\t" + m);
    }
}

class MTreadI2 {
    public static void main(String args[]) {
        int m, n;
        try {
            DataInputStream din = new DataInputStream(System.in);
            System.out.println("enter a value for m");
            m = Integer.parseInt(din.readLine());
            System.out.println("enter a value for n");
            n = Integer.parseInt(din.readLine());
            Cthread t1, t2;
            Thread p, q;
            t1 = new Cthread(m, n);
            t2 = new Cthread(n, m);
            p = new Thread(t1);
            q = new Thread(t2);
            System.out.println("B4 thread");
            p.start();
            System.out.println("between thread");
            q.start();
            System.out.println("after thread");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}