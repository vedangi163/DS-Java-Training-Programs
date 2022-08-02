import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionTest {

	public static void main(String[] args) 
	{
		Flight flightObj = new Flight(10);
		
		Class classObj = flightObj.getClass();
		
		System.out.println("Type of object "+classObj.getName());
		
		 Method m[] = classObj.getMethods();
		 for(Method method: m)
		 {
			 System.out.println("Method name: "+method.getName());
		 }
	
		 Constructor c[] = classObj.getConstructors();
		 
		 for(Constructor ele: c)
		 {
			 System.out.println(" Parameters");
			 Parameter p[] = ele.getParameters();
			 for(Parameter obj: p)
			 {
				 System.out.println("  "+obj.getType());
			 }
		 }

	}

}
