package autokuca;

import java.util.ArrayList;

import java.util.List;

import autokuca.model.ProdajnoMjesto;
import autokuca.model.Prodavac;

public class ObradaProdajnoMjesto {

	private List<ProdajnoMjesto> prodajnoMjesto;
	private Izbornik izbornik;

	public List<ProdajnoMjesto> getProdajnoMjesto() {
		return prodajnoMjesto;
	}

	public ObradaProdajnoMjesto(Izbornik izbornik) {
		this();
		this.izbornik = izbornik;
		testniPodaci();
	}

	public ObradaProdajnoMjesto() {
		prodajnoMjesto= new ArrayList<ProdajnoMjesto>();
	}

	private void testniPodaci() {

		Prodavac testProdavac = new Prodavac(5, "Marko", "Marković"); // Kreiramo novog prodavca
		izbornik.getObradaProdavac().getProdavaci().add(testProdavac); // Dodajemo prodavca u listu prodavaca

		prodajnoMjesto.add(new ProdajnoMjesto(1, "Adresa 1", "Prodajno Mjesto 1", testProdavac)); // Dodajemo prodavca u
																									// prodajno mjesto

		prodajnoMjesto.add(new ProdajnoMjesto(1, "dd", "fdd",
				izbornik.getObradaProdavac().getProdavaci().get(1)));

	}

	public void prikaziIzbornik() {
		System.out.println("\nProdajno Mjesto izbornik");
		System.out.println("1.Pregled postojećih prodajnih mjesta");
		System.out.println("2.Unos novih prodajnih mjesta");
		System.out.println("3.Promjena postojećih prodajnih mjesta");
		System.out.println("4.Brisanje postojećih prodajnih mjesta");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku izbornika", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledProdajnihMjesta();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeProdajnihMjesta();
			prikaziIzbornik();
			break;
		case 3:
			promjenaProdajnihMjesta();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeProdajnihMjesta();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}

	}

	private void brisanjeProdajnihMjesta() {
		if (prodajnoMjesto.isEmpty()) {
			System.out.println("Prazno");
		} else {
			pregledProdajnihMjesta();
			int i = Pomocno.unosRasponBroja("Odaberi redni broj prodajnog mjesta", "Odabir nije dobar", 1,
					prodajnoMjesto.size());
			prodajnoMjesto.remove(i - 1);
		}

	}

	private void promjenaProdajnihMjesta() {
		if (prodajnoMjesto.isEmpty()) {
			System.out.println("Nema prodajnih mjesta");
		} else {
			pregledProdajnihMjesta();
			int i = Pomocno.unosRasponBroja("Odaberite redni broj prodajnog mjesta", "Odabir nije dobar", 1,
					prodajnoMjesto.size());
			ProdajnoMjesto pm = prodajnoMjesto.get(i - 1);
			pm.setSifra(Pomocno.unosRasponBroja("Unesite šifru prodajnog mjesta", "Odabir nije dobar", 1,
					Integer.MAX_VALUE));
			pm.setAdresa(Pomocno.unosString("Unesite adresu", "Adresa obavezno"));
			pm.setNaziv(Pomocno.unosString("Unesite naziv", "Naziv obavezno"));

			System.out.println("Trenutni prodavac: " + pm.getProdavac());
			pm.setProdavac(postaviProdavaca());

			System.out.println("Promjene spremljene.");
		}

	}

	private void dodavanjeProdajnihMjesta() {
		ProdajnoMjesto pm = new ProdajnoMjesto();
		pm.setSifra(Pomocno.unosRasponBroja("Unesi sifru smjera", "sifra nije dobra", 1, Integer.MAX_VALUE));
		pm.setAdresa(Pomocno.unosString("Unesi adresu", "Adresa obavezno"));
		pm.setNaziv(Pomocno.unosString("Unesi naziv", "Naziv obavezno"));
		pm.setProdavac(postaviProdavaca());
		prodajnoMjesto.add(pm);

	}

	private Prodavac postaviProdavaca() {
		izbornik.getObradaProdavac().pregledProdavaca();
		int i = Pomocno.unosRasponBroja("Odaberi redni broj prodavača", "Odabir nije dobar", 1,
				izbornik.getObradaProdavac().getProdavaci().size());
		return izbornik.getObradaProdavac().getProdavaci().get(i - 1);
	}

	public void pregledProdajnihMjesta() {
		 if (prodajnoMjesto.isEmpty()) {
		        System.out.println("Nema prodajnih mjesta.");
		        return;
		    }

		    int b = 1;
		    System.out.println("\nPregled prodajnih mjesta:");
		    for (ProdajnoMjesto pm : prodajnoMjesto) {
		        System.out.println(b + ". Šifra prodajnog mjesta: " + pm.getSifra());
		        System.out.println("   Adresa: " + pm.getAdresa());
		        System.out.println("   Naziv: " + pm.getNaziv());
		        System.out.println("   Prodavač: " + pm.getProdavac().getIme() + " " + pm.getProdavac().getPrezime());
		        b++;
		    
		    }

	}

}
