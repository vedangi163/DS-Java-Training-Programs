
public class AbstractionTest {
	
	public static void main(String[] args) {
		
		GeometricShape gs = new Square();
		gs.draw();
		
		gs = new Rectangle();
		gs.draw();  
		Square s = new Square();
		s.draw();
	}

}

abstract class GeometricShape
{
	abstract void draw();
}
abstract class Circle extends GeometricShape
{
	abstract void area();
}
class Square extends Circle
{
	void draw() 
	{ 
		System.out.println("In square - draw()");
	}
	void area() 
	{
		
	}
}
class Rectangle extends Square
{
	//No need to override draw() since it already have draw() from Square
	void draw() 
	{ 
		System.out.println("In rectangle - draw()");
	}
}