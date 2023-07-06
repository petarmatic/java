package edunova;

public class Start {
	public static void main(String[] args) {
		
		
		//Osoba osoba = new Osoba(1, "Pero", "Perić");
		
		//System.out.println(osoba);
		
		//Osoba stanovnik = new Osoba(1,"Pero","Perić");
		
		//System.out.println(osoba.equals(stanovnik));
		
		Polaznik polaznik = new Polaznik(1, "Marija", "Otis", "2023/12");
		
		System.out.println(polaznik);
		
		Predavac predavac = new Predavac(1,"Karlo","Set","HR54548456465464");
		
		System.out.println(predavac);
		
	
		Osoba[] osobe = new Osoba[2];
		osobe[0]=polaznik;
		osobe[1]=predavac;
		
		for(Osoba o : osobe) {
			// ovo je polimorfizam
			System.out.println(o.pozdravi()); // ovdje vidim samo razinu klase Osoba
		}
		

	
		
		
	}

}


