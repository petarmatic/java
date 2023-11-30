package edunova;

import javax.swing.JOptionPane;

public class Z01 {

	public static void main(String[] args) {
		// Program osigurava učitanje broja od korisnika
		// broj je u rasponu 20 do 50 i nije 30
		// koristiti while petlju
		
		
		int broj;
		do {
			broj=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj"));
			if(broj>=20 && broj <=50 & broj!=30) {
				break;
			}
			JOptionPane.showMessageDialog(null, "nije dobro");
		}while(true);
		System.out.println(broj);
		
	}

}
