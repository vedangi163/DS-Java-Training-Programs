import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadTest {

	public static void main(String[] args) {
		
	String s = "C:\\Users\\VBR12\\Desktop\\batch.txt";
	MyFileReader mfr = new MyFileReader();
	mfr.readFile(s);
	
	s= "C:\\Users\\VBR12\\Desktop\\batch2.txt";
	mfr.readFile(s);
	
	mfr.writeFile();
	s="C:\\Users\\VBR12\\Desktop\\writeFile.txt";
	mfr.readFile(s);
	
	try 
	{
		FileReader fr = new FileReader("C:\\Users\\VBR12\\Desktop\\writeFile.txt");
		System.out.println("**********In file reader////");
		int i =fr.read();
		while(i!=-1)
		{
			System.out.print((char)i);
			i = fr.read();
		}
		fr.close();
	} 
	catch(FileNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch(IOException e) 
	{
		e.printStackTrace();
	}
	
	
	
	}

}


class MyFileReader
{
	FileInputStream fin;
	
	void readFile(String filename)
	{
		try
		{
			fin = new FileInputStream(filename);
			byte b = (byte)fin.read();
			
			System.out.print((char)b);
			while(b != -1)
			{
				b = (byte)fin.read();
				System.out.print((char)b);
			}
			fin.close();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("File closed");
		
		
	}
	
	void writeFile()
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream("C:\\Users\\VBR12\\Desktop\\writeFile.txt",true);
			
			System.out.println("Enter the text: ");
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
			
			byte bytes[] = s.getBytes();
			fos.write(bytes);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

