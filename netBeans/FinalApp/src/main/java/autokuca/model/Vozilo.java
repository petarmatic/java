package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Vozilo extends Entitet{
	private BigDecimal cijena;
        @ManyToOne
	private ProdajnoMjesto prodajnomjesto;
	
	
	
	

	


	public Vozilo(Integer sifra, BigDecimal cijena, ProdajnoMjesto prodajnomjesto) {
		super(sifra);
		this.cijena = cijena;
		this.prodajnomjesto = prodajnomjesto;
	}


	public Vozilo() {
		// TODO Auto-generated constructor stub
	}


	public BigDecimal getCijena() {
		return cijena;
	}


	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}


	public ProdajnoMjesto getProdajnomjesto() {
		return prodajnomjesto;
	}


	public void setProdajnomjesto(ProdajnoMjesto prodajnomjesto) {
		this.prodajnomjesto = prodajnomjesto;
	}


	

	
}
