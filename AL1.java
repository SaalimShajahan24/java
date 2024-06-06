import java.io.*;
import java.util.*; 
import java.lang.*;
 
class AL1
{  
	public static void main(String args[])
	{  
		ArrayList<String>l=new ArrayList <String> ();  
		l.add("Amal");  
		l.add("thomas");  
		l.add("biju");  
		l.add("Ajay");  
		
		Iterator itr=l.iterator();  
		while(itr.hasNext())
		{  
			System.out.println(itr.next());  
  		}  
 	}  
}  