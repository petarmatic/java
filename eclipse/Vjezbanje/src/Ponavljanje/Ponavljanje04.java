package Ponavljanje;

import java.util.Scanner;

public class Ponavljanje04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesi tekst");
		String tekst = scanner.nextLine();

		
		int brojSamoglasnika=0;
		for(int i=0;i<tekst.length();i++) {
			char znak=tekst.charAt(i);
			if(jeSamoglasnik(znak)) {
				brojSamoglasnika++;
			}
		}
		System.out.println("Ima"+ brojSamoglasnika);
	}

	private static boolean jeSamoglasnik(char c) {
		Character.toLowerCase(c);
		
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
