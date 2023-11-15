package projekt;

import java.util.HashMap;
import java.util.Map;

public class V17 {

	public static void main(String[] args) {
		int[] in2 = { 3, 4, 3, 2, 3, -1, 3, 3 };

		int result = solution(in2);
		System.out.println(result);

	}
	
	public static int solution(int []A) {
		
		HashMap<Integer, Integer>hm= new HashMap<Integer, Integer>();
		int dominatorKey = -1;
		int dominatorValue = -1;
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i])) {
				hm.put(A[i], hm.get(A[i]) + 1);
			} else {
				hm.put(A[i], 1);
			}
		}
		if (hm.size() == 0)
			return -1;

		if (hm.size() == 1)
			return 0;

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() > dominatorValue) {
				dominatorKey = entry.getKey();
				dominatorValue = entry.getValue();
			}
		}

		if (dominatorValue > (A.length / 2)) {
			for (int i = 0; i < A.length; i++) {
				if (A[i] == dominatorKey) {
					return i;
				}
			}
		}
		return -1;
		
		
	}

}
