package edunova;

import javax.swing.JOptionPane;

public class Z03 {

	public static void main(String[] args) {
		// Program unosi broj elemenata niza cijelih brojeva
		// Unose se brojevi s while petljom u niz
		// ispisuju se uneseni brojevi iz niza s foreach petljom
		
		int velicinaNiza=Integer.parseInt(JOptionPane.showInputDialog("unesi niz"));
		int [] nizBrojeva= new int [velicinaNiza];
		int brojac=0;
		
		
		while(brojac < velicinaNiza) {
			nizBrojeva[brojac++]=Integer.parseInt(JOptionPane.showInputDialog("unesi vrijednosti u niz"));
			
		
	}
		for( int en : nizBrojeva) {
			System.out.println(en);
		}
		}
}
