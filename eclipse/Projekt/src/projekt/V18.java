package projekt;

import java.util.Arrays;
import java.util.HashMap;

public class V18 {

	public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution(nums1, target1);
        System.out.println(Arrays.toString(result1));
    }

    public static int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

       
        return new int[]{};
		
	}

}
