package edunova;

import javax.swing.JOptionPane;

public class LjubavniKalkulator{
public static void main(String[] args) {

	String ime1 = JOptionPane.showInputDialog("Unesi svoje ime");
	String ime2 = JOptionPane.showInputDialog("Unesi ime svoje simpatije");
	String konacno = "";

	for (int i : analiza(stvaranjeMatrice(ime1, ime2))) {
		konacno += i;
	}
	
	System.out.println(ime1 + " i " + ime2 + " se vole " + konacno + "% !");
	

}

static int[] stvaranjeMatrice(String ime1, String ime2) {

	String manji = ime1.length() < ime2.length() ? ime1.toLowerCase() : ime2.toLowerCase();
	String veci = ime1.length() < ime2.length() ? ime2.toLowerCase() : ime1.toLowerCase();

	String ime = manji + veci;

	int[] imena = new int[ime.length()];

	for (int i = 0; i < ime.length(); i++) {
		for (int j = 0; j < ime.length(); j++) {
			if (ime.charAt(i) == ime.charAt(j)) {
				imena[i] += 1;
			}
		}
	}
	
	imena = razdvajanjeDvoznamenkastih(imena);

	int[] matrica = new int[veci.length()];

	for (int i = 0; i < matrica.length; i++) {
		if (manji.toCharArray().length > i) {
			matrica[i] += imena[i];
		}

		if (veci.toCharArray().length > i) {
			matrica[i] += imena[imena.length - 1 - i];
		}
	}
	return razdvajanjeDvoznamenkastih(matrica);
}

static int[] analiza(int[] niz) {

	if (niz.length <= 2) {
		return niz;
	} else {
		if (niz.length % 2 == 0) {
			int[] zbroj = new int[niz.length / 2];

			for (int i = 0; i < niz.length; i++) {

				if (i < niz.length - 1 - i) {
					zbroj[i] = niz[i] + niz[niz.length - 1 - i];
				}

			}

			return analiza(razdvajanjeDvoznamenkastih(zbroj));
//
		} else {
			int[] zbroj = new int[(niz.length / 2) + 1];

			for (int i = 0; i < niz.length; i++) {

				if (i < niz.length - 1 - i) {

					zbroj[i] = niz[i] + niz[niz.length - 1 - i];
				}

				if (niz[i] == niz[niz.length - 1 - i]) {
					zbroj[i] = niz[i];
					break;
				}

			}

			return analiza(razdvajanjeDvoznamenkastih(zbroj));

		}

	}

}

static int[] razdvajanjeDvoznamenkastih(int[] niz) {

	int brojac = 0;
	for (int i : niz) {
		if (i >= 10) {
			brojac++;
		}
	}

	int[] pomocnaMatrica = new int[niz.length + brojac];

	for (int i = 0, j = 0; i < niz.length; i++) {
		if (niz[i] < 10) {
			pomocnaMatrica[j++] = niz[i];
		} else {
			pomocnaMatrica[j++] = niz[i] / 10;
			pomocnaMatrica[j++] = niz[i] % 10;
		}
	}

	return pomocnaMatrica;
}

}

