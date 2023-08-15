package Ponavljanje;

public class P08 {

	public static void main(String[] args) {
		 int count = 1;
		 
		 for (int i = 0; i < 5; i++) {
			    System.out.println("1Broj: " + i);
			}
		 
		 
	        
	     do {
	            System.out.println("2Broj: " + count);
	            count++;
	        } while (count <= 5);
	     
	     
	     while (count <= 5) {
	    	    System.out.println("3Broj: " + count);
	    	    count++;
	    	}
	     
	     int[] numbers = {1, 2, 3, 4, 5};
	     for (int num : numbers) {
	         System.out.println("4Broj: " + num);
	     }
	     
	     
	     
	    }

	

}
