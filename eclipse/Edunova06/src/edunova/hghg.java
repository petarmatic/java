package edunova;

import java.util.Scanner;

public class hghg {
	
		 public static void main(String[] args) {
			 Scanner scanner = new Scanner(System.in);

		        System.out.print("Unesite broj redaka tablice: ");
		        int brojRedaka = scanner.nextInt();
		        System.out.print("Unesite broj stupaca tablice: ");
		        int brojStupaca = scanner.nextInt();

		        int[][] tablica = new int[brojRedaka][brojStupaca];

		        int broj = 1;
		        for (int i = brojRedaka - 1; i >= 0; i--) {
		            for (int j = 0; j < brojStupaca; j++) {
		                tablica[i][j] = broj++;
		            }
		        }

		        System.out.println("Tablica množenja:");
		        for (int i = 0; i < brojRedaka; i++) {
		            for (int j = 0; j < brojStupaca; j++) {
		                System.out.print(tablica[i][j] + "\t");
		            }
		            System.out.println();
		        }

		        scanner.close();
		    }
		
		    }
		
	


