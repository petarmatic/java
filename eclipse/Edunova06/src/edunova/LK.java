package edunova;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public class LK {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("unesi prvo ime:");
		String ime1 = scanner.nextLine();

		System.out.println("unesi drugo ime:");
		String ime2 = scanner.nextLine();

		String s = ime1.toLowerCase() + ime2.toLowerCase();
		System.out.println(s);

		int[] niz = new int[ime1.length() + ime2.length()];
		System.out.println(Arrays.toString(niz));
		
		
		int b;
		char z;
		
		for(int i=0;i<s.length();i++){
			z=s.charAt(i);
			b=0;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)==z) {
					b++;
				}
			}
			niz[i]=b;
			
		}
		System.out.println(Arrays.toString(niz));
		
		int polovina = niz.length / 2; //dodano
		int[] noviNiz = new int[polovina]; //promijenjeno
		for (int i = 0; i < polovina; i++) { //promijenjeno
		    noviNiz[i] = niz[i] + niz[niz.length - 1 - i]; //promijenjeno
		}
		
		System.out.println(Arrays.toString(noviNiz)); //promijenjeno
		

		
		
	}
	
	

		public static int[] zbrajanjeNiza(int [] niz) { 
		    int desniIndeks= niz.length-1;
		    int lijeviIndeks=0;
		    
		    int[] noviNiz = new int[niz.length]; 
		    int trenutniIndeks = 0; 
		    
		    while (lijeviIndeks <= desniIndeks) {
		        int suma = niz[lijeviIndeks] + niz[desniIndeks]; 
		        noviNiz[trenutniIndeks] = suma; 
		        lijeviIndeks++;
		        desniIndeks--;
		        trenutniIndeks++; 
		    }
		    
		    return noviNiz; 
		    
	    
	    
		
	}
}
