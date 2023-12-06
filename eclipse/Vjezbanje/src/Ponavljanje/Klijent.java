package Ponavljanje;

public class Klijent extends Interface implements I1,I2 {

	public static void klijent1(I1 objekt) {
		objekt.m1();
		System.out.println("Broj: "+objekt.m2());
	}
	
	public static void klijent2(I2 objekt) {
		objekt.m1();
		System.out.println("Ime je: " + objekt.m3());
	}
	
	public static void main(String[] args) {
		C2 c= new C2();
		klijent1(c);
		klijent2(c);
	}

	@Override
	public String m3() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}