package Ponavljanje;

import java.util.ArrayList;
import java.util.Scanner;

class Proizvod {
			String naziv;
			Double cijena;
			int kolicina;
			
			public Proizvod(String naziv, Double cijena, int kolicina) {
				super();
				this.naziv = naziv;
				this.cijena = cijena;
				this.kolicina = kolicina;
			}
			public double ukupnaVrijednost() {
		        return cijena * kolicina;
		    }
			 @Override
			    public String toString() {
			        return "Proizvod: " + naziv + ", Cijena: " + cijena + " kn, Količina: " + kolicina;
			    }
		}
		
	public class Trgovina {
		public static void main(String[] args) {
			Scanner scan= new Scanner(System.in);
			ArrayList<Proizvod> inventar = new ArrayList<>();
			
			while(true) {
				 System.out.println("Odaberite opciju:");
		            System.out.println("1. Dodaj proizvod");
		            System.out.println("2. Obriši proizvod");
		            System.out.println("3. Ispiši inventar");
		            System.out.println("4. Izračunaj ukupnu vrijednost inventara");
		            System.out.println("5. Izlaz");
		            
			        int opcija= scan.nextInt();
			        scan.nextLine();
		          
			        switch(opcija) {
			        case 1:System.out.print("Unesite naziv proizvoda: ");
                    String naziv = scan.nextLine();
                    System.out.print("Unesite cijenu proizvoda: ");
                    double cijena = scan.nextDouble();
                    System.out.print("Unesite količinu proizvoda: ");
                    int kolicina = scan.nextInt();
                    inventar.add(new Proizvod(naziv, cijena, kolicina));
                    break;
                case 2:
                    System.out.print("Unesite indeks proizvoda za brisanje: ");
                    int indeks = scan.nextInt();
                    if (indeks >= 0 && indeks < inventar.size()) {
                        inventar.remove(indeks);
                    } else {
                        System.out.println("Neispravan indeks.");
                    }
                    break;
                case 3:
                    for (Proizvod proizvod : inventar) {
                        System.out.println(proizvod);
                    }
                    break;
                case 4:
                    double ukupnaVrijednost = 0;
                    for (Proizvod proizvod : inventar) {
                        ukupnaVrijednost += proizvod.ukupnaVrijednost();
                    }
                    System.out.println("Ukupna vrijednost inventara: " + ukupnaVrijednost + " kn");
                    break;
                case 5:
                    System.out.println("Izlaz iz programa.");
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Neispravna opcija. Molimo vas da odaberete ponovno.");
                    break;
            }
			        }
			}
		}
		
			
		

	


