package Ponavljanje;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

	

	private String ime;
	private String prezime;
	private List<Integer> ocjene;
	

	public Student(String ime, String prezime) {
				this.ime = ime;
				this.prezime = prezime;
				this.ocjene = new ArrayList<>();
	}

	public void dodajOcjenu(int ocjena) {
		ocjene.add(ocjena);
	}

	public double prosjekOcjena() {
		if (ocjene.isEmpty()) {
			return 0.0;

		}
		int suma = 0;
		for (int ocjena : ocjene) {
			suma += ocjena;
		}
		return (double) suma / ocjene.size();
	
	

	}

}
