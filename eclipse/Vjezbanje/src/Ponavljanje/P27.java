package Ponavljanje;

import java.util.Scanner;

public class P27 {

	public static void main(String[] args) {
		System.out.println("Disi pero");
		
		
		Scanner unos= new Scanner(System.in);
		System.out.println("Unesi nešto");
		String uneseno= unos.next();
		
		nesto(uneseno);
		
		
	}
	
	public static void nesto(String uneseno) {
		
		 if (uneseno.length() > 6) {
	            System.out.println("Riječ ima više od 6 znakova.");
	        } else {
	            System.out.println("Riječ ima 6 ili manje znakova.");
	        }
		
	}
	
	

}
