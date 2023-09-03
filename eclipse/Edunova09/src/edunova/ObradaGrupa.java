package edunova;

import java.util.ArrayList;
import java.util.List;

import edunova.model.Grupa;
import edunova.model.Predavac;
import edunova.model.Polaznik;
import edunova.model.Smjer;

public class ObradaGrupa {
	
	private List<Grupa> grupe;
	private Izbornik izbornik;
	
	public ObradaGrupa(Izbornik izbornik) {
		this();
		this.izbornik = izbornik;
	}
	
	public ObradaGrupa() {
		grupe = new ArrayList<>();
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
		switch(Pomocno.unosRasponBroja("Odaberi stavku grupa izbornika: ",
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledGrupa();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeGrupa();
			prikaziIzbornik();
			break;
		case 3:
			promjenaGrupa();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeGrupa();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}
	}

	private void pregledGrupa() {
		System.out.println("------------------");
		System.out.println("---- Grupe ----");
		System.out.println("------------------");
		int b=1;
		for(Grupa g : grupe) {
			System.out.println(b++ + ". " + g.getNaziv());
		}
		System.out.println("------------------");
		
	}

	private void dodavanjeGrupa() {
		Grupa g = new Grupa();
		g.setSifra(Pomocno.unosRasponBroja("Unesi šifru grupe: ","Pozitivan broj",
				1,Integer.MAX_VALUE));
		g.setNaziv(Pomocno.unosString("Unesi naziv grupe: ","Naziv obavezan"));
		g.setSmjer(postaviSmjer());
		g.setMaxpolaznika(Pomocno.unosRasponBroja("Unesi maksimalno polaznika grupe: ","Pozitivan broj (5-25)",
				5,25));
		g.setPredavac(postaviPredavaca());
		g.setDatumPocetka(Pomocno.unosDatum("Unesi datum početka"));
		g.setPolaznici(postaviPolaznike());
		grupe.add(g);
		
	}
	
	private List<Polaznik> postaviPolaznike() {
		List<Polaznik> polaznici = new ArrayList<>();
		while(Pomocno.unosBoolean("Želite li dodati polaznika? (da ili bilo što za ne)")) {
			polaznici.add(postaviPolaznika());
		}
		return polaznici;
	}
	
	private Polaznik postaviPolaznika() {
		izbornik.getObradaPolaznik().pregledPolaznika();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj polaznika: ","Nije dobar odabir",1,izbornik.getObradaPolaznik().getPolaznici().size());
		return izbornik.getObradaPolaznik().getPolaznici().get(index-1);
	}

	private Smjer postaviSmjer() {
		izbornik.getObradaSmjer().pregledSmjerova();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj smjera: ","Nije dobar odabir",1,izbornik.getObradaSmjer().getSmjerovi().size());
		return izbornik.getObradaSmjer().getSmjerovi().get(index-1);
	}
	
	private Predavac postaviPredavaca() {
		izbornik.getObradaPredavac().pregledPredavaca();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj predavača: ","Nije dobar odabir",1,izbornik.getObradaPredavac().getPredavaci().size());
		return izbornik.getObradaPredavac().getPredavaci().get(index-1);
	}

	private void promjenaGrupa() {
		pregledGrupa();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj grupe: ","Nije dobar odabir",1,grupe.size());
		Grupa g = grupe.get(index-1);
		g.setSifra(Pomocno.unosRasponBroja("Unesi šifru grupe (" + g.getSifra() + "): " ,"Pozitivan broj",
				1,Integer.MAX_VALUE));
		g.setNaziv(Pomocno.unosString("Unesi naziv grupe (" + g.getNaziv() + "): ","Naziv obavezan"));
		g.setMaxpolaznika(Pomocno.unosRasponBroja("Unesi maksimalno polaznika grupe: ","Pozitivan broj (5-25)",
				5,25));
		System.out.println("Trenutni smjer: " + g.getSmjer().getNaziv());
		g.setSmjer(postaviSmjer());
		System.out.println("Trenutni predavač: " + g.getPredavac());
		g.setPredavac(postaviPredavaca());
		g.setDatumPocetka(Pomocno.unosDatum("Unesi datum početka"));
		System.out.println("----------------------------");
		System.out.println("---- Trenutni polaznici ----");
		System.out.println("----------------------------");
		int b=1;
		for(Polaznik p : g.getPolaznici()) {
			System.out.println(b++ + ". " + p);
		}
		System.out.println("-------------------");
		g.setPolaznici(postaviPolaznike());
		
	}


	private void brisanjeGrupa() {
		pregledGrupa();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj grupaa: ","Nije dobar odabir",1,grupe.size());
		grupe.remove(index-1);
		
	}

}
