
public class GenericTest {
	
	public static void main(String[] args) 
	{
//		IntValues iv = new IntValues(10, 20);
//		iv.print();
//		iv.swap();
//		iv.print();
//		
//		System.out.println("------------------");
//		
//		FloatValues fv = new FloatValues(5.3f, 9.8f);
//		fv.print();
//		fv.swap();
//		fv.print();
		
		AnyValues<Integer> av = new AnyValues<Integer>(10, 20);
		av.print();
		av.swap();
		av.print();
		
//		AnyValues<Float> av2  = new AnyValues<Float>(10.2f, 52.5f);
//		av2.print();
//		av2.swap();
//		av2.print();
		
	}

	
}

//
//class IntValues
//{
//	int x;
//	int y;
//	
//	
//	public IntValues(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//	void print()
//	{
//		System.out.println("x: "+x);
//		System.out.println("y: "+y);
//	}
//	
//	void swap()
//	{
//		int temp = x;
//		x=y;
//		y= temp;
//	}
//}
//
//class FloatValues
//{
//	float x;
//	float y;
//	
//	
//	public FloatValues(float x, float y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//	void print()
//	{
//		System.out.println("x: "+x);
//		System.out.println("y: "+y);
//	}
//	
//	void swap()
//	{
//		float temp = x;
//		x=y;
//		y= temp;
//	}
//}

class AnyValues<T>
{
	T x;
	T y;
	
	
	public AnyValues(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}

	void print()
	{
		System.out.println("x: "+x);
		System.out.println("y: "+y);
	}
	
	void swap()
	{
		T temp = x;
		x=y;
		y= temp;
		
		int z = (int)x + (int)y;
		System.out.println("uiyfdoiea  "+z);
	}
}