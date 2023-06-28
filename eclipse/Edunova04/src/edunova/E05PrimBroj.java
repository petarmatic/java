package edunova;

public class E05PrimBroj {

	public static void main(String[] args) {
		int broj=5846;
		//hipoteza
		boolean prim=true;
		for(int i=2;i<broj;i++) {
			if(broj%i==0) {
				prim=false;
				break; // čitati https://www.bigocheatsheet.com/
			}
		}
		
		System.out.println(broj  + (prim ? " je" : " nije") + " prim broj");
		
		
		
		// nastavak doma: Ispisati sve prim brojeve između dav unesena broj

	}

}
