import java.sql.*;  
import java.io.*;  
public class RetrieveImage
{  
	public static void main(String[] args) 
	{  
		try
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");  
      			PreparedStatement ps=con.prepareStatement("select * from imgtb");  
			ResultSet rs=ps.executeQuery();  
			if(rs.next())   
			{
				Blob b=rs.getBlob(2);	
				byte barr[]=b.getBytes(1,(int)b.length());
              			FileOutputStream fout=new FileOutputStream("testres.jpg");  
				fout.write(barr);  
             			fout.close();  
			}
			System.out.println("ok");  
			con.close();  
		}
		catch (Exception e)
		{
			e.printStackTrace();  
		}  
	}  
}  