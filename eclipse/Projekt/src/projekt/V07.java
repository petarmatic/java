package projekt;

import java.util.Arrays;

public class V07 {

	public static void main(String[] args) {
		int input[] = { 1, 3, 6, 4, 1, 2 };
		int result = solution(input);
		System.out.println(result);

	}
	
	public static int solution(int []A) {
		/*
		Arrays.sort(A);
		int counter=0;
		int previous=0;
		
		for(int i=0;i<=A.length;i++) {
			if(A[i]>0) {
				if(previous!=A[i]) {
					counter++;
					if (A[i] != counter) {
						return counter;
					}
				}
				previous = counter;
			}
		}
		if (counter >= 0) {
			return counter + 1;
		}
		return 1;
		*/
		 Arrays.sort(A);

	        int smallestPositive = 1;

	        for (int i = 0; i < A.length; i++) {
	            if (A[i] == smallestPositive) {
	                smallestPositive++;
	            }
	        }

	        return smallestPositive;
			
		
		
	}

}
