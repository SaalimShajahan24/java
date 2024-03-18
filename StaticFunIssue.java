class c1 {
    public static void disp() {
        System.out.println("In c1 class");
    }
}

class c2 {
    public static void disp() {
        System.out.println("In c2 class");
    }
}

public class StaticKeyword {
    public static void disp() {
        System.out.println("In Main class");
    }

    public static void main(String[] args) {
        disp(); // directly as it's in the same class
        c1.disp();
        c2.disp();
        // className.FunctionName();
    }
}
