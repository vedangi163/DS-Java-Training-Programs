/*
 * 1. static variable is always associated with data member of a class and not with local variable of method 
 * Hence if we create/declare static variable in in static or non-static method it will give an error
 * 
 * 2. static method can access only static members 
 * 	  Kite.staticMethod()
 *    how it could identify which obj is calling method, so not non-static members
 * 
 * 3. static var --> single copy only/ created only once 
 *    ex. aadharNo, DOB 
 */

public class StaticTest {

	public static void main(String[] args) {
		Kite kObj1= new Kite(true, "Vedangi", "blue", 10);
		Kite kObj2= new Kite(true, "Ved", "red", 20);
		Kite kObj3= new Kite(true, "Amruta", "blue", 30);
		
		kObj1.printKite();
		kObj2.printKite();
		kObj3.printKite();
		
		Kite.showCount();
		//System.out.println("Kite count: "+Kite.kiteCnt);
	}

}

class Kite
{
	boolean status;
	String owner;
	String color;
	int length;
	private static int kiteCnt;
	
	public Kite(boolean status, String owner, String color, int length) {
		super();
		this.status = status;
		this.owner = owner;
		this.color = color;
		this.length = length;
		kiteCnt++;
	}
	
	void printKite()
	{
		
		System.out.println("KITE DETAILS");
		System.out.println("Kite color: "+color);
		System.out.println("Kite owner: "+owner);
		System.out.println("Kite status: "+status);
		System.out.println("Kite length: "+length);
		System.out.println("in printDetails: "+kiteCnt);
	}
	
	static void showCount()
	{
		System.out.println("Kite cnt: "+kiteCnt);
	}
}

