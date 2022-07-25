
public class DataTypeTest {
	public static void main(String[] args) {
		
		//-128 to 127
		byte b = -128;
		System.out.println("b is "+b);
		System.out.println("Max value for a byte "+Byte.MIN_VALUE);
		System.out.println("Min value for a byte "+Byte.MAX_VALUE);
		System.out.println("Size for byte "+Byte.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
		
		short s = 234;
		System.out.println("s is "+s);
		System.out.println("Max value for a short "+Short.MIN_VALUE);
		System.out.println("Min value for a short "+Short.MAX_VALUE);
		System.out.println("Size for short "+Short.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
		
		int i = 5214;
		System.out.println("i is "+i);
		System.out.println("Max value for a int "+Integer.MIN_VALUE);
		System.out.println("Min value for a int "+Integer.MAX_VALUE);
		System.out.println("Size for short "+Integer.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
		
		long l = 12586;
		System.out.println("l is "+l);
		System.out.println("Max value for a long "+Long.MIN_VALUE);
		System.out.println("Min value for a long "+Long.MAX_VALUE);
		System.out.println("Size for long "+Long.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
		
		float f = 98953445534895859f;
		System.out.println("f is "+f);
		System.out.println("Max value for a float "+Float.MIN_VALUE);
		System.out.println("Min value for a float "+Float.MAX_VALUE);
		System.out.println("Size for float "+Float.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
		
		double d = 789521;
		System.out.println("d is "+d);
		System.out.println("Max value for a double "+Double.MIN_VALUE);
		System.out.println("Min value for a long "+Double.MAX_VALUE);
		System.out.println("Size for long "+Double.SIZE+" bits");
		System.out.println("--------------");
		System.out.println();
	}
}
