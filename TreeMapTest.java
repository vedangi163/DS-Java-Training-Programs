import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//sorts elements based on key 
public class TreeMapTest {
	public static void main(String[] args) {
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		
		tm.put("john", 23);
		tm.put("jonas", 25);
		tm.put("austin", 30);
		
		tm.put("austin", 35);
		for(Map.Entry<String,Integer> entry : tm.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();

			  System.out.println(key + " : " + value);
			}
		

	}
}

