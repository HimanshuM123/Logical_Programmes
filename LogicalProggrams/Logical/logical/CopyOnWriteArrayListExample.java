package logical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();
		//ArrayList<String> al=new ArrayList<>();
		al.add("ABC");
		al.add("UVW");
		al.add("XYZ");
		Iterator<String> itr = al.iterator();
		al.remove("UVW");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
