package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class LK {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("unesi prvo ime:");
		String ime1= scanner.nextLine();
		
		System.out.println("unesi drugo ime:");
		String ime2= scanner.nextLine();
		
		String s= ime1.toLowerCase() + ime2.toLowerCase();
		
		System.out.println(s);
		
		int [] niz = new int [ime1.length()+ime2.length()];
		System.out.println(niz);
		
		int b;
		char z;
		for(int i=0;i<s.length();i++) {
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
	}
	
	private void drugikorak() {
		if ()
		
	}
	
}