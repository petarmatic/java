package projekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CitanjeSTipkovnice {

	public static void main(String[] args) throws IOException{
		
		
		System.out.println("Program za računanje sume pozitivnih brojeva.");
		System.out.println("Unosite brojeve, jedan po retku");
		System.out.println("Kada unesete negativan broj, ispisat ce se suma.");
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		
		double suma=0.0;
		while (true) {
			String redak= reader.readLine();
			if(redak==null) break;
			double broj=Double.parseDouble(redak);
			if(broj<0) break;
			suma+=broj;
		}
		System.out.println("Suma je: " + suma);
		reader.close();
	
	
	
	}

}
