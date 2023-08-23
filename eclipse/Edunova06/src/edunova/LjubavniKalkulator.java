package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class LjubavniKalkulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("unesi prvo ime:");
        String ime1 = scanner.nextLine();

        System.out.println("unesi drugo ime:");
        String ime2 = scanner.nextLine();

        String s = ime1.toLowerCase() + ime2.toLowerCase();

        System.out.println(s);

        int[] niz = new int[ime1.length() + ime2.length()];

        int b;
        char z;
        for (int i = 0; i < s.length(); i++) {
            z = s.charAt(i);
            b = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == z) {
                    b++;
                }
            }
            niz[i] = b;
        }
        System.out.println(Arrays.toString(niz));

        int[] zbrojNiza = new int[niz.length / 2 + 1];
        zbrojNiza(niz, zbrojNiza, 0, niz.length - 1, 0);

        System.out.println(Arrays.toString(zbrojNiza));

        int[] razdvojeniNiz = razdvajanje(zbrojNiza);
        System.out.println(Arrays.toString(razdvojeniNiz));
        
        int[] razdvojeniZbrojNiza = zbrojDvoznamenkastih(razdvojeniNiz);
        System.out.println(Arrays.toString(razdvojeniZbrojNiza));
        
        int[] zadnjiZbrojNiza = zbrojRazdvojenogNiza(razdvojeniZbrojNiza);
        
        int ljubavniBroj = zadnjiZbrojNiza[0] * 10 + zadnjiZbrojNiza[1];
        System.out.println("Ljubavni broj: " + ljubavniBroj);
    }
        
        private static void zbrojNiza(int[] ulazniNiz, int[] izlazniNiz, int lijeviIndeks, int desniIndeks, int k) {
            if (lijeviIndeks <= desniIndeks) {
                if (lijeviIndeks == desniIndeks) {
                    izlazniNiz[k] = ulazniNiz[lijeviIndeks];
                } else {
                    izlazniNiz[k] = ulazniNiz[lijeviIndeks] + ulazniNiz[desniIndeks];
                }
                zbrojNiza(ulazniNiz, izlazniNiz, lijeviIndeks + 1, desniIndeks - 1, k + 1);
            }
        }

        private static int[] razdvajanje(int[] niz) {
            int b = 0;
            for (int i : niz) {
                if (i < 10) {
                    b++;
                }
            }
            int[] matrica = new int[b];
            int j = 0;
            for (int i : niz) {
                if (i < 10) {
                    matrica[j++] = i;
                } else {
                    matrica[j++] = i / 10;
                    matrica[j++] = i % 10;
                }
            }

            return matrica;
        }

        private static int[] zbrojDvoznamenkastih(int[] niz) {
            int[] noviNiz = new int[niz.length / 2 + 1];
            int lijeviIndeks = 0;
            int desniIndeks = niz.length - 1;
            int k = 0;

            while (lijeviIndeks <= desniIndeks) {
                if (lijeviIndeks == desniIndeks) {
                    noviNiz[k++] = niz[lijeviIndeks];
                } else {
                    int zbroj = niz[lijeviIndeks] + niz[desniIndeks];
                    if (zbroj >= 10) {
                        noviNiz[k++] = zbroj / 10;
                        noviNiz[k++] = zbroj % 10;
                    } else {
                        noviNiz[k++] = zbroj;
                    }
                }
                lijeviIndeks++;
                desniIndeks--;
            }

            return noviNiz;
        }

        private static int[] zbrojRazdvojenogNiza(int[] niz) {
            int[] noviNiz = new int[niz.length / 2 + 1];
            int lijeviIndeks = 0;
            int desniIndeks = niz.length - 1;
            int k = 0;

            while (lijeviIndeks <= desniIndeks) {
                if (lijeviIndeks == desniIndeks) {
                    noviNiz[k++] = niz[lijeviIndeks];
                } else {
                    int zbroj = niz[lijeviIndeks] + niz[desniIndeks];
                    if (zbroj >= 10) {
                        noviNiz[k++] = zbroj;
                        		  noviNiz[k++] = zbroj / 10;
                        noviNiz[k++] = zbroj % 10;
                    } else {
                        noviNiz[k++] = zbroj;
                    }
                }
                lijeviIndeks++;
                desniIndeks--;
            }

            return noviNiz;
        }
    }
    
