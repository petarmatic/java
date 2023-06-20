package edunova;

import javax.swing.JOptionPane;

public class Z03 {

	public static void main(String[] args) {
		// Korisnik unosi ime mjesta iz jedne od 4 slavonske županije
		// Za uneseno ime mjesta program ispisuje ime županije
		
		String mjesto=JOptionPane.showInputDialog("mjesto");
		switch (mjesto){
		
		case "Osijek":
			System.out.println("Osjecko-baranjska");
			break;
		case "Vukovar":
			System.out.println("Vukovarsko-srijemska");
			break;
		case "Požega":
			System.out.println("Požeško-slavonska");
			break;
		case "Slavonski brod":
			System.out.println("Slavonsko-posavska");
		}
		
			
		

	}

}
