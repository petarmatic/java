package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class Fgdgdf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Unesi prvo ime:");
		String ime1 = scanner.nextLine();

		System.out.println("Unesi drugo ime:");
		String ime2 = scanner.nextLine();

		String s = ime1.toLowerCase() + ime2.toLowerCase();
		System.out.println(s);

		int[] niz = new int[ime1.length() + ime2.length()];
		System.out.println(Arrays.toString(niz));

		int b;
		char z;
		for (int i = 0; i < s.length(); i++) {
			z = s.charAt(i);
			b = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == z) {
					b++;
				}
			}
			niz[i] = b;
		}
	}
		private static void createZbrojNiza(int[] niz) {
		int lijeviIndeks = 0;
		int desniIndeks = niz.length - 1;
		int[] zbrojNiza = new int[niz.length / 2 + 1];
		int k = 0;

		while (lijeviIndeks <= desniIndeks) {
			if (lijeviIndeks == desniIndeks) {
				zbrojNiza[k++] = Math.min(niz[lijeviIndeks], 100);
			} else {
				int zbroj = niz[lijeviIndeks] + niz[desniIndeks];
				zbrojNiza[k++] = Math.min(zbroj, 100);
			}
			lijeviIndeks++;
			desniIndeks--;
		}
		// Rastavi dvoznamenkaste brojeve u jednoznamenkaste
        for (int i = 0; i < zbrojNiza.length; i++) {
            if (zbrojNiza[i] >= 10) {
                int prviZnamenka = zbrojNiza[i] / 10;
                int drugiZnamenka = zbrojNiza[i] % 10;

                zbrojNiza[i] = prviZnamenka;
                if (i == zbrojNiza.length - 1) {
                    // Ako smo došli do zadnjeg elementa, dodaj drugu znamenku kao novi element
                    zbrojNiza = Arrays.copyOf(zbrojNiza, zbrojNiza.length + 1);
                    zbrojNiza[i + 1] = drugiZnamenka;
                } else {
                    // Inače, dodaj drugu znamenku iza sljedećeg elementa
                    zbrojNiza[i + 1] += drugiZnamenka;
                }
            }
        }

		System.out.println(Arrays.toString(zbrojNiza));
		
		
		
	}
}