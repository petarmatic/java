package edunova;

import javax.swing.JOptionPane;

public class Z02 {

	public static void main(String[] args) {

		int i = Integer.parseInt(JOptionPane.showInputDialog("Prvi broj"));
		int j = Integer.parseInt(JOptionPane.showInputDialog("Drugi broj"));

		System.out.println(i / (float) j);
// ili ovako 
	
		System.out.println(Integer.parseInt(JOptionPane.showInputDialog("PRvi broj"))
				/(float)Integer.parseInt(JOptionPane.showInputDialog("DDrugi broj")));
		
	}

}
