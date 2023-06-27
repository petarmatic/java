package edunova;

import javax.swing.JOptionPane;

public class Z02 {

	public static void main(String[] args) {
		// Program unosi od korisnika dva broja
		// između 20 i 80
		// Program ispisuje sve neparne brojeve
		// između unesenih brojeva unazad (od većeg prema manjem)
		// koristiti do while petlju

		int prvi;
		do {
			prvi = Integer.parseInt(JOptionPane.showInputDialog("unesi prvi broj"));
			if (prvi >= 20 && prvi <= 80)
				;
			{
				break;
			}

		} while (true);

		int drugi;
		do {
			drugi = Integer.parseInt(JOptionPane.showInputDialog("Unesi drugi broj"));
			if (drugi >= 20 && drugi <= 80)
				;
			{
				break;
			}

		} while (true);
		
		
		int manji= prvi<drugi ? prvi:drugi;
		int veci= prvi>drugi ? prvi:drugi;
		
		int broj=veci;
		
		do {
			if(broj%2==1) {
				System.out.println(broj);
			}
		


	} while(--broj>=manji);
}
}
