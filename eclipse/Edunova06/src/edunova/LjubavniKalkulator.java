package edunova;

import java.util.Arrays;

public class LjubavniKalkulator {
public static void main(String[] args) {
	
	String ime1 ="Marta";
	String ime2="Manuel";
	String s= ime1.toLowerCase()+ ime2.toLowerCase();
	System.out.println(s);
	
	
	int [] niz= new int[ime1.length() + ime2.length()];
	
	int b;
	char z;
	for(int i=0;i<s.length();i++) {
		z=s.charAt(i);
		b=0;
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j)==z) {
				b++;
			}
		}
		niz[i]=b;	
	}
	System.out.println(Arrays.toString(niz));
	System.out.println(ljubav(niz));
	
}

private static int ljubav (int[] niz) {
	
		if(niz.length<3) {
		String s="";
		for(int i: niz) {
			s+=i;
		}
		if(Integer.parseInt(s)<100) {
			return Integer.parseInt(s);
		}
		int[] noviNiz= {1,2};
			return ljubav(noviNiz);
		}
		return 0;
		
	}
	
	

}

