import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



//Make one table as student, with 
//roll number, student name, birthdate, physics, chemistry, maths, total, grade
//
//and perform INSERT, UPDATE, DELETE, SELECT AND SELECT ALL RECORDS OPERATIONS OVER IT USING THE JDBC

public class CRUDOperation 
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		int ch;
		do
		{
			System.out.print("1.Inser \n2.Update \n3.Delete \n4.SelectAll\n5.Exit");
			System.out.println("Enter the choice");
			Scanner sc = new Scanner(System.in);
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1: s.insertDetails();
				        break;
				 
				case 2: s.updateDetails();
						break;
						
				case 3: s.deleteDetails();
						break;
						
				case 4: s.displayDetails();
						break;
						
				case 5: System.exit(0);
			}
		}while(ch!=5);
		
	}

}

class Student
{
	void insertDetails()
	{
		try {
			System.out.println("*****Insert student details****");
			int rollno, physics, chemistry, maths, total;
			String name, grade, birthdate;
			
			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter student roll no: ");
			rollno = sc.nextInt();
		
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where rollno="+rollno);
			if(rs.next())
			{
				throw new StudentAlreadyExistsException("student already exists.....");

			
			}

			
			System.out.println("enter student name: ");
			name = sc.next();
			
			System.out.println("Enter birth date: ");
			birthdate =sc.next() ;
			//Date date1 = Date.valueOf(sc.next());
		
			System.out.println("enter student physics marks: ");
			physics = sc.nextInt();
			
			System.out.println("enter student chemistry marks: ");
			chemistry = sc.nextInt();
			
			System.out.println("enter student maths marks: ");
			maths = sc.nextInt();
			
			total = (physics + chemistry + maths);
			if(total >= 200)
				grade="A";
			else if(total >= 100)
				grade = "B";
			else
				grade = "C";
			
		   PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
		   pst.setInt(1, rollno);
		   pst.setString(2, name);
		   pst.setString(3, birthdate);
		   pst.setInt(4, physics);
		   pst.setInt(5, chemistry);
		   pst.setInt(6, maths);
		   pst.setInt(7, total);
		   pst.setString(8, grade);
		   
		   int rows = pst.executeUpdate();
		   System.out.println("Rows affected..."+rows);
		   
		   pst.close();
		   con.close();
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		} 
		catch (StudentAlreadyExistsException e) {
		
			e.printStackTrace();
		}
	}

	void displayDetails()
	{
		try {
			System.out.println("*****Display student details*****");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("driver registered");
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			Statement statement = con.createStatement();
			System.out.println("statement created");
			
			ResultSet rs = statement.executeQuery("select * from student");
			
			while(rs.next())
			{
				System.out.println("Student roll no "+rs.getInt(1));
				System.out.println("Student name: "+rs.getString(2));
				System.out.println("Student birthdate: "+rs.getString(3));
				System.out.println("Student physics: "+rs.getInt(4));
				System.out.println("Student chemistry: "+rs.getInt(5));
				System.out.println("Student maths: "+rs.getInt(6));
				System.out.println("Student total: "+rs.getInt(7));
				System.out.println("Student grade: "+rs.getString(8));
				
				System.out.println("----------------------");
			}
			rs.close();
			statement.close();
			con.close();
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	void updateDetails()
	{
		
		System.out.println("****Update student details****");
		try 
		{
			int rollno, physics=0, chemistry=0, maths=0,total=0;
			String name, grade;
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			PreparedStatement pst = con.prepareStatement("update student set sname=?, birthdate=?, physics=?, chemistry=?, maths=?, total=?, grade=? where rollno=?");
			System.out.println("Prepared statement created");
			
			System.out.println("Enter student rollno: ");
			Scanner sc = new Scanner(System.in);
			rollno = sc.nextInt();
			String ch;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where rollno="+rollno);
			if(rs.next())
			{
				System.out.println("Do you want to update student name ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter student name: ");
					String sname = sc.next();
					pst.setString(1, sname);
				}
				else
				{
					pst.setString(1, rs.getString("sname"));
				}
				
				System.out.println("Do you want to update student birthdate ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter student birthdate: ");
					String birthdate = sc.next();
					pst.setString(2, birthdate);
				}
				else
				{
					pst.setString(2, rs.getString("birthdate"));
				}
				
				System.out.println("Do you want to update student physics marks ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter student physics marks: ");
					physics = sc.nextInt();
					pst.setInt(3, physics);
				}
				else
				{
					pst.setString(3, rs.getString("physics"));
				}
				
				System.out.println("Do you want to update student chemistry marks?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter student chemistry marks: ");
					chemistry = sc.nextInt();
					pst.setInt(4, chemistry);
				}
				else
				{
					pst.setString(4, rs.getString("chemistry"));
				}
				
				System.out.println("Do you want to update student maths marks?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter student maths marks: ");
					maths = sc.nextInt();
					pst.setInt(5, maths);
				}
				else
				{
					pst.setString(5, rs.getString("maths"));
				}
				
				total = physics+chemistry+maths;
				if(total >= 200)
					grade="A";
				else if(total >= 100)
					grade = "B";
				else
					grade = "C";
				
				pst.setInt(6, total);
				pst.setString(7, grade);
				pst.setInt(8, rollno);
			
				int row = pst.executeUpdate();
				rs.close();
				pst.close();
				con.close();
				System.out.println("Rows :"+row);
			}
			else
			{
				throw new StudentNotFoundException("Student not found with rollno "+rollno);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (StudentNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	
	void deleteDetails()
	{
		try {
			
			System.out.println("*****Delete student details****");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Scanner sc = new Scanner(System.in);
			int rollno = sc.nextInt();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student where rollno="+rollno);
		
			if(rs.next())
			{
				PreparedStatement pst = con.prepareStatement("delete from student where rollno = ?");
				pst.setInt(1, rollno);
				
				int rows = pst.executeUpdate();
				System.out.println("Rows updated : "+rows);
				
				rs.close();
				pst.close();
				st.close();
				con.close();
				
			}
			else
			{
				throw new StudentNotFoundException("Student not found with rollno: "+rollno);
			}
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
