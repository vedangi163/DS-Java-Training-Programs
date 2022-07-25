

/*
 * Function overloading/early binding/ early loading based on 
 * 1. types of parameters
 * 2. no of parameters
 * 3. sequence of parameters
 * 
 * 
 * 
 * 
 * 
 * 
 *Constructor
 *What - function whose name is same as class name, no return type
 *used for initialize object
 *invoked during object creation
 * 
 *you can have either implicit or explicit constructor but not both at same time
 *class A {} //imploicit
 *
 *class A
 *{
 *	A(int a)
 *  {
 *  
 *  }
 *}
 * 
 * Function overloading is not possible with return type 
 * 
 */
public class FunctionOverloadingTest {

	public static void main(String[] args) {
		Distance distObj = new Distance();
		
		distObj.calculateDistance();
		distObj.calculateDistance(10, 02);
		distObj.calculateDistance(12, 5.0f);
		distObj.calculateDistance(12.0f, 10);
		distObj.calculateDistance(4.0f, 2.0f);
	}

}

class Distance
{
	void calculateDistance()
	{
		System.out.println("Distance is 0 since no parameters passed");
	}
	
	void calculateDistance(int speed, int time)
	{
		System.out.println("Distance is :"+(speed*time)+" km");
	}
	
	void calculateDistance(int speed, float time)
	{
		System.out.println("Distance is: "+(speed*time)+" km");
	}
	
	void calculateDistance(float speed, int time)
	{
		System.out.println("Distance is: "+(speed*time)+" km");
	}
	
	void calculateDistance(float speed, float time)
	{
		System.out.println("Distance is: "+(speed*time)+" km");
	}
}
