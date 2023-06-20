package edunova;

public class E04UlazniParametri {

	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("Obavezno dva parametra");
			return; // prekidamo izvođenje metode - short curcuiting
		}

		
		System.out.println(args[0]);
	}

}
