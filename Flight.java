
public class Flight {

	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	
	public Flight(int flightId, String flightName, String source, String destination) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
	}

	public Flight(int flightId) {
		super();
		this.flightId = flightId;
	}

	public Flight(int flightId, String flightName) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
	}
	
	public void fly()
	{
		System.out.println("Flight is flying....");
	}
	
	public void land()
	{
		System.out.println("Flight landed...");
	}
	

}
