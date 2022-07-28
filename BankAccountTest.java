import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccountTest{
	

	public static void main(String[] args) {
		
		StudentDetails obj1 = new StudentDetails("Vedangi", 101);
		
		DemoSer serObj = new DemoSer();
		serObj.serialize(obj1);
		serObj.deserialize();
		
	}

}

class StudentDetails implements Serializable 
{
	private String name;
	private int rollNo;
	public StudentDetails(String name, int rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "StudentDetails [name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
}

class DemoSer 
{
	
	
	void serialize(StudentDetails bat)
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("C:\\Users\\VBR12\\Desktop\\serializeObject.txt");
			
			System.out.println("File created for writing...");
			
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(bat);
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
	
			e.printStackTrace();
		} 
	}
	
	
	void deserialize()
	{
		try 
		{
			FileInputStream fin = new FileInputStream("C:\\Users\\VBR12\\Desktop\\serializeObject.txt");
			
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			StudentDetails st = (StudentDetails) ois.readObject();
			
			System.out.println("Object is:   "+st);
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
