package edunova;

import javax.swing.JOptionPane;

public class Z03 {

	public static void main(String[] args) {
		
		String mjesto=JOptionPane.showInputDialog("unesi mjesto");
		int g = Integer.parseInt(JOptionPane.showInputDialog("Unesi godine"));
		
		System.out.println("Ja imam " + g + "godine i dolazim iz " + mjesto + "." );
	}

}
