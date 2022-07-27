import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {

		System.out.println("Begin main");

		try
		{
			
			int i = new Scanner(System.in).nextInt();
			System.out.println("i "+i);
			
			int j = new Scanner(System.in).nextInt();
			System.out.println("j "+j);
			
			int k= i/j;
			System.out.println("k "+k);
		}
		catch(Exception e)
		{
			System.out.println("Cant devide by zero...."+e);
		}
		
			
		Messaging m = new Messaging();
		m.printMessage();
		
		System.out.println("End main");

	}
}

class Messaging
{
	String str;
	void printMessage() 
	{
		try
		{
			System.out.println("str "+str.toUpperCase());
			System.out.println("3rd letter in "+str+" is "+str.charAt(3));
		}
		catch(NullPointerException ex)
		{
			System.out.println("Exception is :"+ex);
		}
	}	
	

}



/*

	Exception = runtime error
	
	
				Errors
					|
		---------------------------------------
		|		|		|		|		|
	compile	runtime		linker	fatal	logical
	|		 |			|		 |		|
	syntax Exceptions  library  JVM		4+4=16
				
			
					Object
						|
				------------------
					|
				Throwable
					|
			----------------
			|			|
			Error		Exception
						|(checked)
			---------------------------
			|
	RuntimeException
	 	| (unchecked)
---------------------
    |
ArithmeticException


checked			- by the compiler
unchecked 		- by the compiler


try { } catch() { }  finally { }

throws


			
	void fundTransfer(sa, ta, amt)
	
		1. check the presense of ta
			if ta found
			then
				2. check the presense of sa
				if sa found
				then
					3. check the balance at sa
					if sa is suff balance
					then
							4. sa.withdraw
							5. ta.deposit
					else
						sa insufficient balance
				else
					sa not found
			else
				ta not found
				
	---------------
	
				
		void fundTransfer(sa, ta, amt)
	
		{
		try
		{
			1. check the presense of ta
			2. check the presense of sa
			3. check the balance at sa
			4. sa.withdraw
			5. ta.deposit
		}
		catch(if ta not found)
		{
				ta not found
		}
		catch(if sa not found)
		{
				sa not found
		}
		catch(if sa with insuff bal)
		{
						sa insufficient balance
		}
				
				
			
			
			
			
			
			
			
			
		
			
Java Documentation




*/