package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class LK {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("unesi prvo ime:");
		String ime1= scanner.nextLine();
		
		System.out.println("unesi drugo ime:");
		String ime2= scanner.nextLine();
		
		String s= ime1.toLowerCase() + ime2.toLowerCase();
		
		System.out.println(s);
		
		int [] niz = new int [ime1.length()+ime2.length()];
		System.out.println(niz);
		
		int b;
		char z;
		for(int i=0;i<s.length();i++) {
			z=s.charAt(i);
			b=0;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)==z) {
					b++;
				}
			}
			niz[i]=b;	
		}
		System.out.println(Arrays.toString(niz));
		
		int[] zbrojNiza = new int[niz.length / 2 + 1];
        zbrojNiza(niz, zbrojNiza, 0, niz.length - 1, 0);

        System.out.println(Arrays.toString(zbrojNiza));
    }
		
		private static int[] zbrojNiza(int[] ulazniNiz, int[] izlazniNiz, int lijeviIndeks, int desniIndeks, int k ) {
			if(lijeviIndeks <=desniIndeks) {
				if(lijeviIndeks == desniIndeks) {
					izlazniNiz[k]=ulazniNiz[lijeviIndeks];
				}else {
					izlazniNiz[k]= ulazniNiz[lijeviIndeks] + ulazniNiz[desniIndeks];
				}
				zbrojNiza(ulazniNiz, izlazniNiz, lijeviIndeks +1, desniIndeks-1, k+1);
			}
			
			 private static int[] razdvajanje(int[] niz) {
			        int b = 0;
			        for (int i : niz) {
			            if (i < 10) {
			                b++;
			            }
			        }
			        int[] matrica = new int[niz.length + b];
			        for (int i = 0, j = 0; i < niz.length; i++) {
			            if (niz[i] < 10) {
			                matrica[j++] = niz[i];
			            } else {
			                matrica[j++] = niz[i] / 10;
			                matrica[j++] = niz[i] % 10;
			            }
			        }

			        return matrica;
			    }
			
		
			
		


		
			
			
			
			
			
		// drugi korak
//		 int lijeviIndeks = 0;
//	        int desniIndeks = niz.length - 1;
//	        int[] zbrojNiza = new int[niz.length / 2 + 1];
//	        int k = 0;
//
//	        while (lijeviIndeks <= desniIndeks) {
//	            if (lijeviIndeks == desniIndeks) {
//	                zbrojNiza[k++] = niz[lijeviIndeks];
//	            } else {
//	                zbrojNiza[k++] = niz[lijeviIndeks] + niz[desniIndeks];
//	            }
//	            lijeviIndeks++;
//	            desniIndeks--;
//	        }
//
//	        System.out.println(Arrays.toString(zbrojNiza));
		
	    }
	}
	

			
		
	
	
