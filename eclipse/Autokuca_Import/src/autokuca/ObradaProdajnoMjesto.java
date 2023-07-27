package autokuca;

import java.util.ArrayList;
import java.util.List;

import autokuca.model.ProdajnoMjesto;
import autokuca.model.Prodavac;

public class ObradaProdajnoMjesto {
	
	private List<ProdajnoMjesto> prodajnoMjesto;
	


	public List<ProdajnoMjesto> getProdajnoMjesto() {
		return prodajnoMjesto;
	}


	private Izbornik izbornik;
	
	public ObradaProdajnoMjesto() {
		prodajnoMjesto= new ArrayList<>();	}
	
	
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
		switch (Pomocno.unosRasponBroja("Odaberi stavku izbornika",
				"Odabir mora biti 1-5", 1, 5)) {
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
		pregledProdajnihMjesta();
		int i= Pomocno.unosRasponBroja("Odaberi redni broj prodajnog mjesta", 
				"Odabir nije dobar", 1, prodajnoMjesto.size());
		prodajnoMjesto.remove(i-1);
		
	}


	private void promjenaProdajnihMjesta() {
		pregledProdajnihMjesta();
		int i= Pomocno.unosRasponBroja("Odabeir redni broj prodajnog mjesta"
				, "Odabir nije dobar", 1, prodajnoMjesto.size());
		ProdajnoMjesto pm= prodajnoMjesto.get(i-1);
		pm.setSifra(Pomocno.unosRasponBroja("Unesi sifru prodajnog mjesta",
				"Odabir nije dobar", 1, Integer.MAX_VALUE));
		pm.setAdresa(Pomocno.unosString("Unesi adresu", "Adresa obavezno"));
		pm.setNaziv(Pomocno.unosString("Unesi naziv", "Naziv obavezno"));
		pm.setProdavac(pm);
		System.out.println();
		int b=1;
		for(Prodavac p : p) {
			System.out.println(b++ + ". "+ p);
		}
		System.out.println();
		pm.setProdavac(postaviProdavaca());
		
	}


	private void dodavanjeProdajnihMjesta() {
		ProdajnoMjesto pm = new ProdajnoMjesto();
		pm.setAdresa(Pomocno.unosString("Unesi adresu", "Adresa obavezno"));
		pm.setNaziv(Pomocno.unosString("Unesi naziv", "Naziv obavezno"));
		pm.setProdavac(postaviProdavaca());
		prodajnoMjesto.add(pm);

		
	}


	private Prodavac postaviProdavaca() {
		izbornik.getObradaProdavac().pregledProdavaca();
		int i= Pomocno.unosRasponBroja("Odaberi redni broj prodavača",
				"Odabir nije dobar", 1,izbornik.getObradaProdavac().getProdavaci().size());
		return izbornik.getObradaProdavac().getProdavaci().get(i-1);
	}


	public void pregledProdajnihMjesta() {
		int b=1;
		System.out.println();
		for(ProdajnoMjesto pm: prodajnoMjesto)
			System.out.println(b++ + ". "+ pm);
		System.out.println();
		
	}
	
	
	
	
}
