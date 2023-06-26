package edunova;

import javax.swing.JOptionPane;

public class V05Visekratnik {

	public static void main(String[] args) {
		// Java program za prikaz svih višekratnika broja 3
		
		int i=Integer.parseInt(JOptionPane.showInputDialog("prvi broj"));
		int j=Integer.parseInt(JOptionPane.showInputDialog("drugi broj"));
			
		for(int k=i;k<=j;k++) {
			if(k%3==0)
				System.out.println(k);
			
		}
	}

}
