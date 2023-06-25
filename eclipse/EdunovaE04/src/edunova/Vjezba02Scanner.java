package edunova;

import java.util.Scanner;



public class Vjezba02Scanner {

	public static void main(String[] args) {
		// celzius to kelvin
		
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Temperautra u C: ");
	        double celsius = scanner.nextDouble();

	        double kelvin = (celsius + 273.15);

	        System.out.println("Temperautra u Kelvinu : " + kelvin);
		
		
		
	}

	
}
