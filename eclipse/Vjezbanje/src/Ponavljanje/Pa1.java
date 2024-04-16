package Ponavljanje;

import java.util.Scanner;

public class Pa1 {

	public static void main(String[] args) {
		
		 boolean ponovi = true; 
	     Scanner unos = new Scanner(System.in); 
	

		
		while(ponovi) {
		System.out.println("unesi prvi broj");
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
            case "^":
                System.out.println("Unesi eksponent:");
                int eksponent = unos.nextInt();
                rezultat = Math.pow(prviBroj, eksponent);
                break;
            case "!":
                if (prviBroj >= 0 && prviBroj == (int) prviBroj) {
                    int faktorijel = 1;
                    for (int i = 1; i <= prviBroj; i++) {
                        faktorijel *= i;
                    }
                    rezultat = faktorijel;
                } else {
                    System.out.println("Greška: faktorijel se može izračunati samo za pozitivne cijele brojeve.");
                    continue;
                }
                break;
            case "%":
                System.out.println("Unesi drugi broj:");
                drugiBroj = unos.nextDouble();
                rezultat = prviBroj % drugiBroj;
                break;
            
        

            default:
                System.out.println("Nepodržana operacija.");
                return; 
        }
        System.out.println("Rezultat je:" + rezultat);
        
        System.out.println("Želite li ponovno izračunati? (da/ne):");
        String odgovor = unos.next();

       
        if (!odgovor.equalsIgnoreCase("da")) {
            ponovi = false;
        }
        
		}

        
        unos.close();
		
	}
}

		

	


