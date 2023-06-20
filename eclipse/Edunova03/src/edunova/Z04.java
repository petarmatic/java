package edunova;

import javax.swing.JOptionPane;

public class Z04 {

	public static void main(String[] args) {
	 // Korisnik unosi dva cijela broj
		// program ispisuje veći
		// 3 i 5 -> 5
		// 5 i 3 -> 5
		// 5 i 5 ->
		
		int pb=Integer.parseInt(JOptionPane.showInputDialog("Prvi broj"));
		int db=Integer.parseInt(JOptionPane.showInputDialog("Drugi broj"));
		
		if (pb>db) {
			System.out.println(pb);
		} else if (pb<db) {
			System.out.println(db);
		}

	}

}
