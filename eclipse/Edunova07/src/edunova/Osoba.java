package edunova;

//Ovo znati u svako doba dana i noći:
//Klasa je opisnik objekta
//za OOP čitati: https://github.com/tjakopec/OOP_JAVA_PHP_PYTHON_SWIFT/
public class Osoba {
	
	// OVO NIJE DOBRO jer nije o OOP principu učahurivanja
	/*
	String ime;
	String prezime;
	int godine;
*/
	
	// OOP princip UČAHURIVANJE
	// 1. UČAHURIVANJE Klasa će sakriti svoja svojstva
	private String ime;
	private String prezime;
	private int godine;
	
	// konstruktor je posebna metoda
	// koja se poziva ključnom rječju new
	// Naziv konstruktora mora biti istovjetan nazivu klase
	// prazan konstruktor
	public Osoba() {
		System.out.println("Nalazim se u Osoba konstruktor");
	}
	
	// puni konstruktor
	public Osoba(String ime, String prezime, int godine) {
		// super(); vezano za nasljeđivanje - kasnije
		this.ime = ime;
		this.prezime = prezime;
		this.godine = godine;
	}
	
	// 2. UČAHURIVANJE Klasa će učiti svojstva dostupna putem javnih get/set metoda
		public String getIme() {
			
			return ime;
		}


		public void setIme(String ime) {
			
			this.ime = ime;
		}
		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public int getGodine() {
			return godine;
		}
		public void setGodine(int godine) {
			this.godine = godine;
		}
		

}
