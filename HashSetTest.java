/*
 
Author name should be same for 2 
 
 
 
 */


import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetTest {
	public static void main(String[] args) {

		Book book1 = new Book("The Alchemist", "Daniel", 101, 1, 50, 100.50f);
		Book book2 = new Book("The Alchemist", "John", 102, 2, 100, 150);
		Book book3 = new Book("The Alchemist", "Daniel", 101, 1, 50, 100.50f);
		
		HashSet<Book> hs = new HashSet<Book>();
		hs.add(book1);
		hs.add(book2);
		hs.add(book3);
		
		System.out.println("Size of hashSet: "+hs.size());
		
		Iterator<Book> itr = hs.iterator();
		
		while(itr.hasNext())
		{
			Book obj = itr.next();
			System.out.println("Object: "+obj);
		}
	}
}

class Book
{
	String title;
	String author;
	int bookNo;
	int edition;
	int noOfPages;
	float price;
	
	public Book(String title, String author, int bookNo, int edition, int noOfPages, float price) {
		super();
		this.title = title;
		this.author = author;
		this.bookNo = bookNo;
		this.edition = edition;
		this.noOfPages = noOfPages;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookNo=" + bookNo + ", edition=" + edition
				+ ", noOfPages=" + noOfPages + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookNo, edition, noOfPages, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Book other = (Book) obj;
		
		return Objects.equals(author, other.author) && bookNo == other.bookNo && edition == other.edition
				&& noOfPages == other.noOfPages && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(title, other.title);
	
		
	}
	
	
	
	
	
	
}