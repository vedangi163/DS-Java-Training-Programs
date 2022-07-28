import java.util.Scanner;

public class CustomExceptionTest {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		m.unlock();
		
		try {
			m.dial();
		} catch (LengthOfContactNo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnlockTheMobileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class UnlockTheMobileException extends Exception
{
	public UnlockTheMobileException(String m) {
		super(m);
	}
}

class LengthOfContactNo extends Exception
{
	public LengthOfContactNo(String msg) {
		super(msg);
	}
}
class Mobile
{
	String contactNo;
	boolean status;
	
	void unlock()
	{
		if(status == false)
		{
			status = true;
		}
		System.out.println("Phone is unlocked....");
	}
	
	void dial() throws LengthOfContactNo, UnlockTheMobileException
	{
		
		if(status!=true)
		{
			throw new UnlockTheMobileException("Please unlock the phone first");
		}
		System.out.println("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		contactNo = sc.next();
		
		if(contactNo.length()!=10)
		{
			throw new LengthOfContactNo("Length of Mobile Number must be 10");
		}
		System.out.println("Calling....");
		
	}
}

