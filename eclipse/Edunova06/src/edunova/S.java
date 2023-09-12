import java.util.Arrays;
import java.util.Scanner;

public class LK {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite prvo ime:");
        String ime1 = scanner.nextLine();

        System.out.println("Unesite drugo ime:");
        String ime2 = scanner.nextLine();

        ime1 = ime1.toLowerCase();
        ime2 = ime2.toLowerCase();

        String s = ime1 + ime2;

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

        int[] noviNiz = new int[niz.length / 2];

        for (int i = 0; i < noviNiz.length; i++) {
            noviNiz[i] = niz[i] + niz[niz.length - 1 - i];
        }

        System.out.println(Arrays.toString(noviNiz));

    }
}
