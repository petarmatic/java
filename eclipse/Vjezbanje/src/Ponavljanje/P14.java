package Ponavljanje;

import java.util.Scanner;

public class P14 {
	public static void main(String[] args) {
		//Implementirajte rekurzivnu funkciju koja će pronaći najveći zajednički djelitelj (NZD) dva broja.
		
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Unesi prvi broj");
		int broj1=scan.nextInt();
		
		System.out.println("Unesi drugi broj");
		int broj2=scan.nextInt();
		
		scan.close();
		
		int nzd = izracunNZD(broj1, broj2);
        System.out.println("Najveći Zajednički Ddjelitelj brojeva " + broj1 + " i " + broj2 + " je: " + nzd);


	}
	
	public static int izracunNZD(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return izracunNZD(b, a % b);
		}
			
	}

}
