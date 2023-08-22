package autokuca;

import java.util.Scanner;

public class Izbornik {
	private ObradaProdavac obradaProdavac;
	private ObradaProdajnoMjesto obradaProdajnoMjesto;
	private ObradaVozilo obradaVozilo;
	private ObradaKupac obradaKupac;
	private ObradaRacun obradaRacun;
	
	public Izbornik() {
		obradaProdavac= new ObradaProdavac(this);
		obradaProdajnoMjesto= new ObradaProdajnoMjesto(this);
		obradaVozilo= new ObradaVozilo(this);
		obradaKupac= new ObradaKupac();
		obradaRacun= new ObradaRacun();
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
		case 2:
			obradaProdajnoMjesto.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 3:
			obradaVozilo.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 4:
			obradaKupac.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 5:
			obradaRacun.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 6:
			break;
		    }
		     
		
	}

	public ObradaProdavac getObradaProdavac() {
		return obradaProdavac;
	}

	public ObradaProdajnoMjesto getObradaProdajnoMjesto() {
		return obradaProdajnoMjesto;
	}

	public ObradaVozilo getObradaVozilo() {
		return obradaVozilo;
	}

	public ObradaKupac getObradaKupac() {
		return obradaKupac;
	}
	
	
	
	

}
