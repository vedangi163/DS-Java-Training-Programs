import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) 
	{
		ChemicalElements ce1 = new ChemicalElements("Hydrogen", 4);
		ChemicalElements ce2 = new ChemicalElements("Calcium", 5);
		ChemicalElements ce3 = new ChemicalElements("Helium", 3);
		ChemicalElements ce4 = new ChemicalElements("Oxygen", 6);
		
	   TreeSet<ChemicalElements> ts = new TreeSet<ChemicalElements>();
	   
	   ts.add(ce1);
	   ts.add(ce2);
	   ts.add(ce3);
	   ts.add(ce4);
	   
	   Iterator<ChemicalElements> iterator = ts.iterator();
	   
	   while(iterator.hasNext())
	   {
		   ChemicalElements ce = iterator.next();
		   System.out.println("Chemical elemets : "+ce);
	   }
	}

}


class ChemicalElements implements Comparable<ChemicalElements>
{
	String atomicName;
	int atomicNo;
	public ChemicalElements(String atomicName, int atomicNo) {
		super();
		this.atomicName = atomicName;
		this.atomicNo = atomicNo;
	}
	
	
	@Override
	public String toString() {
		return "ChemicalElements [atomicName=" + atomicName + ", atomicNo=" + atomicNo + "]";
	}

	
	public int compareTo(ChemicalElements o) {
		return Integer.compare(atomicNo, o.atomicNo);
	}
	
}
