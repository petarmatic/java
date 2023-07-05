package edunova;

public class Z01 {
	public static void main(String[] args) {
		
	

	// Kreirati klasu Grad s minimalno 5 različitih svojstava (različitih tipova podataka)
	// Ovhjed u main metodi napraviti instancu klase Grad, dodjeliti vrijednosti za sva svojstva
	// te po želji ispisati jedno svojstvo
	
		
		Grad grad=new Grad();
		grad.setIme("osijek");
		grad.setPostanskiBroj(56562);
		grad.setTrgovina(false);
		grad.setProsjecnaPlaca(3232);
		
		
		System.out.println(grad.isTrgovina());
		System.out.println(grad.getIme());
		System.out.println(grad.getPostanskiBroj());
		System.out.println(grad.getProsjecnaPlaca());
		System.out.println(grad.getEnergetskiCertifikat());
		
		
		
		
		
		
	}
}
