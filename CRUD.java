


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


// rollno dall
//Make one table as Student1, with 
//roll number, Student1 name, birthdate, physics, chemistry, maths, total, grade
//
//and perform INSERT, UPDATE, DELETE, SELECT AND SELECT ALL RECORDS OPERATIONS OVER IT USING THE JDBC

public class CRUD
{
	public static void main(String[] args) 
	{
		Student1 s = new Student1();
		int ch;
		do
		{
			System.out.print("1.Insert \n2.Update \n3.Delete \n4.SelectAll\n5.Exit");
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

class Student1
{
	void insertDetails()
	{
		try {
			System.out.println("*****Insert Student1 details****");
			int rollno, physics, chemistry, maths, total;
			String name, grade, birthdate;
			
			
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter Student1 roll no: ");
			rollno = sc.nextInt();
		
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Studentdetails where rollno="+rollno);
			if(rs.next())
			{
				throw new Student1AlreadyExistsException("Student1 already exists.....");
			}

			System.out.println("enter Student1 name: ");
			name = sc.next();
			
			System.out.println("Enter birth date: ");
			String dob = sc.next();
			Date date = Date.valueOf(dob);

			//birthdate =sc.next() ;
			//Date date1 = Date.valueOf(sc.next());
		
			System.out.println("enter Student1 physics marks: ");
			physics = sc.nextInt();
			
			System.out.println("enter Student1 chemistry marks: ");
			chemistry = sc.nextInt();
			
			System.out.println("enter Student1 maths marks: ");
			maths = sc.nextInt();
			
			total = (physics + chemistry + maths);
			if(total >= 200)
				grade="A";
			else if(total >= 100)
				grade = "B";
			else
				grade = "C";
			
		   PreparedStatement pst = con.prepareStatement("insert into Studentdetails values(?,?,?,?,?,?,?,?)");
		   pst.setInt(1, rollno);
		   pst.setString(2, name);
		   pst.setDate(3, date);
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
		catch (Student1AlreadyExistsException e) {
		
			e.printStackTrace();
		}
	}

	void displayDetails()
	{
		try {
			System.out.println("*****Display Student1 details*****");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("driver registered");
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			Statement statement = con.createStatement();
			System.out.println("statement created");
			
			ResultSet rs = statement.executeQuery("select * from Studentdetails");
			
			while(rs.next())
			{
				System.out.println("Student1 roll no "+rs.getInt(1));
				System.out.println("Student1 name: "+rs.getString(2));
				System.out.println("Student1 birthdate: "+rs.getString(3));
				System.out.println("Student1 physics: "+rs.getInt(4));
				System.out.println("Student1 chemistry: "+rs.getInt(5));
				System.out.println("Student1 maths: "+rs.getInt(6));
				System.out.println("Student1 total: "+rs.getInt(7));
				System.out.println("Student1 grade: "+rs.getString(8));
				
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
		
		System.out.println("****Update Student1 details****");
		try 
		{
			int rollno, physics=0, chemistry=0, maths=0,total=0;
			String name, grade;
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			PreparedStatement pst = con.prepareStatement("update Studentdetails set sname=?, birthdate=?, physics=?, chemistry=?, maths=?, total=?, grade=? where rollno=?");
			System.out.println("Prepared statement created");
			
			System.out.println("Enter Student1 rollno: ");
			Scanner sc = new Scanner(System.in);
			rollno = sc.nextInt();
			String ch;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Studentdetails where rollno="+rollno);
			if(rs.next())
			{
				System.out.println("Do you want to update Student1 name ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter Student1 name: ");
					String sname = sc.next();
					pst.setString(1, sname);
				}
				else
				{
					pst.setString(1, rs.getString("sname"));
				}
				
				System.out.println("Do you want to update Student1 birthdate ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter Student1 birthdate: ");
					String birthdate = sc.next();
					pst.setString(2, birthdate);
				}
				else
				{
					pst.setString(2, rs.getString("birthdate"));
				}
				
				System.out.println("Do you want to update Student1 physics marks ?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter Student1 physics marks: ");
					physics = sc.nextInt();
					pst.setInt(3, physics);
				}
				else
				{
					physics = rs.getInt("physics");
					pst.setString(3, rs.getString("physics"));
				}
				
				System.out.println("Do you want to update Student1 chemistry marks?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter Student1 chemistry marks: ");
					chemistry = sc.nextInt();
					pst.setInt(4, chemistry);
				}
				else
				{
					chemistry = rs.getInt("chemistry");
					pst.setString(4, rs.getString("chemistry"));
				}
				
				System.out.println("Do you want to update Student1 maths marks?");
				ch = sc.next();
				if(ch.equals("y"))
				{
					System.out.println("Enter Student1 maths marks: ");
					maths = sc.nextInt();
					pst.setInt(5, maths);
				}
				else
				{
					maths = rs.getInt("maths");
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
				throw new Student1NotFoundException("Student1 not found with rollno "+rollno);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Student1NotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	
	void deleteDetails()
	{
		try {
			
			System.out.println("*****Delete Student1 details****");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Scanner sc = new Scanner(System.in);
			int rollno = sc.nextInt();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Studentdetails where rollno="+rollno);
		
			if(rs.next())
			{
				PreparedStatement pst = con.prepareStatement("delete from Studentdetails where rollno = ?");
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
				throw new Student1NotFoundException("Student1 not found with rollno: "+rollno);
			}
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (Student1NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
