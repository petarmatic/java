package Ponavljanje;

import java.util.Scanner;

public class P15 {
	
	//Napišite program koji će korisnika pitati za visinu trokuta (broj redova) i zatim ispisati trokut od zvjezdica sa zadatom visinom.
	public static void main(String[] args) {
		
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Unesi željenu visinu redova");
		int visina=scan.nextInt();
		
		for(int red=1;red<=visina;red++) {
			for(int zvjezdica=1;zvjezdica<=red;zvjezdica++)
				System.out.print("*");
			System.out.println();
		
		}
		
	}

}
