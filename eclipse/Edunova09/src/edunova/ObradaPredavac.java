package edunova;

import java.util.ArrayList;
import java.util.List;

import edunova.model.Predavac;

public class ObradaPredavac {
	
	private List<Predavac> predavaci;
	
	
	
	public List<Predavac> getPredavaci() {
		return predavaci;
	}

	public ObradaPredavac() {
		predavaci = new ArrayList<>();
		if(Pomocno.dev) {
			testniPodaci();
		}
	}
	
	private void testniPodaci() {
		predavaci.add(new Predavac(1,"Zrinka","Kek","23432321229","zkek@gail.com","HR3424242323423523"));
		predavaci.add(new Predavac(2,"Zvonko","Lakot","23432321228","zlakot@gail.com","HR3424242323423524"));
	}
	
	public void prikaziIzbornik() {
		System.out.println("Predavac izbornik");
		System.out.println("1. Pregled postojećih predavaca");
		System.out.println("2. Unos novog predavaca");
		System.out.println("3. Promjena postojećeg predavaca");
		System.out.println("4. Brisanje postojećeg predavaca");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}
	
	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku predavač izbornika: ",
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledPredavaca();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjePredavaca();
			prikaziIzbornik();
			break;
		case 3:
			promjenaPredavaca();
			prikaziIzbornik();
			break;
		case 4:
			brisanjePredavaca();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}
	}

	public void pregledPredavaca() {
		System.out.println("-------------------");
		System.out.println("---- Predavači ----");
		System.out.println("-------------------");
		int b=1;
		for(Predavac p : predavaci) {
			System.out.println(b++ + ". " + p);
		}
		System.out.println("-------------------");
		
	}

	private void dodavanjePredavaca() {
		Predavac p = new Predavac();
		p.setSifra(Pomocno.unosRasponBroja("Unesi šifru smjera: ","Pozitivan broj",
				1,Integer.MAX_VALUE));
		p.setIme(Pomocno.unosString("Unesi ime predavaca: ","Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime predavaca: ", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email predavaca: ","Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi OIB predavaca: ","OIB obavezno"));
		p.setIban(Pomocno.unosString("Unesi IBAN predavaca: ","BIBANobavezno obavezno"));
		predavaci.add(p);
		
	}
	
	
	private void promjenaPredavaca() {
		pregledPredavaca();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj smjera: ","Nije dobar odabir",1,predavaci.size());
		Predavac p = predavaci.get(index-1);
		p.setSifra(Pomocno.unosRasponBroja("Unesi šifru smjera (" + p.getSifra() + "): " ,"Pozitivan broj",
				1,Integer.MAX_VALUE));
		p.setIme(Pomocno.unosString("Unesi ime predavaca (" + p.getIme() + ")","Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime predavaca (" + p.getPrezime() + "): ", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email predavaca (" + p.getEmail() + "): ","Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi OIB predavaca (" + p.getOib() + "): ","OIB obavezno"));
		p.setIban(Pomocno.unosString("Unesi IBAN predavaca (" + p.getIban() + "): ","IBAN obavezno obavezno"));
	}
	
	private void brisanjePredavaca() {
		pregledPredavaca();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj predavača: ","Nije dobar odabir",1,predavaci.size());
		predavaci.remove(index-1);
		
	}

}
