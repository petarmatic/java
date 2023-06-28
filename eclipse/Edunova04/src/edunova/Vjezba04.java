package edunova;

import javax.swing.JOptionPane;

public class Vjezba04 {
//Učitati riječ (kao string). Ispisati znakove riječi prema uzorku na slici
	

	public static void main(String[] args) {
		String rijec = JOptionPane.showInputDialog("Unesi riječ");
		for (int i = 0; i < rijec.length(); i++) {
		    for (int j = 0; j < rijec.length(); j++) {
		        if (i == j) {
		            System.out.print(rijec.charAt(i));
		        } else {
		            System.out.print(".");
		        }
		    }
		    System.out.println(); 
		}
	
}
}
		

