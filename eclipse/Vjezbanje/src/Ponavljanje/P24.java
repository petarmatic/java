package Ponavljanje;

import java.util.Scanner;

public class P24 {

	public static void main(String[] args) {
		 Scanner input = new Scanner (System.in);
	        System.out.println("Aritmeticka sredina prirodnih brojeva od 1 do n"); 
	 
	        int n;                     
	        double s, br, as;          
	 
	        System.out.print("Do broja: ");
	        n = input.nextInt();       
	 
	        s = 0;                      
	        br=0;                       
	        for (int i = 1; i <= n; i++) { 
	            s += i;                 
	            br += 1;                
	        }
	        as = s / br;                
	        System.out.println("Aritmeticka sredina = " + as);

	}

}
