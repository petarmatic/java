package edunova;

import javax.swing.JOptionPane;

public class Z05 {

	public static void main(String[] args) {
		// Za upisana 3 cijela broja
		// program ispisuje najveći
		// pretpostavka je da su sva tri broja različita
		
		int p=Integer.parseInt(JOptionPane.showInputDialog("Prvi broj"));
		int d=Integer.parseInt(JOptionPane.showInputDialog("Drugi broj"));
		int t=Integer.parseInt(JOptionPane.showInputDialog("Treći broj"));
		
		if(p>d && p>t) {
			System.out.println(p);
		}else if (p<d && d>t) {
			System.out.println(d);
		}else if(p<d && d<t) {
			System.out.println(t);
		}
	}

}
