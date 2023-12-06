package geometrija;

public class PrimjerSlike3 {

	public static void main(String[] args) {
		Slika slika= new Slika(60, 20);
		
		GeometrijskiLik[] likovi= new GeometrijskiLik[] {
				new Krug("k1", 4, 4, 3),
				new Krug("k2", 45, 10, 9),
				new Pravokutnik("p1", 12, 6, 20, 8)
		};
		
		for(GeometrijskiLik lik:likovi) {
			slika.crtaj(lik);
		}
		System.out.println(slika.toString());
	}
}
