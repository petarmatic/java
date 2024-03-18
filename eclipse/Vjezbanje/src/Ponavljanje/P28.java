package Ponavljanje;

import javax.swing.JOptionPane;

public class P28 {

	public static void main(String[] args) {
		
		int prvi=Integer.parseInt(JOptionPane.showInputDialog("Unesi prvi broj"));
		int drugi=Integer.parseInt(JOptionPane.showInputDialog("Unesi drugi broj"));
		
		
		if(prvi%2==0) {
			System.out.println("prvi je parni");
			
		}else {
			System.out.println("prvi je neparni");
		}
		if(drugi%2==0) {
			System.out.println("Drugi je parni");
		}else {
			System.out.println("Drugi je neparni");
		}

	}

}
