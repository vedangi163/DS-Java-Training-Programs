import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
	public static void main(String[] args) 
	{
		BookDetails b1 = new BookDetails(562, "The Alchemist", "Daniel");
		BookDetails b2 = new BookDetails(545, "The Secret", "Jonas");
		BookDetails b3 = new BookDetails(540, "The Secret", "Jonas");
		BookDetails b4 = new BookDetails(550, "The Secret", "Jonas");
		
		
		ArrayList<BookDetails> al = new ArrayList<BookDetails>();
		al.add(b1);
		al.add(b2);
		al.add(b3);
		al.add(b4);
		
		Collections.sort(al, new ISBNComparator());
		
		for(BookDetails b : al)
		{
			System.out.println("Book Obect: "+b);
		}
		
	}
}

class ISBNComparator implements Comparator<BookDetails>
{

	@Override
	public int compare(BookDetails o1, BookDetails o2) {
		if(o1.ISBN == o2.ISBN)
			return 0;
		else if(o1.ISBN > o2.ISBN)
			return 1;
		else
			return -1;
	}
	
}

class BookDetails 
{
	int ISBN;
	String name;
	String author;
	
	public BookDetails(int iSBN, String name, String author) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDetails [ISBN=" + ISBN + ", name=" + name + ", author=" + author + "]";
	}
	

}
