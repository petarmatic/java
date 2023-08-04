package edunova.model;

import java.util.Date;

import java.util.List;

public class Grupa extends Entitet{
	
	private String naziv;
	private Smjer smjer;
	private int maxpolaznika;
	private Predavac predavac;
	private Date datumPocetka;
	private List<Polaznik> polaznici;
	
	
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
	public int getMaxpolaznika() {
		return maxpolaznika;
	}
	public void setMaxpolaznika(int maxpolaznika) {
		this.maxpolaznika = maxpolaznika;
	}
	public Predavac getPredavac() {
		return predavac;
	}
	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public List<Polaznik> getPolaznici() {
		return polaznici;
	}
	public void setPolaznici(List<Polaznik> polaznici) {
		this.polaznici = polaznici;
	}
	
	
	

}
	
	
	
	