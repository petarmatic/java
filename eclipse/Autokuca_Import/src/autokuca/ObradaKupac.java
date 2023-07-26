package autokuca;

import java.util.ArrayList;
import java.util.List;

import autokuca.model.Kupac;

public class ObradaKupac {
	private List<Kupac>kupci;
	
	public ObradaKupac() {
		kupci = new ArrayList<>();
	}
	
	public List<Kupac> getKupci() {
		return kupci;
	}



	public void prikaziIzbornik() {
		System.out.println("\n Kupac");
		System.out.println("1.Pregled postojećih kupaca");
		System.out.println("2. Unos novog kupca");
		System.out.println("3.Promjena postojećih kupaca");
		System.out.println("4.Brisanje postojećih kupaca");
		System.out.println("5.Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku kupca izbornika 1-5", 
				"Odabir nije dobar", 1, 5)) {
		case 1:
			pregledKupca();
			prikaziIzbornik();
			break;
		case 2:
			unosNovogKupca();
			prikaziIzbornik();
			break;
		case 3:
			promjenaPostojecegKupca();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeKupca();
			prikaziIzbornik();
			break;
		case 5:
		    break;
		}
		
	}

	private void brisanjeKupca() {
		pregledKupca();
		int i=Pomocno.unosRasponBroja("Odaberi redni broj kupca", "Odabir nije dobar",
				1, kupci.size());
		kupci.remove(i-1);
		
	}

	private void promjenaPostojecegKupca() {
		pregledKupca();
		int i= Pomocno.unosRasponBroja("Odaberi redni broj kupca",
				"Odabir nije dobar", 1, kupci.size());
		Kupac k =kupci.get(i-1);
		k.setBudzet(Pomocno.unosFloat("Odaberi redni broj kupca", "Odabir nije dobar"));
		k.setIme(Pomocno.unosString("Unesi ime kupca", "Unos nije dobar"));
		k.setPrezime(Pomocno.unosString("Unesi prezime kupca", "Unos nije dobar"));
		
	}

	private void unosNovogKupca() {
		Kupac k = new Kupac();
		k.setBudzet(Pomocno.unosFloat("Unesi budzet", "Unos nije dobar"));
		k.setIme(Pomocno.unosString("Unesi ime kupca", "Unos nije dobar"));
		k.setPrezime(Pomocno.unosString("Unesi prezime kupca", "Unos nije dobar"));
		kupci.add(k);
	}

	public void pregledKupca() {
		int b=1;
		for(Kupac k :kupci) {
			System.out.println(b++ + "." + k);
		}
		System.out.println();
	}
	
	

}