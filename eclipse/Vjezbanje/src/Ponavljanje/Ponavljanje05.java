package Ponavljanje;

import java.util.Scanner;

public class Ponavljanje05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesi tekst");
		String tekst = scanner.nextLine();
		
		if(jePalidrom(tekst)) {
			System.out.println("Bravo");
		}else {
			System.out.println("zašto");
			
		}
	}

	private static boolean jePalidrom(String tekst) {
		tekst = tekst.replaceAll("[^a-zA-Z]", "").toLowerCase();
		int lijevo=0;
		int desno= tekst.length()-1;
		while(lijevo<desno) {
			if(tekst.charAt(lijevo) !=tekst.charAt(desno))
				return false;
		}
		lijevo++;
		desno--;
			
		return true;
	}

}
