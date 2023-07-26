package Ponavljanje;

import java.util.Scanner;

public class Ponavljanje01 {
	
	// ispiši brojeve
	
	public static void main(String[] args) {
		for(int i=1;i<=10;i++)
			//System.out.println(i);
			System.out.print(i+ " ");
		System.out.println();
		
		
		for(int i=10;i>=1;i--)
			System.out.print(i + " ");
		System.out.println();
		
		
		
		
		// ispis parnih
		for(int i=1;i<=10;i++)
			if(i %2 ==0)
				System.out.print(i + " ");
		System.out.println();
		
		
		for(int i=1;i<=10;i++)
			if(i %2 !=0)
				System.out.print(i + " ");
		System.out.println();
		
		
		for(int i=33;i>=3;i--)
			if(i%3==0)
				System.out.print(i +" ");
		System.out.println();
		
//		scanner scanner= new scanner(system.in);
//		
//		system.out.print("unesi prvi broj");
//		int broj1=scanner.nextint();
//		
//		system.out.print("unesi drugi broj");
//		int broj2=scanner.nextint();
//	  
//		system.out.print("prirodni brojevi koji su između" + " " +broj1 + "i" +" " + broj2 +" " + "su:" );
//		
//		for(int i=broj1;i<=broj2;i++)
//			system.out.print(i + " ");
//		
		Scanner scanner2=new Scanner(System.in);
		
		System.out.println("Unesi broj neki");
		int broj=scanner2.nextInt();
		System.out.println("Prirodni brojevi od 1" + " " + "do" + " "  + broj + " "+ "su:");
		for(int i=broj;i>=1;i--)
			System.out.print(i + " ");
		
		
		
		
		
		
		
		
	}
}
	



