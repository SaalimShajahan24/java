//program that shows creating of an object of a class
import java.io.*;

class person {
    int age;
    String name;

    public void setperson(int a, String n) {
        age = a;
        name = n;
    }

    public void dispperson() {
        System.out.println("Name: " + name + " Age: " + age);
    }
}

public class First {
    public static void main(String[] args) {
        person p, q;
        p = new person();
        q = new person();
        p.setperson(20, "ABC");
        q.setperson(25, "DDD");
        p.dispperson();
        q.dispperson();

    }
}