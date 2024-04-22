package Ponavljanje;

import java.util.List;

public class Pa2 {
	
	
	
	 public static <T extends Number> int[] izracunajZbroj(List<T> brojevi) {
	        int zbrojParnih = 0;
	        int zbrojNeparnih = 0;

	        for (T broj : brojevi) {
	            int vrijednost = broj.intValue();
	            if (vrijednost % 2 == 0) {
	                zbrojParnih += vrijednost;
	            } else {
	                zbrojNeparnih += vrijednost;
	            }
	        }

	        return new int[]{zbrojParnih, zbrojNeparnih};
	    }
	
	
	
	public static void main(String[] args) {
		
		List<Integer> brojevi = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] zbrojevi = izracunajZbroj(brojevi);
        System.out.println("Zbroj parnih brojeva: " + zbrojevi[0]);
        System.out.println("Zbroj neparnih brojeva: " + zbrojevi[1]);
	}

}
