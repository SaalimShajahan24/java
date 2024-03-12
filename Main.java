import java.io.*;
class Main{
    public static void main(String args[])
    {
        int a[][],r,c,i,j;
        DataInputStream din=new DataInputStream(System.in);
        try{
            System.out.println("ennter the no of rows and colums");
            r=Integer.parseInt(din.readLine());
            c=Integer.parseInt(din.readLine());
            a=new int[r][c];
            for(i=0;i<r;i++)
            {
                for(j=0;j<c;j++)
                {
                    System.out.println("enter a["+i+"]["+j+"]");
                    a[i][j]=Integer.parseInt(din.readLine());
                }
            }
            for(i=0;i<r;i++)
            {
                for(j=0;j<c;j++)
                {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println("");
            }

        }catch(Exception e)
        {
             System.out.println(e);
        }
    }
}