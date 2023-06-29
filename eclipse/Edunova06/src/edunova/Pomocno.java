package edunova;

import javax.swing.JOptionPane;

public class Pomocno {

	public static void ispisiTablicu(int[][] matrica) {
		for(int i=0;i<matrica.length;i++) {
			for(int j=0;j<matrica[i].length;j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
		String s="";
		int brojeva = matrica[0].length;
		
		for(int i=0;i<brojeva*2 - 1;i++) {
			s+="*";
		}
		
		System.out.println(s);
	}
	
	
	public static int ucitajbroj(String poruka, String greska) {
		while(true) {
			try {
				return Integer.parseInt(JOptionPane.showInputDialog(poruka));	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, greska);
			}
					
		}
	}
	
	
	public static boolean valjanOIB(String oib) {
		if (oib.length() != 11) {
            return false;
        }

        char[] chars = oib.toCharArray();
        
        int a = 10;
        for (int i = 0; i < 10; i++) {
        	char c = chars[i];
        	if (c < '0' || c > '9') {
        		return false;
        	}
            a = a + (c - '0');
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;

        if (kontrolni != (chars[10] - '0')) {
        	return false;
        }
    	return true;
	}
	

}