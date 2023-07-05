package edunova;

import java.util.Date;

public class Grupa {
	private int sifra;
	private String naziv;
	private Smjer smjer;
	private Date datumPocetka;
	private int brojPolaznika;
	
	
	
	
	public Grupa() {
		super();
	}
	public Grupa(int sifra, String naziv, Smjer smjer, Date datumPocetka, int brojPolaznika) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.smjer = smjer;
		this.datumPocetka = datumPocetka;
		this.brojPolaznika = brojPolaznika;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Smjer getSmjer() {
		return smjer;
	}
	public void setSmjer(Smjer smjer) {
		this.smjer = smjer;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public int getBrojPolaznika() {
		return brojPolaznika;
	}
	public void setBrojPolaznika(int brojPolaznika) {
		this.brojPolaznika = brojPolaznika;
	}
	

}
