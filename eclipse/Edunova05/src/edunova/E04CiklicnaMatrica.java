package edunova;

import javax.swing.JOptionPane;

public class E04CiklicnaMatrica {

	public static void main(String[] args) {
		// treba 5x5

		

		int redovi = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		int stupci = Integer.parseInt(JOptionPane.showInputDialog("unesi broj stupaca"));

		int[][] matrica = new int[redovi][stupci];

		for(int i = 0; i < redovi; i++) {
			for(int j = 0; j < stupci; j++) {
			 System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();
			
		}
		System.out.println("*********");
		
//		matrica[redovi -1][stupci -1]=1;
//		matrica[redovi -1][stupci -2]=2;
//		matrica[redovi -1][stupci -3]=3;
//		matrica[redovi -1][stupci -4]=4;
		
		int b=1;
		for(int i=1;i<=stupci;i++) {
			matrica [redovi-1][stupci -i] =b++;
			
		}
		for(int i = 0; i < redovi; i++) {
			for(int j = 0; j < stupci; j++) {
			 System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();
			
		}
		System.out.println("*********");
		
		for(int i=2;i<=redovi;i++) {
			matrica [redovi-i][0]=b++;
		}
	
	for(int i = 0; i < redovi; i++) {
		for(int j = 0; j < stupci; j++) {
		 System.out.print(matrica[i][j] + "\t");
		}
		System.out.println();
	}
	System.out.println("***********");
	
	
	
	
	for (int i=1;i<stupci;i++) {
		matrica [0][i]=b++;
	}
	for(int i = 0; i < redovi; i++) {
		for(int j = 0; j < stupci; j++) {
		 System.out.print(matrica[i][j] + "\t");
		}
		System.out.println();
		
	}
	System.out.println("*********");
	}
}
	

