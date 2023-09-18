package Ponavljanje;

public class P18 {

	public static void main(String[] args) {
		int broj = 0;
		int x = 5;
		if (x % 2 != 0) {
			broj++;
		}
		System.out.println("Vrijednost za broj: " + broj);

		int broj1 = 0;
		int y = 5;
		if (y % 4 == 0) {
			broj1++;
		} else if (y % 4 == 1) {
			broj1 += 17;
		} else if (y % 4 == 2) {
			broj1 += 6;
		} else {
			broj1 += 14;
		}
		System.out.println(broj1 + "je rezultat");

		long[] polje = { 1, 4, 7, 11, 13, 4, 21 };
		boolean imaDuplikata = false;
		for (int i = 0; i < polje.length; i++) {
			long element1 = polje[i];
			for (int j = i + 1; j < polje.length; j++) {
				long element2 = polje[j];
				if (i == j) {
					continue;

				}
				if (element1 == element2) {
					imaDuplikata = true;
					break;
				}
			}
			if (imaDuplikata) {
				break;
			}
		}
		System.out.println("Pronađeni su duplikati: " + imaDuplikata);
	}
}