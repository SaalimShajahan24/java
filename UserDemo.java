//user defined exception
import java.util.*;
class MyEx extends Exception{
    String strErrors;
    public MyEx(String s)
    {
        strErrors=s;
    }
    public void disp()
    {
        System.out.println("error"+strErrors);
    }
}
class UserDemo
{
    public static void main(String args[])
    {
        int a,b,c;
        Scanner s=new Scanner(System.in);
        try{
            System.out.println("enter two nos:");
            a=s.nextInt();
            b=s.nextInt();
            if(b==0)
            {
                throw new MyEx("division by 0 is not possible");
            }
            c=a/b;
            System.out.println("c =" + c);
        }catch(MyEx m)
        {
            m.disp();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
