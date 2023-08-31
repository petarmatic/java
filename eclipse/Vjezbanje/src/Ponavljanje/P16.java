package Ponavljanje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class P16 {
	public static void main(String[] args) {

		// unsorted int array:[4,2,0,5,9]

		// to sort arrays: Arrays.sort()

		// to sort collection implementations:  Collection.sort()
		
		//to sort from greatest to least:   Collection.reverseOrder()
		
		
		Integer arr[]= new Integer[] {4,2,0,5,9};
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Character> list=new ArrayList<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		

	}
}
