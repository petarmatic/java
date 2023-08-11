package Ponavljanje;

import java.util.Scanner;

public class Ponavljanje07 {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("Unesite broj n: ");
	        int n = scanner.nextInt();
	        
	        System.out.println("Prvih " + n + " brojeva Fibonačijevog niza:");
	        for (int i = 0; i < n; i++) {
	            System.out.print(fibonacci(i) + " ");
	        }
	    }

	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fibonacci(n-1)+ fibonacci(n-2);
		}
		
		
	}
	}


