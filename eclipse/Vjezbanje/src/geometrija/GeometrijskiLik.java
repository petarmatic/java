package geometrija;

public abstract class GeometrijskiLik implements SadrziocTocaka {
	
	private String ime;
	
	public GeometrijskiLik(String ime) {
		this.ime=ime;
	}
	
	public String getIme() {
		return ime;
	}
	
	public double getOpseg() {
		return 0;
	}
	
	public double getPovrsina() {
		return 0;
	}

}
