package projekt;

import java.text.DecimalFormat;

public class FormatiraniIspisDecBrojeva {

	public static void main(String[] args) {
		double [] brojevi= new double[] {
				3.712, 55.813, 55.816, -4.18};
		ispis(brojevi, "000.00");
		System.out.println("--------------");
		ispis(brojevi, "+00.00;-00.00");

	}
	
	public static void ispis(double [] polje, String format) {
		
		DecimalFormat formater= new DecimalFormat(format);
		for(int i=0;i<polje.length;i++) {
			System.out.println("(" + i + "): [" + formater.format(polje[i]) + "]");
		}
	}

}
