
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class BankAccountHashTest{
	

	public static void main(String[] args) {
		
		StudentDetails obj1 = new StudentDetails("Vedangi", 101);
		StudentDetails obj2 = new StudentDetails("Pooja", 102);
		StudentDetails obj3 = new StudentDetails("Shweta", 103);
		StudentDetails obj4 = new StudentDetails("Shravani", 100);
		
		HashSet<StudentDetails> hs = new HashSet<StudentDetails>();
		hs.add(obj1);
		hs.add(obj2);
		hs.add(obj3);
		hs.add(obj4);
		
		DemoSer serObj = new DemoSer();
		serObj.serialize(hs);
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
	void serialize(HashSet<StudentDetails> h)
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("C:\\Users\\MY pc\\Desktop\\serializeObject.txt");
			System.out.println("File created for writing...");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(h);
			
			oos.close();
			fout.close();
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
			FileInputStream fin = new FileInputStream("C:\\Users\\MY pc\\Desktop\\serializeObject.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			HashSet<StudentDetails> h = new HashSet<StudentDetails>();
			
			h = (HashSet<StudentDetails>) ois.readObject();
			
			for(StudentDetails s: h)
			{
				System.out.println(" "+s);
			}
			
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
}