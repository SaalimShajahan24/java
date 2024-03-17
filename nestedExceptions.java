
public class nestedExceptions {
    public static void main(String[] args) {
        try {
            int a = 5 / 2;
            try {
                a = 10 / 0;
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(a);
        } finally {
            System.out.println("Here");
        }
    }
}
