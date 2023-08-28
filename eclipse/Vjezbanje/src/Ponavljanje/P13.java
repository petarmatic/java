package Ponavljanje;

import java.util.Scanner;

public class P13 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Unesi broj za izračun sume od 1 do tog broja:");
		int broj=scan.nextInt();
		scan.close();
		int suma=izracun(broj);
		System.out.println("suma brojeva od 1 do " + broj +" je:" + izracun(broj));
		
	}
	
	public static int izracun(int n) {
		if(n==0) {
			return 0;
		}else {
			return n + izracun(n-1);
		}
		
		
	}
}
