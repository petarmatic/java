package Ponavljanje;

import java.util.Scanner;

public class P26 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesi broj redova:");
        int red = unosBroja(input);

        System.out.println("Unesi broj kolona:");
        int kolona = unosBroja(input);

        int[][] niz = new int[red][kolona];

        System.out.println("Unesi clanove matrice(prvo redovi):");

        for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                System.out.print("X[" + i + "," + j + "] --> ");
                niz[i][j] = input.nextInt();
            }
        }

        System.out.println("Matrica:");

        for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                System.out.print(niz[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }

    private static int unosBroja(Scanner scanner) {
        
        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos. Unesi ponovno.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
    

}


	

