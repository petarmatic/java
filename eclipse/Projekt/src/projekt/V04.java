package projekt;

public class V04 {
	public static void main(String[] args) {
		int result = solution(10, 85, 30);
		System.out.println (result);

	}
	//frog jump from x to y
	public static Integer solution(int X, int Y, int D) {
		int remJump  = Y-X;
		int CountJump = remJump/D;
        int rem = remJump%D;
        if (rem!=0) {
        	CountJump++;
        }
        return CountJump;
		
		
		
		
	}

}
