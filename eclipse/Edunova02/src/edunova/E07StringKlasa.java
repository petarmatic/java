package edunova;

public class E07StringKlasa {
	public static void main(String[] args) {
		String s=new String();
		
		// bolje
		
		String grad="Grabovac" + " je metropola " + 9;
		System.out.println(grad);
		System.out.println(grad.toUpperCase());
		System.out.println(grad.toLowerCase());
		System.out.println(grad.substring(2,10));
	}

}
