package autokuca;

import java.util.Scanner;

public class Izbornik {
	
	public Izbornik() {
		prikaziIzbornik();
		Pomocno.ulaz= new Scanner(System.in);
		
	}
	
	private void prikaziIzbornik() {
		System.out.println("Glavni izbornik");
		System.out.println("1.Prodavač");
		System.out.println("2.Prodajno mjesto");
		System.out.println("3.Vozilo");
		System.out.println("4.Kupac");
		System.out.println("5.Račun");
		System.out.println("6.Izlaz iz programa");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika", "Obavezno 1-6", 1, 6)) {
		case 1:
			
			break;
		case 6:
			break;
		}
		
	}
	
}
