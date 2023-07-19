package autokuca;

import java.util.Scanner;

public class Izbornik {
	private ObradaProdavac obradaProdavac;
	
	public Izbornik() {
		obradaProdavac= new ObradaProdavac();
		Pomocno.ulaz= new Scanner(System.in);
		prikaziIzbornik();
		Pomocno.ulaz.close();
		
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
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika",
				"Obavezno 1-6", 1, 6)) {
		case 1:
			obradaProdavac.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 6:
			break;
		    }
		     
		
	}

	public ObradaProdavac getObradaProdavac() {
		return obradaProdavac;
	}

}
