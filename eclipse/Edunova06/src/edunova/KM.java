package edunova;

public class KM {

public static void main(String[] args) {
		
		
		//System.out.println(Pomocno.ucitajbroj("Unesi cijeli broj", "Nisi unio broj"));
		
		
		int[][] niz = {
				{2,3,4},
				{2,6,789},
				{3,5,4}
				
		};
		
		
		Pomocno.ispisiTablicu(niz);
		
		// broj 7 zamjenite s brojem 1 i ponovo ispišite matricu
		niz[1][2] = 1;
		Pomocno.ispisiTablicu(niz);
		
	}

}
