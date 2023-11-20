package Ponavljanje;

import java.util.Scanner;

// napisati program, korisnik unosi brojeve, pregeldavaju se brojevi, ako je paran i ako je veci od 20, ispisi dovoljan,
//ako je veci od 30 ispisi dobar, ako je veci od 40 ispis vrlo dobar, ako je veci od 50 ispisi odlican
// ako broj nije paran i ako je veci od 20 ispisi neparni oko 20, ako je veci od 30 neparni oko 30, ako je veci od 40 neparni oko 40, ako 
// je veci od 50 neparni oko 50
public class P21 {
	
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("unesi neki broj:");
		int broj=scanner.nextInt();
		
		if (broj % 2 == 0) {
		    if (broj > 50) {
		        System.out.println("Odličan");
		    } else if (broj >= 40) {
		        System.out.println("Vrlo dobar");
		    } else if (broj >= 30) {
		        System.out.println("Dobar");
		    } else if (broj >= 20) {
		        System.out.println("Dovoljan");
		    } else {
		    	System.out.println("Broj je manji od 20");
		    }
		} else {
		    if (broj > 50) {
		        System.out.println("Neparni od 50 pa na više");
		    } else if (broj >= 40) {
		        System.out.println("Neparni oko 40");
		    } else if (broj >= 30) {
		        System.out.println("Neparni oko 30");
		    } else if (broj >= 20) {
		        System.out.println("Neparni oko 20");
		    } else {
		        System.out.println("Neparni manji od 20");
		    }
		}
		
	}

}
