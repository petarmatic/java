package edunova;

import java.util.Arrays;

public class E03Nizovi {
	public static void main(String[] args) {
		// temperature za 12 mjeseci
		
		int t1=2;
		int t2=3;
		int t3=4;
		int t4=8;
		int t5=15;
		int t6=28;
		int t7=32;
		int t8=37;
		int t9=29;
		int t10=19;
		int t11=8;
		int t12=2;
		
		// niz/polje/arrays
		
		// deklariranje
		int [] niz;
		String drugiNiz[];
		// konstruiranje niza
		niz=new int[4];
		
		// korištenje nizova
		// na 1.mjesto u nizu
		niz[0]=2;
		niz[1]=4; niz[2]=7;
		// na zadnje 
		niz[niz.length-1]=8;
		// ispiši broj 7
		System.out.println(niz[2]);
		
		// ispisat nizove
		System.out.println(Arrays.toString(niz));
		
		// skraćeno
		int brojevi[]= {2,6,4,8,22,55};
		// ispiši broj 22, koji je četvrti po nizu a počinje s 0,1,2,3
		System.out.println(brojevi[4]);
		
		
		// dvodimenzionalni niz
		int matrica[][]= new int[10][10];
		
		int tablica[][]= {
				{0,1,2},
				{3,4,5},
				{7,8,4}
		};
		
		// ispiši broj 5
		System.out.println(tablica[1][2]);
		
		// trodimenzionalni niz
		int kocka [][][]= new int[10][10][10];
		
	
	
	}

}
