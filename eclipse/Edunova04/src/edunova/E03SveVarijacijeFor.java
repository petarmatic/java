package edunova;

public class E03SveVarijacijeFor {

	public static void main(String[] args) {
		// 9 različitih načina zbaranja prvih 100 brojeva
		
		int i, s=0; for(i=1;i<=100;i++) s+=i;

//	 int i, s; for(i=1, s=0;i<=100; s+=i, i++);
//
		// int i=1, s=0; for( ; i<=100; i++){ s+=i; }
//
//		 int i, s=0; for(i=1; ; i++){ if(i<=100) s+=i; else break;}
//
//		 int i, s=0; for(i=1;i<=100;){ s+=i; i++;}
//
//		 int i, s=0; for(i=1; ; ){ if(i<=100) {s+=i; i++;} else break;}
//
//		 int i=1, s=0; for( ; i<=100 ; ){ s+=i; i++;}
//
//		  int i=1, s=0; for( ; ; i++){if(i<=100)  s+=i; else break;}
//
//		 int i=1, s=0; for( ;  ; ){if(i<=100) {s+=i; i++;} else break;} 
//		
		
		System.out.println(s);

	}

}
