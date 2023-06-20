package edunova;

import javax.swing.JOptionPane;

public class Z02 {

	public static void main(String[] args) {
		//  Korisnik unosi cijeli broj
		// Program ispisuje da li je 
		// paran ili nije
		
		int broj=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj"));
		   if(broj%2==0) {
			   System.out.println("Paran");
		   } else {
			   System.out.println("Neparan");
	        }

	
	}

}
