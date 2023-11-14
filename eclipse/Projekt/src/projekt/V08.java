package projekt;

import java.util.Arrays;

public class V08 {

	public static void main(String[] args) {
		int input[] = { 3, 4, 4, 6, 1, 4, 4 };
		int[] result = solution(5, input);
		System.out.println(Arrays.toString(result));

	}
	public static int[] solution(int N, int[] A) {
		
		int[] arr = new int[N];
		int maxCounter = 0;
		int newVal = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == N + 1) {
				for (int a = 0; a < arr.length; a++) {
					arr[a] = maxCounter;
				}
			} else if (A[i] <= N) {
				newVal = arr[A[i] - 1] + 1;
				arr[A[i] - 1] = newVal;
				if (maxCounter < newVal) {
					maxCounter = newVal;
				}
			}
		}
		return arr;
			
		
	}

}
