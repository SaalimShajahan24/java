import java.io.*;
class Num
{
    int a;
    public void read()
    {
        try{
            DataInputStream din=new DataInputStream(System.in);
            System.out.println("enter a number");
            a=Integer.parseInt(din.readLine());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

public void disp()
{
    System.out.println("sum="+a);
}
public Num add(Num q)
{
    Num t=new Num();
    t.a=a+q.a;
    return t;
}
}
class MNum
{
    public static void main(String args[])
    {
        Num p,q,r;
        p=new Num();
        q=new Num();
        p.read();
        q.read();
        r=p.add(q);
        p.disp();
        q.disp();
        r.disp();
    }
}