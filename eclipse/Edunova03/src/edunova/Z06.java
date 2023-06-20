package edunova;

import javax.swing.JOptionPane;

public class Z06 {
	public static void main(String[] args) {
		// program unosi broj između 
				// 1 i 999
				// U slučaju da je izvan tog raspona
				// ispisati grešku i prekinuti program
				// Program ispisuje 1. znamenku upisanog broja
				
		
		int broj=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj"));
		
		if (broj<1 || broj>999) { 
			System.out.println(broj + "greška");
			System.exit(0);
			
		}else {
		  String brojevi=Integer.toString(broj);
		  char brojZnak[]=brojevi.toCharArray();
		  System.out.println(brojZnak[0]);
		}
		
		
				// -5 greška
				// 1067 greška
				// 456 4
				// 6 6
				// 89 8
		
	
	
		int pb=Integer.parseInt(JOptionPane.showInputDialog("Prvi broj"));
		int db=Integer.parseInt(JOptionPane.showInputDialog("Drugi broj"));
		
		if(pb%2==0 && db%2==0) {
			System.out.println(pb+db);
		} else {
			System.out.println(pb-db); 
		}
		
		System.out.println((pb%2==0 && db%2==0) ? (pb+db) : (pb-db));
			
			
			// Program unosi 2 broja
				// Ako su oba broja parni
				// ispisuje njihov zbroj
				// inače ispisuje njihovu razliku

	}

}
