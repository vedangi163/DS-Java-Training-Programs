
public class LinearInheritanceTest {

	public static void main(String[] args) {
		StaffMember sm = new StaffMember(101, "Vedangi", 100000);
		sm.printStaffMember();
		System.out.println("--------------");
		
		Teacher t = new Teacher(201, "Joe", 30000, "Computer Networks", 100);
		t.printTeacher();
		System.out.println("---------------");
		
		HOD1 hod = new HOD1(301, "Jonas", 50000, "DBMS", 100, "MongoDB");
		hod.printHOD1();
		System.out.println("----------------");
	}

}

class StaffMember
{
	int staffId;
	String staffName;
	float salary;
	
	public StaffMember(int staffId, String staffName, float salary) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.salary = salary;
	}
	
	void printStaffMember()
	{
		System.out.println("Staff Id: "+staffId);
		System.out.println("Staff Name: "+staffName);
		System.out.println("Salary: "+salary);
		
	}
	
	
	
	
}

class Teacher extends StaffMember
{
	String subjectTeacher;
	int noOfStudents;
	public Teacher(int staffId, String staffName, float salary, String subjectTeacher, int noOfStudents) {
		super(staffId, staffName, salary);
		this.subjectTeacher = subjectTeacher;
		this.noOfStudents = noOfStudents;
	}
	
	void printTeacher()
	{
		super.printStaffMember();
		System.out.println("Subject Name: "+subjectTeacher);
		System.out.println("No of Students teacher is teaching: "+noOfStudents);
	}
	
}


class HOD1 extends Teacher
{
	String newSubject;

	public HOD1(int staffId, String staffName, float salary, String subjectTeacher, int noOfStudents,
			String newSubject) {
		super(staffId, staffName, salary, subjectTeacher, noOfStudents);
		this.newSubject = newSubject;
	}
	
	void printHOD1()
	{
		super.printTeacher();
		System.out.println("HOD added new Subject to curriculum: "+newSubject);
	}
}
