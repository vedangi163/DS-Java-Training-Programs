
public class Unique {

	public static void main(String[] args) 
	{
		HOD hod = new HOD();
		
		System.out.println("No of students " +hod.noOfStudents());
		
		System.out.println("Change pwd: "+hod.changePwd(hod.oldPwd));
		
		hod.MarksofOOP(hod.marks);
		hod.UserRole();
		

	}

}
/*
 * return no of students
 * change password - arguments & return type
 * modify subject marks
 * 
 * 
 * 
 */
class HOD
{
	public
		String oldPwd = "old";
	    int marks = 100;
	
	  void UserRole()
		{
			System.out.println("Role of user is : HOD");
		}
	    
	    
	int noOfStudents()
	{
		return 3000;
	}
	
	String changePwd(String oldPwd)
	{
		oldPwd = "NewPassword"; 
		return oldPwd;
	}
	
	void MarksofOOP(int marks)
	{
		System.out.println("Marks for OOP : "+marks);
	}
	
	
}
