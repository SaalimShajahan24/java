import java.util.*;  

class Student
{  
	int rollno;  
	String name;  
	int age;  

	public Student(int rollno,String name,int age)
	{  
		this.rollno=rollno;  
		this.name=name;  	
		this.age=age;  
  	}  
	public void disp()
	{
		System.out.println(rollno+" "+name+" "+age);  
	}
}  

public class ALFE
{  
	public static void main(String args[])
	{  

		Student s1=new Student(101,"Ramu",20);  
		Student s2=new Student(102,"Ajay",21);  
		Student s3=new Student(103,"Karthik",25);  

		ArrayList<Student> al=new ArrayList<Student>();  
  
		al.add(s1);  
		al.add(s2);  
		al.add(s3);  

		for(Student obj:al)  
		{
	  		obj.disp();
  		}  
 	}  
}  