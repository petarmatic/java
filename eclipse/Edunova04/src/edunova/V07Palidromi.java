package edunova;

import javax.swing.JOptionPane;

public class V07Palidromi {

	 public static void main(String[] args) {
	        int g = Integer.parseInt(JOptionPane.showInputDialog("gornji broj"));
	        int d = Integer.parseInt(JOptionPane.showInputDialog("donji broj"));

	        for (int i = g; i <= d; i++) {
	            if (jePalindrom(i)) {
	                System.out.println(i + " je palindrom.");
	            }
	        }
	    }

	    public static boolean jePalindrom(int broj) {
	        int praviBroj = broj;
	        int obrnutiBroj = 0;
	        while (broj > 0) {
	            int digit = broj % 10;
	            obrnutiBroj = obrnutiBroj * 10 + digit;
	            broj /= 10;
	        }
	        return praviBroj == obrnutiBroj;
	    }
	}
	

			
			

			




