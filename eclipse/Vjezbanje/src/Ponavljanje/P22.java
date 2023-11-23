package Ponavljanje;

import java.util.Arrays;
import java.util.Scanner;

public class P22 {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.print("Unesite veličinu niza: ");
        int velicinaNiza = scanner.nextInt();

        
        int[] niz = new int[velicinaNiza];

        
        for (int i = 0; i < velicinaNiza; i++) {
            System.out.print("Unesite broj za indeks " + i + ": ");
            niz[i] = scanner.nextInt();
        }

        
        scanner.close();

        
        System.out.print("Uneseni niz: ");
        for (int broj : niz) {
            System.out.print(broj + " ");
        }
        
        System.out.println("zbroj niza " + solution(niz));
        System.out.println("najveci broj je:"+ najveci(niz));
        System.out.println("najmanji broj je :" + najmanji(niz));
        System.out.println("sortirano: "+ Arrays.toString(sortiraj(niz)));
	}
	
	public static int solution(int [] niz) {
		int zbroj=0;
		for(int broj:niz) {
			zbroj+=broj;
		}
		
		return zbroj;
	}
	
	public static int najveci(int [] niz) {
		int najveciBroj=niz[0];
		for(int i=1;i<niz.length;i++) {
			if(niz[i]>najveciBroj) {
				najveciBroj=niz[i];
			}
		}
		
		return najveciBroj;
	}
	public static int najmanji(int[]niz) {
		
		int najmanji=niz[0];
		for(int i=1;i<niz.length;i++) {
			if(niz[i]<najmanji) {
				najmanji=niz[i];
			}
		}
		
		return najmanji;
	}
	
	public static int [] sortiraj(int[]niz) {
		Arrays.sort(niz);
		return niz;
		
	}

}
