package Ponavljanje;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Unesi ime");
		String ime= scanner.next();
		
		System.out.println("Unesi prezime");
		String prezime=scanner.next();
		
		Student student = new Student(ime, prezime);
		
		int ocjena;
		do {
			System.out.println("Unesi ocjenu(ili -1 za kraj)");
			ocjena=scanner.nextInt();
			if(ocjena !=-1) {
				student.dodajOcjenu(ocjena);
			}
		}while(ocjena != -1);
		
		double prosjek= student.prosjekOcjena();
		System.out.println("Prosjek ocjena za student:" + ime + " "+ prezime + " "
				+ prosjek);
		
		

	}

}
