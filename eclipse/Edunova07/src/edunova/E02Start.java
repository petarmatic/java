package edunova;

import java.util.Date;

public class E02Start {
	public static void main(String[] args) {
		// Ovo znati u svako doba dana i noći:
				// Objekt je instanca/pojavnost klase
				// 1. Naziv klase - tip objekta
				// 2. Naziv instance/objekta/varijable (malim slovima kao i ime klase)
				// 3. nakon jednako poziv posebne metode (konstruktor)
		
		
		Osoba osoba  = new Osoba();
		/* OVO NIJE PO OOP
		osoba.ime="Pero";
		osoba.prezime="Perić";
		osoba.godine=24;
		*/
		
		osoba.setIme("Pero");
		osoba.setPrezime("Perić");
		osoba.setGodine(24);
		
		Osoba[] osobe = new Osoba[5];
		osobe[0]=osoba;
		
		osoba = new Osoba();
		
		osoba.setIme("Marija");
		osoba.setPrezime("Zimska");
		osoba.setGodine(21);
		
		osobe[1]=osoba;
		
		osobe[2] = new Osoba("Karlo","Kat",41);
		
		System.out.println(osobe[0].getPrezime() + " " + osoba.getPrezime());
		
		
		
		Mjesto mjesto=new Mjesto();
		mjesto.setZupanija(new Zupanija("obž",2000));
		// jedna od najčešćih iznimaka (da ne kažemo grešaka) je NullPointerException
				System.out.println(mjesto.getZupanija().getNaziv());
				
				
		Grupa[] grupe=new Grupa[2];
		Smjer smjer= new Smjer(1,"java prog", 454.33f, false);
		
		grupe[0]=new Grupa(1, "jp", smjer, new Date(),25);
		grupe[1]=new Grupa(1, "jp28", smjer, new Date(), 25);
		
		// ispisati sve nazive grupa i naziv smjera grupe s niza grupe
		for(Grupa g:grupe) {
			System.out.println(g.getNaziv() + " " + g.getSmjer().getNaziv());
		}
		
		
	}

}
