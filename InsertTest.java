import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	public static void main(String[] args) {
		
		try 
		{
			System.out.println("");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("driver registered");
			
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			PreparedStatement pst = con.prepareStatement("insert into employee values(?, ?, ?)");
			System.out.println("Prepared statement created");
			
			System.out.println("Enter employee id: ");
			Scanner sc1 = new Scanner(System.in);
			int empId = sc1.nextInt();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next())
			{
				int id = rs.getInt(1);
				if(id == empId)
				{
					throw new EmployeeAlreadyExistsException("Employee already exists.....");

				}
			}
			
			System.out.println("Enter employee name: ");
			Scanner sc2 = new Scanner(System.in);
			String empName = sc2.next();
			
			System.out.println("Enter employee salary: ");
			Scanner sc3 = new Scanner(System.in);
			int esalary = sc3.nextInt();
			
			
			pst.setInt(1, empId);
			pst.setString(2, empName);
			pst.setInt(3, esalary);
		
			int rows = pst.executeUpdate();
			System.out.println("Records inserted....");
		
			con.close();
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		} 
		catch(EmployeeAlreadyExistsException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}
}
