import java.util.*;

public class Student 
{
	String firstName;
	String lastName;
	String ID;
	ArrayList<Course> coursesTaken;
	double numberofCredits;
	double GPA;
	
	public Student()//default constructor;
	{
		firstName = "";
		lastName = "";
		ID = "";
		coursesTaken = new ArrayList<Course>();//creates 
		numberofCredits = 0;
		GPA = 0;
	}
	
	public Student(String fName, String lName, String id, ArrayList<Course> ct,double c, double g)
	{
		firstName = fName;
		lastName = lName;
		ID = id;
		coursesTaken = ct;
		numberofCredits = c;
		GPA = g;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public ArrayList<Course> getCoursesTaken()//getter for Array List
	{
		return coursesTaken;
	}
	
	public double getCredits()
	{
		return numberofCredits;
	}
	
	public double getGPA()
	{
		return GPA;
	}
	
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	
	public void setID(String id)
	{
		ID = id;
	}
	public void setCoursesTaken(ArrayList<Course> ct)
	{
		coursesTaken = ct;
	}
	
	public void setCredits(double c)
	{
		numberofCredits = c;
	}
	
	public void setGPA(double g)
	{
		GPA = g;
	}
	
	public String toString()
	{
		return firstName + " " + lastName + " | " + "Student ID: " + ID + " | " + "Credits: " + numberofCredits + " | " + "GPA: " + GPA;
	}
	
	public boolean equals(Object o)
	{
		return (o != null
				&& getClass() == o.getClass()
				&& ID ==((Student)o).ID
				);
	}
	public int compareTo(Student s)
	{
		return lastName.compareTo(s.getLastName());		
	}

}
