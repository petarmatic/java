package Ponavljanje;

import java.util.Scanner;

public class Ponavljanje06 {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Unesi duljinu niza;");
		int duljina= scanner.nextInt();
		
		int [] niz= new int[duljina];
		
		System.out.println("Unesi vrijednosti niza:");
		
		for(int i=0;i< duljina;i++) {
			niz[i]=scanner.nextInt();
		}
		if (jeAritmetickiNiz(niz)) {
            System.out.println("Zadani niz je aritmetički niz.");
        } else {
            System.out.println("Zadani niz nije aritmetički niz.");
        }
    
		
	}

	private static boolean jeAritmetickiNiz(int[] niz) {
		if(niz.length<=2) {
		return true;
		}
		
		int razlika=niz[1]-niz[0];
		for(int i=2;i<=niz.length;i++) {
			if(niz[i]-niz[i-1] !=razlika) {
				return false;
			}
		}
		return true;
	}

}
