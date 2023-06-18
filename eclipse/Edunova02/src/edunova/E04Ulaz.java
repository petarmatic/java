package edunova;

import javax.swing.JOptionPane;

public class E04Ulaz {

	public static void main(String[] args) {

		String ulazKorisnika = JOptionPane.showInputDialog("Unesi broj");

		int b = Integer.parseInt(ulazKorisnika);

		System.out.println(b);

		// kraće

		int i = Integer.parseInt(JOptionPane.showInputDialog("Unesi Broj"));

	}
}
