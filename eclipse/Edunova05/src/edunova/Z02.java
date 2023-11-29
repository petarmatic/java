package edunova;

import javax.swing.JOptionPane;

public class Z02 {

	public static void main(String[] args) {
		// Program unosi od korisnika dva broja
		// između 20 i 80
		// Program ispisuje sve neparne brojeve
		// između unesenih brojeva unazad (od većeg prema manjem)
		// koristiti do while petlju

		
		int prviBroj;
		int drugiBroj;
		
		do{
			prviBroj=Integer.parseInt(JOptionPane.showInputDialog("Unesi prvi broj"));
			
			if(prviBroj>=20 && prviBroj<=80) {
				break;
			} else {
                JOptionPane.showMessageDialog(null, "Broj nije valjan! Unesite broj između 20 i 80.");
            }
		}while(true);
		
		
		
		do{
			drugiBroj=Integer.parseInt(JOptionPane.showInputDialog("Unesi drugi broj"));
			
			if(drugiBroj>=20 && drugiBroj<=80) {
				break;
			} else {
                JOptionPane.showMessageDialog(null, "Broj nije valjan! Unesite broj između 20 i 80.");
            }
		}while(true);
		
		int manji=prviBroj<drugiBroj ? prviBroj : drugiBroj;
		int veci=prviBroj<drugiBroj ? drugiBroj : prviBroj;
		
		//int manji = Math.min(prviBroj, drugiBroj);
        //int veci = Math.max(prviBroj, drugiBroj);
		
		int broj=veci;
		do {
			if(broj%2==1) {
				System.out.println(broj);
			
            }
		}while(--broj>=manji);
		
	}
			
		
		
		

}
