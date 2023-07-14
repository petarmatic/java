package edunova;

import java.util.ArrayList;
import java.util.List;

import edunova.model.Grupa;
import edunova.model.Smjer;

public class ObradaGrupa {
	
	private List<Grupa> grupe;
	private Izbornik izbornik;
	public ObradaGrupa(Izbornik izbornik) {
		this();
		this.izbornik = izbornik;
	}
	
	public ObradaGrupa() {
		grupe= new ArrayList<>();
	}
	
	public void prikaziIzbornik() {
		System.out.println("\nGrupa izbornik");
		System.out.println("1. Pregled postojećih grupa");
		System.out.println("2. Unos nove grupe");
		System.out.println("3. Promjena postojeće grupe");
		System.out.println("4. Brisanje postojeće grupe");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku izbornika",
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledGrupe();
			prikaziIzbornik();
			break;
		case 2:
			pregledGrupe();
			dodavanjeGrupe();
			break;
		
		case 5:
			break;
		}
		
	
	}

	private void dodavanjeGrupe() {
		Grupa g = new Grupa();
		g.setSifra(Pomocno.unosRasponBroja("Unesi sifru grupe", "Sifra obavezno", 1, Integer.MAX_VALUE));
		g.setNaziv(Pomocno.unosString("Unesi ime grupe", "Naziv obavezno"));
		g.setSmjer(postaviSmjer());
		
	}

	private Smjer postaviSmjer() {
		izbornik.get
		
		
	}

	private void pregledGrupe() {
		System.out.println("------------------");
		System.out.println("---- Grupe ----");
		System.out.println("------------------");
		int b=1;
		for(Grupa g:grupe)
			System.out.println(b++ + ". "+ g);
		System.out.println("------------------");
	}
	


}
