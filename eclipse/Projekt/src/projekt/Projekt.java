package projekt;

import java.util.Arrays;
import java.util.Scanner;

public class Projekt {
    public static void main(String[] args) {

    	 Scanner scanner = new Scanner(System.in);
         System.out.println("Unesi duzinu niza");
         int duzinaNiza = scanner.nextInt();

         System.out.println("Unesi niz");

         int[] niz = new int[duzinaNiza];

         for (int i = 0; i < duzinaNiza; i++) {
             System.out.print("Element " + (i + 1) + ": ");
             niz[i] = scanner.nextInt();
         }

         // Brojanje elemenata u nizu
         int brojElemenata = niz.length;

         // Pronalaženje najmanjeg i najvećeg broja
         int najmanji = niz[0];
         int najveci = niz[0];

         for (int i = 1; i < duzinaNiza; i++) {
             if (niz[i] < najmanji) {
                 najmanji = niz[i];
             }
             if (niz[i] > najveci) {
                 najveci = niz[i];
             }
         }

         // Ispisivanje rezultata
         System.out.println("Niz: " + Arrays.toString(niz));
         System.out.println("Broj elemenata u nizu: " + brojElemenata);
         System.out.println("Najmanji broj: " + najmanji);
         System.out.println("Najveci broj: " + najveci);

         scanner.close();


       
    }
}
