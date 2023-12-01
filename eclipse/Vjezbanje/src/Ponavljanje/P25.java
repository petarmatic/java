package Ponavljanje;

import java.util.Scanner;

public class P25 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Upisi velicinu niza:");
		int velicinaNiza=scan.nextInt();
		
		 int[] niz = new int[velicinaNiza];
		 System.out.println("Unesite elemente niza:");

	    for(int i=0;i<velicinaNiza;i++) {
	    	 niz[i] = scan.nextInt();
	    	
	    }
	    
	    int najveciBroj = pronadiNajveciBroj(niz);

        System.out.println("Najveći broj u nizu je: " + najveciBroj);

	}

	private static int pronadiNajveciBroj(int[] niz) {
		int najveci=niz[0];
		
		for(int i=1;i<niz.length;i++) {
			if (niz[i] > najveci) {
                najveci = niz[i];
            }
		}
		return najveci;
	}

}
