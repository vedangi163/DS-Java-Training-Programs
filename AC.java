
public class AC {

	public static void main(String[] args) {

		AirConditioner ac= new AirConditioner();
		ac.setTemp(25.05f);
		System.out.println("Current temp is: "+ac.getTemp());
		
		ac.getTemp();
		
		ac.increaseTemp(5);
		System.out.println("Increased temp by: "+ac.temp);
		
		ac.getTemp();
		
		ac.decreaseTemp(6);
		System.out.println("Decreased temp by: "+ac.temp);
		
		ac.getTemp();
	}

}

class AirConditioner
{
	float temp;
	int status;
	
	
	float getTemp()
	{
		return temp;
	}
	
	void setTemp(float t)
	{
		System.out.println("Temp is set to : "+t);
		temp = t;
	}
	
	void increaseTemp(int cnt)
	{
		temp = temp + cnt;
	}
	
	void decreaseTemp(int cnt)
	{
		temp = temp - cnt;
	}
}
