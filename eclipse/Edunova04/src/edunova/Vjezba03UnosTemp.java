package edunova;

import javax.swing.JOptionPane;

public class Vjezba03UnosTemp {

	public static void main(String[] args) {
		
		
		int i=Integer.parseInt(JOptionPane.showInputDialog("Unesi temp u C:"));
		System.out.println("Temp u K: " + (i+273.15));
		
	}

}
