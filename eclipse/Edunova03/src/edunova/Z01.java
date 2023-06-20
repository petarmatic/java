package edunova;

import javax.swing.JOptionPane;

public class Z01 {

	public static void main(String[] args) {
//		/ Korisnik unosi cijeli broj
		// Za broj manji od 10
		// ispisuje se Osijek
		// inače se ispisuje Donji Miholjac
		
		int broj=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj"));
		
		if (broj<10) {
			System.out.println("Osijek");
		}else if (broj==10) {
			System.out.println("Donji Miholjac");
		}
				

	}

}
