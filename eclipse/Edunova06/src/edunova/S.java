package edunova;


import java.util.Arrays;
import java.util.Scanner;

public class S {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Unesi prvo ime:");
		String ime1 = scanner.nextLine();

		System.out.println("Unesi drugo ime");
		String ime2 = scanner.nextLine();

		String s = ime1.toLowerCase() + ime2.toLowerCase();
		System.out.println(s);
		int[] niz = new int[ime1.length() + ime2.length()];
		
		int b;
		char z;
		for(int i=0;i<s.length();i++) {
			z=s.charAt(i);
			b=0;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)==z) {
					b++;
				}
			}
			niz[i]=b;
		}
		System.out.println(Arrays.toString(niz));
		int[] zbrojNiza = new int[niz.length / 2 + 1];
		zbrojNiza(niz, zbrojNiza, 0, niz.length - 1, 0);

		System.out.println(Arrays.toString(zbrojNiza));
		int[] razdvojeniNiz = razdvajanje(zbrojNiza);
		System.out.println(Arrays.toString(razdvojeniNiz));
	}
		
		private static void zbrojNiza(int[] ulazniNiz, int[] izlazniNiz, int lijeviIndeks, int desniIndeks, int k) {
			if (lijeviIndeks <= desniIndeks) {
				if (lijeviIndeks == desniIndeks) {
					izlazniNiz[k] = ulazniNiz[lijeviIndeks];
				} else {
					izlazniNiz[k] = ulazniNiz[lijeviIndeks] + ulazniNiz[desniIndeks];
				}
				zbrojNiza(ulazniNiz, izlazniNiz, lijeviIndeks + 1, desniIndeks - 1, k + 1);
			}
		

	}
		
		private static int[] razdvajanje(int[] niz) {
			int b = 0;
			for (int i : niz) {
				if (i < 10) {
					b++;
				}
			}
			int[] matrica = new int[zbrojNiza];
			for (int i = 0, j = 0; i < niz.length; i++) {
				if (niz[i] < 10) {
					matrica[j++] = niz[i];
				} else {
					matrica[j++] = niz[i] / 10;
					matrica[j++] = niz[i] % 10;
				}
			}

			return matrica;
		}
}
