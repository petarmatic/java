package projekt;

import java.util.Stack;

public class V15 {

	public static void main(String[] args) {
		//String in2 = "fsds fsdf( sdfsd ) dfsdf sd(dsfsd)fsdfsdf sdf(fsdfsd(sfsd f)fsdf(sfsdf fds)";
		String in2 = "(()(())())";
		int result = solution(in2);
		System.out.println(result);

	}
	
	 public static int solution(String S) {
		 
		 Stack<Character> stack = new Stack<Character>();
		 for(int i=0; i<S.length(); i++){
			 char c = S.charAt(i);
			 if (c == '('){
	               stack.push(c);
			 }else if(c ==')'){
	               if(stack.size() ==0) {    
	                   return 0;
	               }else {
	            	   stack.pop();
	               }
			 }
		 }
		 
		 
		 if(stack.size()==0){
		       return 1;
		       }else{
		           return 0;
		       }
	 }
		 

}
