package Ponavljanje;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ponavljanje02 {
	public static void main(String[] args) {
     // faktorijel
		Scanner scanner= new Scanner(System.in);
		System.out.println("Unesi broj");
		int n= scanner.nextInt();
		int faktorijel=1;
		for(int i=1;i<=n;i++) {
			faktorijel = faktorijel*i;
		}
		
		System.out.println("Faktorijel je" + faktorijel);
			
    }


}
