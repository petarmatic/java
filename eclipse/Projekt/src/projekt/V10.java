package projekt;

public class V10 {

	public static void main(String[] args) {
		int result = solution(6,11,2);
		System.out.println(result);

	}
	
	public static int solution(int A, int B, int K) {
		
		int firstCount=0;
		int allCount=0;
		
		
		if (B==0)
            return 1;
        if (A>1){    
           firstCount = (A-1)/K;
        }
       allCount = B/K;
       if (A==0)
            allCount++;
       return allCount-firstCount;
		
	}

}
