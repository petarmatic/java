package projekt;

public class V19 {

	public static void main(String[] args) {
		int result2 = solution(12);
		System.out.println(result2);

	}
	
	public static int solution(int N) {
		
		int faktor=0;
		int sq=(int) Math.sqrt(N);
		if (Math.pow(sq, 2) != N) {
			sq++;
		} else {
			faktor++;
		}
		
		for (int i = 1; i < sq; i++) {
			if (N % i == 0) {
				faktor += 2;
			}
		}
		return faktor;
		
		
	}

}
