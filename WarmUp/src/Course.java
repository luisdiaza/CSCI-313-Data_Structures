public class Course
{
	private String courseNumber;
	private double numberofCredits;
	private String grade;
	
	public Course()//default constructor
	{
		courseNumber = "";
		numberofCredits = 0;
		grade = "";
	}
	
	public Course(String c, double n, String g)//argument constructor
	{
		courseNumber = c;
		numberofCredits = n;
		grade = g;
	}
	
	public String getCourseNumber()
	{
		return courseNumber;		
	}
	
	public double getNumberofCredits()
	{
		return numberofCredits;
	}

	public String getGrade()
	{
		return grade;
	}
	
	public void setCourseNumber(String c)
	{
		courseNumber = c;
	}
	
	public void setNumberofCredits(double n)
	{
		numberofCredits = n;
	}
	
	public void setGrade(String g)
	{
		grade = g;
		
	}
	
	public String toString()//Overrides
	{
		return "Course Number: " + courseNumber + " | Number of Credits: " + numberofCredits + " | Grade: " + grade + "\n";
	}
	
	public boolean equals(Object o)
	{
		return (o != null//object has something in it
				&& getClass() == o.getClass()//produceItem (they have the same data type, not necesarrily values)
				&& courseNumber == ((Course)o).courseNumber
				&& numberofCredits == ((Course)o).numberofCredits
				&& grade == ((Course)o).grade
				);
	}
}