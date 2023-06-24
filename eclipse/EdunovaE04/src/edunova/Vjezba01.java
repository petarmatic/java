package edunova;

public class Vjezba01 {

	public static void main(String[] args) {
		 int i = 11;
         
	        i = i++ + ++i;
	         
	        System.out.println(i);
	        
	        
	      int a=11, b=22, c;
	         
	        c = a + b + a++ + b++ + ++a + ++b;
	         
	        System.out.println("a="+a);
	        System.out.println("b="+b);
	        System.out.println("c="+c);
	        
	        
	       int j =0;
	         
	        j = j++ - --j + ++j - j--;
	         
	        System.out.println(i);
	       
	        int l=1, m=2, k=3;
	         
	        int n = l-- - m-- - k--;
	         
	        System.out.println("l="+l);
	        System.out.println("m="+m);
	        System.out.println("k="+k);
	        System.out.println("n="+n);
	        
	        int f=1, g=2;
	         
	        System.out.println(--g - ++f + ++g - --f);
	        
	        int p=19, o=29, u;
	         
	        u = p-- - p++ + --o - ++o + --p - o-- + ++p - o++;
	         
	        System.out.println("p="+p);
	        System.out.println("o="+o);
	        System.out.println("u="+u);
		
	}

}
