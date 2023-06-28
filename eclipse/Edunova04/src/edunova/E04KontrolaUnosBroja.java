package edunova;

import javax.swing.JOptionPane;

public class E04KontrolaUnosBroja {

	public static void main(String[] args) {
		// program traži od korisnika unos broja
				// između 1 i 10
				
				int broj;
				
				for(;;) {
					broj=Integer.parseInt(JOptionPane.showInputDialog("Broj"));
					if(broj>=1 && broj<=10) {
						break;
					}
					System.out.println("NIJE DOBAR");
				}
				
				System.out.println(broj);

	}

}
