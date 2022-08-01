import java.util.HashSet;
import java.util.Scanner;

public class Assignment {
	
	HashSet<Department> hs = new HashSet<Department>();
	
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		HashSet<Department> hs = new HashSet<Department>();
		
		
			Department d1 = new Department();
			d1.setDetails();
			d1.printDetails();
			hs.add(d1);
			
			Department d2 = new Department();
			d2.setDetails();
			d2.printDetails();
			
			try {
				Department.checkDuplicate(hs, d2);
			} 
			catch (DuplicateException e) 
			{
				System.out.println(e);
				System.out.println("Enter other department name: ");
				String n = sc.next();
				d2.setDeptName(n);
				d2.printDetails();
				e.printStackTrace();
			}
	}
	
}


class Department
{

	String deptName;
	String location;
	int noOfEmp;
	
	static int id =0;
	
	public Department()
	{
		noOfEmp =0;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}
	
	
	void setDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department name:");
		String name = sc.next();
		
		System.out.println("Enter location:");
		String loc = sc.next();
		
		setDeptName(name);
		setLocation(loc);
		
		id = id + 10;
	}
	
	void printDetails() 
	{
		System.out.println("Id "+id);
		System.out.println("Name "+getDeptName());
		System.out.println("Location "+getLocation());
		System.out.println("No of Emp "+getNoOfEmp());
	
	}
	
	static void checkDuplicate(HashSet<Department> h, Department d) throws DuplicateException
	{
		for(Department obj: h)
		{
		    if(obj.deptName.equals(d.deptName))
			{
				throw new DuplicateException("Department name is duplicate");
			}
		}
	}
}


class DuplicateException extends Exception
{
	public DuplicateException(String msg)
	{
		super(msg);
		
	}
}