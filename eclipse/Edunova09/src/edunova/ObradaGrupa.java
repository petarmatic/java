package edunova;

import java.util.ArrayList;
import java.util.Iterator;

import edunova.model.Grupa;
import edunova.model.Predavac;
import edunova.model.Polaznik;
import edunova.model.Smjer;
import java.util.List;
import java.util.Scanner;

public class ObradaGrupa {

	private List<Grupa> grupe;
	private Izbornik izbornik;

	public ObradaGrupa(Izbornik izbornik) {
		this();
		this.izbornik = izbornik;
	}

	public ObradaGrupa() {
		grupe = new ArrayList<>();
		if (Pomocno.DEV) {
			testniPodaci();
		}
	}

	private void testniPodaci() {
//		grupe.add(new Grupa(1,"nova grupa",1,"20",1,"06.06.2023.",1));

	}

	public void prikaziIzbornik() {
		System.out.println("\nGrupa izbornik");
		System.out.println("1. Pregled postojećih grupa");
		System.out.println("2. Unos nove grupe");
		System.out.println("3. Promjena postojeće grupe");
		System.out.println("4. Brisanje postojeće grupe");
		System.out.println("5. Brisanje polaznika s grupe");
		System.out.println("6. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku izbornika", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledGrupe();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeGrupe();
			prikaziIzbornik();
			break;
		case 3:
			pregledGrupe();
			promjenaGrupe();
			break;
		case 4:
			brisanjeGrupa();
			prikaziIzbornik();
			break;
		case 5:
			brisanjePolaznika();
			prikaziIzbornik();
			break;
		case 6:
			break;
		}

	}

	private void brisanjePolaznika() {
		Scanner ulaz = new Scanner(System.in);

		if (grupe.isEmpty()) {
			System.out.println("Nema polaznika");
			return;
		}

		pregledGrupe();

		int index = Pomocno.unosRasponBroja("Odaberi redni broj grupe: ", "Nije dobar odabir", 1, grupe.size());
		Grupa odabranaGrupa = grupe.get(index - 1);

		if (odabranaGrupa.getPolaznici().isEmpty()) {
			System.out.println("Grupa nema polaznika.");
			return;
		}

		List<Polaznik> polaznici = new ArrayList<>(odabranaGrupa.getPolaznici());
		Iterator<Polaznik> iterator = polaznici.iterator();

		while (iterator.hasNext()) {
			Polaznik polaznik = iterator.next();
			System.out.print(
					"Želite li obrisati polaznika '" + polaznik.getIme() + " " + polaznik.getPrezime() + "' (da/ne)? ");
			String odgovor = ulaz.nextLine().toLowerCase();
			if (odgovor.equals("da")) {
				iterator.remove();
			}
			 
		}

		odabranaGrupa.setPolaznici(polaznici);
		System.out.println("Promjene spremljene.");
		 ulaz.close();
	}

	private void brisanjeGrupa() {
		if (grupe.isEmpty()) {
			System.out.println("Prazno");
		} else {
			pregledGrupe();
			int index = Pomocno.unosRasponBroja("Odaberi redni broj grupaa: ", "Nije dobar odabir", 1, grupe.size());
			grupe.remove(index - 1);
		}

	}

	private void promjenaGrupe() {
		boolean upit = Pomocno
				.unosBoolean("Želite li promjeniti jednu od grupa? (da za nastavak ili ne za odustajanje): ");
		if (upit) {
			if (grupe.isEmpty()) {
				System.out.println("\nTrenutno nije unesena niti jedna grupa");
			} else {
				int index = Pomocno.unosRasponBroja("Odaberi redni broj grupe: ", "Nije dobar odabir", 1, grupe.size());
				Grupa g = grupe.get(index - 1);
				g.setSifra(Pomocno.unosRasponBroja("Unesi šifru grupe (" + g.getSifra() + "): ", "Pozitivan broj", 1,
						Integer.MAX_VALUE));
				g.setNaziv(Pomocno.unosString("Unesi naziv grupe (" + g.getNaziv() + "): ", "Naziv obavezan"));
				g.setMaxpolaznika(
						Pomocno.unosRasponBroja("Unesi maksimalno polaznika grupe: ", "Pozitivan broj (5-25)", 5, 25));
				System.out.println("Trenutni smjer: " + g.getSmjer().getNaziv());
				g.setSmjer(postaviSmjer());
				System.out.println("Trenutni predavač: " + g.getPredavac());
				g.setPredavac(postaviPredavaca());
				g.setDatumPocetka(Pomocno.unosDatum("Unesi datum početka"));
				System.out.println("----------------------------");
				System.out.println("---- Trenutni polaznici ----");
				System.out.println("----------------------------");
				int b = 1;
				for (Polaznik p : g.getPolaznici()) {
					System.out.println(b++ + ". " + p);
				}
				System.out.println("-------------------");
				g.setPolaznici(postaviPolaznike());
				System.out.println("Promjene spremljene.");
			}
		}

	}

	private void dodavanjeGrupe() {
		Grupa g = new Grupa();
		g.setSifra(Pomocno.unosRasponBroja("Unesi sifru grupe", "Sifra obavezno", 1, Integer.MAX_VALUE));
		g.setNaziv(Pomocno.unosString("Unesi ime grupe", "Naziv obavezno"));
		g.setSmjer(postaviSmjer());
		g.setMaxpolaznika(
				Pomocno.unosRasponBroja("Unesi maksimalno polaznika grupe: ", "Pozitivan broj (5-25)", 5, 25));
		g.setPredavac(postaviPredavaca());
		g.setDatumPocetka(Pomocno.unosDatum("Unesi datum početka"));
		List<Polaznik> polaznici = postaviPolaznike();
		g.setPolaznici(postaviPolaznike());
		if (polaznici.isEmpty()) {
			System.out.println("Grupa mora imati barem jednog polaznika.");
			return; // Vraćanje na izbornik grupe
		}

		List<Grupa> novaListaGrupa = new ArrayList<>(grupe);
		g.setPolaznici(polaznici);
		novaListaGrupa.add(g);

		grupe = novaListaGrupa;

	}

	private List<Polaznik> postaviPolaznike() {
		List<Polaznik> polaznici = new ArrayList<>();
		while (Pomocno.unosRasponBroja("Dodati polaznike (1 da,2 ne)", "greska", 1, 2) == 1) {
			polaznici.add(postaviPolaznika());
		}
		return polaznici;
	}

	private Polaznik postaviPolaznika() {
		izbornik.getObradaPolaznik().getPolaznici();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj polaznika:", "Nije dobar odabir", 1,
				izbornik.getObradaPolaznik().getPolaznici().size());
		return izbornik.getObradaPolaznik().getPolaznici().get(index - 1);

	}

	private Smjer postaviSmjer() {
		izbornik.getObradaSmjer().pregledSmjerova();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj smjera: ", "Nije dobar odabir", 1,
				izbornik.getObradaSmjer().getSmjerovi().size());
		return izbornik.getObradaSmjer().getSmjerovi().get(index - 1);
	}

	private Predavac postaviPredavaca() {
		izbornik.getObradaPredavac().pregledPredavaca();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj predavača", "Odabir nije dobar", 1,
				izbornik.getObradaPredavac().getPredavaci().size());
		return izbornik.getObradaPredavac().getPredavaci().get(index - 1);
	}

	private void pregledGrupe() {
		System.out.println("------------------");
		System.out.println("---- Grupe ----");
		System.out.println("------------------");
		int b = 1;
		for (Grupa g : grupe)
			System.out.println(b++ + ". " + g);
		System.out.println("------------------");
	}

}
