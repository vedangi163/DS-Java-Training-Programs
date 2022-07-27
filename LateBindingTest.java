//late binding only happened with overridden methods 


public class LateBindingTest {
	public static void main(String[] args) {
		
		Faculty f = new Faculty();
		f.teaching();
		
		SeniorFaculty sf = new SeniorFaculty();
		sf.teaching();
		
		HeadOfDept hod = new HeadOfDept();
		hod.teaching();
		
//		sf = hod;
//		sf.teaching();
//		
//		f = sf;
//		f.teaching();
		
		
		System.out.println(sf instanceof SeniorFaculty);
		 
	}
}

class Faculty
{
	void teaching()
	{
		System.out.println("Faculty is teaching....");
	}
}

class SeniorFaculty extends Faculty
{
	void teaching()
	{
		System.out.println("Senior Faculty is teaching....");
	}
}

class HeadOfDept extends SeniorFaculty
{
	void teaching()
	{
		System.out.println("HOD is teaching....");
	}
}


