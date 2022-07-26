import java.time.LocalDate;

public class AssociationTest {

	public static void main(String[] args) {
		PersonBaseClass pb = new PersonBaseClass("Madhura", "BA", LocalDate.of(2001, 10, 20));

		Certification certificate1 = new Certification(1001, "Certified Foodservice Professional", "(NAAFE)North American Association of Food Equipements");

		Chef chef = new Chef("Madhura", "BA", LocalDate.of(2001,10, 20), certificate1, "Grand Tamanna");
		
		Ingredients[] ingre = new Ingredients[3];
		
		ingre[0]= new Ingredients("Water", 250);
		ingre[1]= new Ingredients("Maggi", 1);
		ingre[2]= new Ingredients("Maggie Masala", 1);
		
		Induction induction = new Induction(30.0f, 15000, "Prestige");
		chef.displayChef();
		Food f = chef.cook(induction, ingre);
		f.displayFood();
	}

}


class PersonBaseClass
{
	String name;
	String qualification;
	LocalDate DOB;
	
	
	public PersonBaseClass(String name, String qualification, LocalDate dOB) {
		super();
		this.name = name;
		this.qualification = qualification;
		DOB = dOB;
	}



	
}


class Chef extends PersonBaseClass
{
	
	Certification c = new Certification(1001, "Certified Foodservice Professional", "(NAAFE)North American Association of Food Equipements");
	String hotel;
	
    public Chef(String name, String qualification, LocalDate dOB, Certification c, String hotel) {
		super(name, qualification, dOB);
		this.hotel = hotel;
		this.c = c;
	}
    
    void displayChef()
    {
    	System.out.println("************* Chef Details *************** ");
    	System.out.println(hotel+" | "+c.certificateNo+" | "+c.name+" | "+c.issuedBy);
    	System.out.println("");
    }
    
	Food cook(Induction i, Ingredients ingr[] )
	{	
		
		Food f = new Food("Junk food", "Maggie" , "Good", 40.0f);
		System.out.println("************* Induction details *************");
		System.out.println(" Company: "+i.company+" Cost: "+i.cost+ " temprature: "+i.temperature);
		System.out.println("");
		
		System.out.println("************* Ingredients details ************* ");
		for(int j=0; j<ingr.length; j++)
		{
			System.out.println("Ingredient "+j);
			System.out.println(" | "+ingr[j].name+" | "+ingr[j].quantity+" | "+ingr[j]);
		}
		
		System.out.println("");
		return f;
	}
	
}

class Certification
{
	int certificateNo;
	String name;
	String issuedBy;
	
	public Certification(int certificateNo, String name, String issuedBy) {
		super();
		this.certificateNo = certificateNo;
		this.name = name;
		this.issuedBy = issuedBy;
	}

}

class Food
{
	String type;
	String foodName;
	String taste;
	float prize;
	
	public Food(String type, String foodName, String taste, float prize) {
		super();
		this.type = type;
		this.foodName = foodName;
		this.taste = taste;
		this.prize = prize;
	}

	void displayFood()
	{
		System.out.println("*************** Food Details**********");
		System.out.println(type+" | "+foodName+" | "+taste+" | "+prize);
	}
}

class Induction
{
	float temperature;
	float cost;
	String company;
	
	public Induction(float temperature, float cost, String company) {
		super();
		this.temperature = temperature;
		this.cost = cost;
		this.company = company;
	}
	
}

class Ingredients
{
	String name;
	float quantity;
	//String taste;
	
	public Ingredients(String name, float quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
}



