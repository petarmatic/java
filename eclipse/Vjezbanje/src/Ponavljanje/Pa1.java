package Ponavljanje;

import java.util.Scanner;

public class Pa1 {

	public static void main(String[] args) {
		System.out.println("unesi neki broj");
		Scanner unos = new Scanner(System.in);
        double prviBroj = unos.nextDouble(); 

       
        System.out.println("Unesi operaciju (+, -, *, /):");
        String operacija = unos.next(); 

     
        System.out.println("Unesi drugi broj:");
        double drugiBroj = unos.nextDouble(); 

		
        double rezultat = 0;

        
        switch (operacija) {
            case "+":
                rezultat = prviBroj + drugiBroj;
                break;
            case "-":
                rezultat = prviBroj - drugiBroj;
                break;
            case "*":
                rezultat = prviBroj * drugiBroj;
                break;
            case "/":
            	if (drugiBroj != 0) {
                    rezultat = prviBroj / drugiBroj;
                } else {
                    System.out.println("Greška: dijeljenje s nulom nije moguće.");
                    return; 
                }
                break;
            default:
                System.out.println("Nepodržana operacija.");
                return; 
        }

        
        System.out.println("Rezultat: " + rezultat);

        
        unos.close();
	}
}
		

	


