package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class Ljubavni {
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

        int[] niz = matrica1(s);
        System.out.println(Arrays.toString(niz));

        int[] zbrojeniNiz = zbrojiLijeveIDesneBrojeve(niz);
        System.out.println(Arrays.toString(zbrojeniNiz));

        scan.close(); 
    }

    public static int[] matrica1(String s) {
        int[] niz = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char z = s.charAt(i);
            int b = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == z) {
                    b++;
                }
            }
            niz[i] = b;
        }
        return niz;
    }

    public static int[] zbrojiLijeveIDesneBrojeve(int[] niz) {
        int duljina = niz.length;
        int[] zbrojeniNiz = new int[duljina / 2 + 1]; // Dodatni element ako je niz neparne duljine
        int sredina = duljina / 2;

        for (int i = 0; i <= sredina; i++) {
            int lijevi = niz[i];
            int desni = niz[duljina - 1 - i];

            if (i == sredina && duljina % 2 != 0) {
                // Ako je u sredini ostao jedan broj (za neparne duljine)
                zbrojeniNiz[i] = lijevi;
            } else {
                zbrojeniNiz[i] = lijevi + desni;
            }
        }

        return zbrojeniNiz;
    }
}
