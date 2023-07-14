package edunova;

import java.util.ArrayList;
import java.util.List;

import edunova.model.Predavac;

public class ObradaPredavac {
	
	private List<Predavac> predavaci;
	
	
		
	
	public ObradaPredavac() {
		predavaci= new ArrayList<>();
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
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika",
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

	private void brisanjePredavaca() {
		pregledPredavaca();
		int index= Pomocno.unosRasponBroja("Odaberi redni broj predavaca:", "Nije dobar odabir", 1, predavaci.size());
		predavaci.remove(index-1);
		
	}

	private void promjenaPredavaca() {
		pregledPredavaca();
		int index= Pomocno.unosRasponBroja("Odaberi redni broj predavaca", "Odabir nije dobar",
				1, predavaci.size());
		Predavac p= predavaci.get(index-1);
		p.setSifra(Pomocno.unosRasponBroja("Odaberi sifru predavaca("+ p.getSifra()+ ")", "Pozitivan broj", 1, predavaci.size()));
		p.setIme(Pomocno.unosString("Unesi ime predavaca", "Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime predavaca", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email predavaca", "Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi oib predavaca", "Oib obavezno"));
		p.setIban(Pomocno.unosString("Unesi iban predavaca", "Iban obavezno"));
		
	}

	private void dodavanjePredavaca() {
		Predavac p= new Predavac();
		p.setSifra(Pomocno.unosRasponBroja("Unesi sifru predavaca", "Pozitivan broj",
				1, Integer.MAX_VALUE));
		p.setIme(Pomocno.unosString("Unesi ime predavaca", "Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime predavaca", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email predavaca", "Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi oib predavaca", "Oib obavezno"));
		p.setIban(Pomocno.unosString("Unesi Iban predavaca", "Iban obavezan"));
		predavaci.add(p);
		
		
		
	}

	private void pregledPredavaca() {
		System.out.println("-------------------");
		System.out.println("---- Predavači ----");
		System.out.println("-------------------");
		int b=1;
		for(Predavac p : predavaci)
			System.out.println(b++ + ". " +p);
		System.out.println("-------------------");
	}
	
	

}
