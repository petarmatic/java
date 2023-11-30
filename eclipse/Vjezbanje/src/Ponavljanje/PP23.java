package Ponavljanje;

public class PP23 {
	 //Izračunati aritmetičku sredinu parnih prirodnih brojeva do 5.
	public static void main(String[] args) {
		
		double k=0.0;
		double brojac=0.0;
		double sredina = 0.0;
		
		for(int i=1;i<=5;i++) {
			if(i%2==0) {
				k+=i;
				brojac+=1;
			}
		}
		
		sredina=k/brojac;
		System.out.println(sredina);
		
	}
}
