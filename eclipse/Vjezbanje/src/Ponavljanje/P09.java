package Ponavljanje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P09 {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Jabuka");
		lista.add("Banana");
		lista.add("Naranča");

		Iterator<String> iterator = lista.iterator();
		while (iterator.hasNext()) {
		    String element = iterator.next();
		    System.out.println(element);
		}

	}

}
