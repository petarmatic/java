package projekt;

import java.util.Arrays;

public class V03 {

	public static void main(String[] args) {
		
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 1;
		int[] result = Solution(A, K);
		System.out.println(Arrays.toString(result));
	}

	public static int[] Solution(int[] A, int K) {
		int temp = 0;
		int len = A.length;

		if (len < 1) {
			return A;
		}

		for (int i = 0; i < K; i++) {
			temp = A[len - 1];
			for (int j = A.length - 1; j > 0; j--) {
				A[j] = A[j - 1];
			}
			A[0] = temp;
		}
		return A;
	}

}
