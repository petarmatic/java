package Ponavljanje;

import java.util.Scanner;

// napisati program, korisnik unosi brojeve, pregeldavaju se brojevi, ako je paran i ako je veci od 20, ispisi dovoljan,
//ako je veci od 30 ispisi dobar, ako je veci od 40 ispis vrlo dobar, ako je veci od 50 ispisi odlican
// ako broj nije paran i ako je veci od 20 ispisi neparni oko 20, ako je veci od 30 neparni oko 30, ako je veci od 40 neparni oko 40, ako 
// je veci od 50 neparni oko 50
public class P21 {
	
	public static void main(String[] args) {
		
		
		Scanner scanner= new Scanner(System.in);
		
		boolean ponovno=true;
		while(ponovno) {
		
			System.out.println("unesi neki broj:");
			int broj=scanner.nextInt();
			ocijeniBroj(broj);
			System.out.println("zelis li unijeti jos neki broj? (da/ne)");
			String odgovor=scanner.next();
			ponovno=odgovor.equalsIgnoreCase("da");
			
		}
		System.out.println("Hvala na korištenju programa!");
		scanner.close();
	}
		
	/*	
		private static void ocijeniBroj(int broj) {
		if (broj % 2 == 0) {
		    if (broj >= 50) {
		        System.out.println("Odličan");
		    } else if (broj >= 40) {
		        System.out.println("Vrlo dobar");
		    } else if (broj >= 30) {
		        System.out.println("Dobar");
		    } else if (broj >= 20) {
		        System.out.println("Dovoljan");
		    } else {
		    	System.out.println("Broj je manji od 20");
		    }
		} else {
		    if (broj >= 50) {
		        System.out.println("Neparni od 50 pa na više");
		    } else if (broj >= 40) {
		        System.out.println("Neparni oko 40");
		    } else if (broj >= 30) {
		        System.out.println("Neparni oko 30");
		    } else if (broj >= 20) {
		        System.out.println("Neparni oko 20");
		    } else {
		        System.out.println("Neparni manji od 20");
		    }
		}
		*/
		
		
	// use switch case BETTER
	private static void ocijeniBroj(int broj) {
	    switch (broj) {
	        case 20:
	            System.out.println("Dovoljan");
	            break;
	        case 30:
	            System.out.println("Dobar");
	            break;
	        case 40:
	            System.out.println("Vrlo dobar");
	            break;
	        case 50:
	            System.out.println("Odličan");
	            break;
	        default:
	            if (broj % 2 == 0) {
	                // Dodana nova provjera paran/neparan broj
	                System.out.println("Broj je paran, ali nije naveden u slučajevima 20, 30, 40, 50");
	            } else {
	                switch ((broj / 10) * 10) {
	                    case 20:
	                        System.out.println("Neparni oko 20");
	                        break;
	                    case 30:
	                        System.out.println("Neparni oko 30");
	                        break;
	                    case 40:
	                        System.out.println("Neparni oko 40");
	                        break;
	                    case 50:
	                        System.out.println("Neparni oko 50");
	                        break;
	                    default:
	                        System.out.println("Neparni manji od 20");
	                        break;
	                }
	            }
	            break;
	    }
	}


	
	}


