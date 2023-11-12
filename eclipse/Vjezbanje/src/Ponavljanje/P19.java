package Ponavljanje;

import java.util.ArrayList;
import java.util.Collections;




public class P19{
	public static void main(String[] args) {
		
		ArrayList<Integer>lista= new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(5);
		lista.add(6);
		
		int position=Collections.binarySearch(lista,5 );
		System.out.println("The position of 5 is:" + position);
		
		
	

	
	
			ArrayList<Integer> numbers = new ArrayList<>();
	        numbers.add(1);
	        numbers.add(2);
	        numbers.add(3);
	        numbers.add(2);
	        System.out.println("New task");
	        System.out.println("ArrayList1: " + numbers);
	        
	        int count = Collections.frequency(numbers, 2);
	        System.out.println("Count of 2: " + count);
	        
	        ArrayList<Integer> newNumbers = new ArrayList<>();
	        newNumbers.add(5);
	        newNumbers.add(6);
	        System.out.println("ArrayList2: " + newNumbers);
	        boolean value = Collections.disjoint(numbers, newNumbers);
	        System.out.println("Two lists are disjoint: " + value);
	        
	        int min = Collections.min(numbers);
	        System.out.println("Minimum Element: " + min);

	        
	        int max = Collections.max(numbers);
	        System.out.println("Maximum Element: " + max);
	    }
		
	}
	
	

        
	

	