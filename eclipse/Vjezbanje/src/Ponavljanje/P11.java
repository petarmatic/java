package Ponavljanje;

import java.util.Scanner;

public class P11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesi prvi broj");
		double broj1 = scanner.nextDouble();
		System.out.println("Unesite operaciju (+, -, *, /): ");
		char operacija = scanner.next().charAt(0);
		System.out.println("Unesi drugi broj");
		double broj2 = scanner.nextDouble();
		double rezultat = 0.0;

		switch (operacija) {
		case ('+'):
			rezultat = broj1 + broj2;
			break;
		case ('-'):
			rezultat = broj1 - broj2;
			break;
		case ('*'):
			rezultat = broj1 * broj2;
			break;
		case ('/'):
			if (broj1 == 0 || broj2 == 0) {
				System.out.println("Dijeljenje s nulom nije dopušteno");
				return;

			} else {
				rezultat = broj1 / broj2;

			}
			break;
		default:
			System.out.println("Nepoznata operacija");
			return;
		}
		System.out.println("Rezulatat" + rezultat);
	}

}
