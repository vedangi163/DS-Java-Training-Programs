import java.util.*;


public class LinkedListTest {
	public static void main(String[] args) 
	{
		Ingredients i1 = new Ingredients("Smashed Aloo", 2);
		Ingredients i2 = new Ingredients("Wheat flooe", 500);
		Ingredients i3 = new Ingredients("Salt", 1);
		
		LinkedList<Ingredients> ll = new LinkedList<Ingredients>();
		
		ll.add(i1);
		ll.add(i2);
		ll.add(i3);
		
		Iterator<Ingredients> iterator = ll.iterator();
		
		
		
	}
}


class Ingredients
{
	String name;
	String taste;
	int quantity;
	public Ingredients(String name, 
			int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	
	
	
}

