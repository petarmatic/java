package edunova;

import java.util.ArrayList;
import java.util.List;

import edunova.model.Polaznik;

public class ObradaPolaznik {
	
	private List<Polaznik> polaznici;
	
	

	public List<Polaznik> getPolaznici() {
		return polaznici;
	}
	
	

	public ObradaPolaznik() {
		polaznici= new ArrayList<>();
		if(Pomocno.DEV) {
			testniPodaci();
		}
	}
	
	private void testniPodaci() {
//		polaznici.add(new Polaznik(1,"Ana","Gal","23432321222","agal@gail.com","2023/11"));
//		polaznici.add(new Polaznik(2,"Marija","Zimska","23432321223","mzimska@gail.com","2023/12"));
	}
	public void prikaziIzbornik() {
		System.out.println("Polaznik izbornik");
		System.out.println("1. Pregled postojećih polaznika");
		System.out.println("2. Unos novog polaznika");
		System.out.println("3. Promjena postojećeg polaznika");
		System.out.println("4. Brisanje postojećeg polaznika");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}
	private void ucitajStavkuIzbornika() {
		
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika", 
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledPolaznika();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjePolaznika();
			prikaziIzbornik();
			break;
		case 3:
			promjenaPolaznika();
			prikaziIzbornik();
			break;
		case 4:
			brisanjePolaznika();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}
		
		
	}
	private void brisanjePolaznika() {
		if(polaznici.isEmpty()) {
			System.out.println("Prazno");
		} else {
		pregledPolaznika();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj polaznika: ","Nije dobar odabir",1,polaznici.size());
		polaznici.remove(index-1);
		}
		
	}


	private void promjenaPolaznika() {
		pregledPolaznika();
		int index= Pomocno.unosRasponBroja("Odaberi redni broj smjera", "Odabir nije dobar", 1, polaznici.size());
		Polaznik p=polaznici.get(index-1);
		p.setSifra(Pomocno.unosRasponBroja("Unesi šifru smjera (" + p.getSifra() + "): " ,"Pozitivan broj",
				1,Integer.MAX_VALUE));
		p.setIme(Pomocno.unosString("Unesi ime polaznika (" + p.getIme() + ")","Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime polaznika(" + p.getPrezime() + ")", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email polaznika("+ p.getEmail() + ")", "Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi oib polaznika(" + p.getOib()+ ")", "OIB obavezno"));
		p.setBrojUgovora(Pomocno.unosString("Unesi broj ugovora polaznika("+ p.getBrojUgovora()+ ")", "Broj ugovora obavezno"));
		
		
	}
	public void pregledPolaznika() {
		System.out.println("-------------------");
		System.out.println("---- Polaznici ----");
		System.out.println("-------------------");
		// funkcionalno programiranje lambda expression
		//polaznici.forEach(s->{System.out.println(s);});
		int b=1;
		for(Polaznik p : polaznici)
			System.out.println(b++ + ". " + p);
		System.out.println("-------------------");
		
		
		
	}
	private void dodavanjePolaznika() {
		var p = new Polaznik();
		p.setSifra(Pomocno.unosRasponBroja("Unesi sifru smjera", "Pozitivan broj", 1,
				Integer.MAX_VALUE));
		p.setIme(Pomocno.unosString("Unesi ime polaznika", "Ime obavezno"));
		p.setPrezime(Pomocno.unosString("Unesi prezime polaznika", "Prezime obavezno"));
		p.setEmail(Pomocno.unosString("Unesi email polaznika", "Email obavezno"));
		p.setOib(Pomocno.unosString("Unesi oib polaznika", "Oib obavezan"));
		p.setBrojUgovora(Pomocno.unosString("Unesi broj ugovora", "Ugovor obavezan"));
		polaznici.add(p);
		
	}
	
	
	
}