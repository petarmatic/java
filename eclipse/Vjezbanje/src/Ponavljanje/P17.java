package Ponavljanje;

import java.util.Scanner;


public class P17 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Unesi temperaturu");
		double temperatura= scan.nextDouble();
		
		System.out.println("Želite li pretvoriti temperaturu u Celzijuse (C) ili Fahrenheit (F)?");
		String odabir=scan.next();
		
		double rezultat;
		
		if(odabir.equalsIgnoreCase("C")) {
			rezultat=(temperatura-32)/1.8;
			System.out.println("Temperatura u C je: " + rezultat);
		}else if(odabir.equalsIgnoreCase("F")) {
			rezultat=(temperatura*1.8)+32;
			System.out.println("Temperatura u F je: " + rezultat);
		} else { System.out.println("Pogrešan unos. Molimo vas da odaberete C ili F.");
        }

	}

}
