package projekt;
import java.util.*;


	public class V05 {
		public static void main(String[] args) {
			int input[] = {1,3,1,4,2,3,5,4};
			int result = solution(5, input);
			System.out.println (result);
		}
	
	
		public static int solution(int X,int[] A) {
			
			int sec=0;
			Set set=new HashSet();
			
			
			for(int i=0;i<A.length;i++) {
				if(A[i]<=X) {
					set.add(A[i]);
				}
					 if (set.size() == X){               
			                return i;
			            }

			        }
			       return -1;
			}
		}
	
	

		
	    
	
	

