package edunova;

public class E02KoristenjeMetoda {
	public static void main(String[] args) {
		

		E01Metode.tip1();

	
	
	// ne možeš pristupiti metodi pozivom na klasu ako nije static
	//System.out.println(Pomocno.valjanOIB("45859658522"));
	
	
	// ne statične metode se pozivaju na objektu
	
	// objekt koji je instanca klase
	Pomocno p = new Pomocno();
	// objekti mogu pamtiti stanje
	
	//System.out.println(p.valjanOIB("60174682294")); // warning kada je metoda static
	
	System.out.println(Pomocno.valjanOIB("7328372837"));
				
	
	}

}

