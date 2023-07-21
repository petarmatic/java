package autokuca;

import java.util.ArrayList;
import java.util.List;

import autokuca.model.Kupac;
import autokuca.model.Prodavac;
import autokuca.model.Racun;
import autokuca.model.Vozilo;

public class ObradaRacun {
	private List<Racun> racuni;
	private Izbornik izbornik;

	public ObradaRacun() {
		racuni = new ArrayList<>();

	}

	public void prikaziIzbornik() {
		System.out.println("Izbornik računa");
		System.out.println("1. Pregled postojećih računa");
		System.out.println("2. Unos novog računa");
		System.out.println("3. Promjena postojećeg računa");
		System.out.println("4. Brisanje postojećeg računa");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku izbornika", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledRacuna();
			prikaziIzbornik();
			break;
		case 2:
			unosRacuna();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}

	}

	private void unosRacuna() {
		Racun r = new Racun();
		r.setKupac(postaviKupca());
		r.setProdavac(postaviProdavaca());
		r.setVozilo(postaviVozilo());
	}

	private Vozilo postaviVozilo() {
		izbornik.getObradaVozilo().pregledVozila();
		int i= Pomocno.unosRasponBroja("Odaberi redni broj vozila",
				"Odabir nije dobar", 1, izbornik.getObradaVozilo().getVozilo().size());
		return izbornik.getObradaVozilo().getVozilo().get(i-1);
	}

	private Prodavac postaviProdavaca() {
		izbornik.getObradaProdavac().pregledProdavaca();
		int i= Pomocno.unosRasponBroja("Odaberi redni broj prodavaca, "
				 ,"Odabir nije dobar", 1, izbornik.getObradaProdavac().getProdavaci().size());
		return izbornik.getObradaProdavac().getProdavaci().get(i-1);
	}

	private Kupac postaviKupca() {
		izbornik.getObradaKupac().pregledKupca();
		int i = Pomocno.unosRasponBroja("Odaberi redni broj kupca",
				"Odabir nije dobar", 1,izbornik.getObradaKupac().getKupci().size());
		return izbornik.getObradaKupac().getKupci().get(i-1);
}

	private void pregledRacuna() {
		int b = 1;
		for (Racun r : racuni) {
			System.out.println(b++ + "." + r);
		}
		System.out.println();

	}
}
