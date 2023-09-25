package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class LjubavniKalkulator {
	
	public static void main(String[] args) {
		
		 Scanner scan = new Scanner(System.in);

	        System.out.println("Unesite prvo ime:");
	        String ime1 = scan.nextLine();

	        System.out.println("Unesite drugo ime:");
	        String ime2 = scan.nextLine();

	        ime1 = ime1.toLowerCase();
	        ime2 = ime2.toLowerCase();

	        String s = ime1 + ime2;
	        System.out.println(s);
	        
	        int[] niz = matricajedan(s);
	        System.out.println(Arrays.toString(niz));
	      

	        int[] razdvojeniNiz = razdvajanje(niz);
	        System.out.println(Arrays.toString(razdvojeniNiz));
	}
	
	
	public static int [] matricajedan(String kombinacija) {
		int[] niz = new int[kombinacija.length()];

        for (int i = 0; i < kombinacija.length(); i++) {
            char z = kombinacija.charAt(i);

            int b = 0;
            for (int j = 0; j < kombinacija.length(); j++) {
                if (kombinacija.charAt(j) == z) {
                    b++;
                }
            }
           
            niz[i] = b;
        }
        
        return niz; 
	}
   
	
		
		
	public static int [] razdvajanje (int[] niz) {
		int b = 0;
		for (int i : niz) {
			if (i >= 10) {
				b++;
			}
	}
		int[] Matrica = new int[niz.length + b];

		for (int i = 0, j = 0; i < niz.length; i++) {
			if (niz[i] < 10) {
				Matrica[j++] = niz[i];
			} else {
				Matrica[j++] = niz[i] / 10;
				Matrica[j++] = niz[i] % 10;
			}
		}
		
		

		return Matrica;
	}
}
