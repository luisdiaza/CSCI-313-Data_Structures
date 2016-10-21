import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver {
	
	public static void main(String[] args)throws IOException
	{
		boolean pass = false;
		Scanner user_input = new Scanner( System.in );
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Student> studentList2 = new ArrayList<Student>();
		String option = "0"; 
		
		while (option != null)
		{ 
			System.out.println("Select number of choice you would like to do: ");
			System.out.println("1: Load Current Students"); 
			System.out.println("2: Add New Students"); 
			System.out.println("3: Store Data"); 
			System.out.println("4: Exit");
			option = user_input.next( );
			
			if (option.equalsIgnoreCase("1") && !pass)
			{
			
				File myFile = new File("WarmUpData.txt");
				pass = true;//prevents loading students more than once
				BufferedReader br = new BufferedReader(new FileReader(myFile)); 
				String line = br.readLine();//reads in student name and ID
				
				while (line!= null)
				{  
					ArrayList<Course> courseList = new ArrayList<Course>();
					StringTokenizer myTokens = new StringTokenizer(line, ","); 	
					while (myTokens.hasMoreTokens())
					{
						Student scholar = new Student();//creates Student object
						
						String surname = myTokens.nextToken(); //1 (last name)
						scholar.setLastName(surname);
						
						String givenName = myTokens.nextToken(); //2 (first name)
						scholar.setFirstName(givenName);
						
						String ID = myTokens.nextToken();  //3 (ID)
						scholar.setID(ID);
						
						studentList.add(scholar);
						
						line = br.readLine();//reading of courses begins
						while (!(line.equalsIgnoreCase("-999")))//continues until -999 is reached
						{
							myTokens = new StringTokenizer(line,",");
							Course courses = new Course();
							
							String classNumber = myTokens.nextToken(); 
							courses.setCourseNumber(classNumber);//classNumber
							
							double credits = Double.parseDouble(myTokens.nextToken());
							courses.setNumberofCredits(credits);//credits
							
							String grade1 = myTokens.nextToken(); 
							courses.setGrade(grade1);//grade
							
							courseList.add(courses);
							line = br.readLine();
						} //while loop does not skip directly to credits and gpa line
						myTokens = new StringTokenizer(line,",");
						String end = myTokens.nextToken();// end = -999 
						//System.out.println(end);
						
						line = br.readLine();//begins reading credits and gpa line
						
						myTokens = new StringTokenizer(line,",");//total # credits
						double totalCredits = Double.parseDouble(myTokens.nextToken());//11
						scholar.setCredits(totalCredits);
						
						double GPA = Double.parseDouble(myTokens.nextToken()); //12 (overall GPA)
						scholar.setGPA(GPA);
						scholar.setCoursesTaken(courseList);
					}
					
					line = br.readLine();
			}
				br.close(); 
				
				
			}
			
			if (option.equalsIgnoreCase("2"))
			{
				Student newStudent = new Student();
				System.out.print("Enter student's last name: ");
				String lastName = user_input.next( );
				
				newStudent.setLastName(lastName);
				System.out.print("Enter student's first name: ");
				String firstName = user_input.next( );
				newStudent.setFirstName(firstName);
				System.out.print("Enter student's ID number: ");
				String id = user_input.next( );
				newStudent.setID(id);
				
				studentList.add(newStudent);
				System.out.print("How many classes has "+ firstName + " taken?");
				int classTotal = Integer.parseInt(user_input.next()); 
				ArrayList<Course> courseList = new ArrayList<Course>();
				
				for (int i = 0; i <= classTotal-1; i++)
				{
					Course courses = new Course();
					
					System.out.print("Please input course code: ");
					String y = user_input.next(); 
					courses.setCourseNumber(y);
					System.out.print("How many credits is this course?" );
					String credit = user_input.next(); 
					double credits = Double.parseDouble(credit);
					courses.setNumberofCredits(credits);
					System.out.print("What grade did "+ firstName +" get in this course?" );
					String grade = user_input.next(); 
					courses.setGrade(grade);
					courseList.add(courses);
					
				}
				newStudent.setCoursesTaken(courseList);
				
				System.out.print("What is their total credits?");
				Double totalCreds = Double.parseDouble(user_input.next());
				newStudent.setCredits(totalCreds);
				System.out.print("What is their GPA?");
				Double gpa = Double.parseDouble(user_input.next());
				newStudent.setGPA(gpa);
				System.out.println("Student Added! Reload list to display.");
			}
			
			if (option.equalsIgnoreCase("3"))
			{
				PrintWriter out = new PrintWriter("WarmUp.txt");
				outPrint(studentList, out);
				
				System.out.println("Your data has been stored.");
				out.close();
			}
			 printStudentList(studentList);
			if (option.equalsIgnoreCase("4"))
			{
				System.out.print("Goodbye");
				option = null; 
			}
		}
		user_input.close();
	}
	
	public static void printStudentList(ArrayList<Student> displayStudents)
	{
		for (int i = 0;  i < displayStudents.size(); i++ )
		{
			System.out.println(displayStudents.get(i).toString());
			System.out.println((displayStudents.get(i)).getCoursesTaken().toString());
			
			System.out.println(); 
		}
	}
	
	public static void outPrint(ArrayList<Student> displayStudents,PrintWriter pr)
	{
		for (int i = 0;  i < displayStudents.size(); i++ )
		{
			pr.println(displayStudents.get(i).toString());
			pr.println((displayStudents.get(i)).getCoursesTaken().toString());
			
			pr.println(); 
		}
	}
}
