package autokuca;

import java.util.List;

import autokuca.model.Prodavac;

public class ObradaProdavac {
	
	
	private List<Prodavac> prodavaci;
	
	
	
	public void prikaziIzbornik() {
		System.out.println("\nIzbornik prodavača");
		System.out.println("1.Pregled prodavača");
		System.out.println("2.Unosi novih prodavača");
		System.out.println("3.Promjena postojećih prodavača");
		System.out.println("4.Brisanje postojećih prodavača");
		System.out.println("5.Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}



	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika", 
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledProdavaca();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeProdavaca();
			prikaziIzbornik();
			break;
		}
		
	}



	private void dodavanjeProdavaca() {
		Prodavac p =new Prodavac();
	}



	private void pregledProdavaca() {
		int b=1;
		for (Prodavac p:prodavaci)
			System.out.println(b++ + ". "+ p);	
	}
	
	

}

