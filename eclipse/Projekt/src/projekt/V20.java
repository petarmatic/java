package projekt;

public class V20 {

	public static void main(String[] args) {
		int result2 = solution(51);
		System.out.println(result2);

	}
	
	 public static int solution(int N) {
		 
		 int sq = (int) Math.sqrt(N);

			int factor = 0;
			int perimeter = 0;
			int minPerimeter = Integer.MAX_VALUE;

			if (Math.pow(sq, 2) != N) {
				sq++;
			} else {
				minPerimeter = 2 * (sq + sq);
			}

			for (int i = 1; i < sq; i++) {
				if (N % i == 0) {
					factor = N / i;
					perimeter = 2 * (factor + i);
					minPerimeter = Math.min(perimeter, minPerimeter);
				}
			}
			return minPerimeter;
	 }

}
