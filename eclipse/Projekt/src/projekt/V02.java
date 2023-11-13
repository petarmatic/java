package projekt;

import java.util.function.BinaryOperator;



public class V02 {

	public static void main(String[] args) {
		int in = 328;//1041;//9;
		System.out.println(solution(in));

	}
	
	public static int solution(int n) {
		String bin=Integer.toBinaryString(n);
		int len = bin.length();
		int maxLen = 0;
		int count = 0;
		boolean isCounting = false;
		
		for(int i=0;i<len;i++) {
			if(bin.charAt(i)== '1' && isCounting ==false) {
				isCounting=true;
				count=0;
			}
			if(bin.charAt(i)== '0' && isCounting) {
				count++;
			}
			if(bin.charAt (i)=='1' && isCounting && count>0) {
				isCounting=true;
				if(maxLen<count){
					maxLen=count;
				}count=0;
			}
		}
		
		
		return maxLen;
		
	}

}
