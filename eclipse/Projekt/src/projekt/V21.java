package projekt;

import java.util.ArrayList;

public class V21 {

	public static void main(String[] args) {
		int[] a1 = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
		int result2 = solution(a1);
		System.out.println(result2);

	}
	
	public static int solution(int []A) {
		
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
				peaks.add(i);
			}
		}
		if (peaks.size() <= 1) {
			return peaks.size();
		}
		int maxFlags = (int) Math.ceil(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0)));

		for (int flags = maxFlags; flags > 1; flags--) {

			int startFlagIndex = 0;
			int endFlagIndex = peaks.size() - 1;

			int startFlag = peaks.get(startFlagIndex);
			int endFlag = peaks.get(endFlagIndex);

			int flagsPlaced = 2;

			while (startFlagIndex < endFlagIndex) {
				startFlagIndex++;
				endFlagIndex--;
				if (peaks.get(startFlagIndex) >= startFlag + flags) {
					if (peaks.get(startFlagIndex) <= endFlag - flags) {
						flagsPlaced++;
						startFlag = peaks.get(startFlagIndex);
					}
				}

				if (peaks.get(endFlagIndex) >= startFlag + flags) {
					if (peaks.get(endFlagIndex) <= endFlag - flags) {
						flagsPlaced++;
						endFlag = peaks.get(endFlagIndex);
					}
				}
				if (flagsPlaced == flags) {
					return flags;
		
		
				}
			}
		}
		return 0;
	}
}
				
			
	


