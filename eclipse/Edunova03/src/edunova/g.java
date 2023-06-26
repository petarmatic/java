package edunova;

import java.util.Scanner;

public class g {

	public static void main(String[] args) {
		 System.out.print("Otkucaj tekst: ");
	        Scanner input=new Scanner(System.in);
	        String tekst =input.nextLine();     
	 
	        for (int i = 0; i < tekst.length(); i++) {
	            for (int j = 0; j < tekst.length(); j++)
	                if (i == j)
	                    System.out.print(tekst.charAt(i));
	                else
	                    System.out.print(".");
	            System.out.println();
	}

}
}
