package edunova;

import java.util.Arrays;
import java.util.Scanner;

public class Ljubavni {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Unesite prvo ime:");
        String ime1 = scan.nextLine();

        System.out.println("Unesite drugo ime:");
        String ime2 = scan.nextLine();

        ime1 = ime1.toLowerCase();
        ime2 = ime2.toLowerCase();

        String s = ime1 + ime2;
        System.out.println(s);

      
}
