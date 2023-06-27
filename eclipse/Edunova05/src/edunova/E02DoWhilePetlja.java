package edunova;

public class E02DoWhilePetlja {

	public static void main(String[] args) {
		// do while osigurava minimalno jedan prolazak kroz petlju
		
		do {
			System.out.println("Ispisuje se");
		}while(false);
		
		// prekidanje,nastavak i ugnježđivanje su jednaki kao kod for i while
		
		
		//zbroj prvih sto brojeva
		
		int suma=0;
		int i=1;
		
		do {
			suma+=1;
		}while(i++<100);
		System.out.println(suma);
	}

}
