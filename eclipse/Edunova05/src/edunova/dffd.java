package edunova;

import javax.swing.JOptionPane;

public class dffd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean dev=false;
		
		
		int redova= dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		int stupci= dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));
		
		int [] [] matrica= new int [redova] [stupci];
		
		for(int i=0;i<redova;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica [i] [j] + "\t");
			}System.out.println();
		}
		System.out.println("***********************");
//		matrica[redova-1][stupci-1] = 1;
//		matrica[redova-1][stupci-2] = 2;
//		matrica[redova-1][stupci-3] = 3;
//		matrica[redova-1][stupci-4] = 4;
//		matrica[redova-1][stupci-5] = 5;
		//matrica[redova-1][stupci-6] = 6;
		int b = 1;
		for(int i=1;i<=stupci;i++) {
			matrica[redova-1][stupci-i] = b++;
			
		}
		
		for(int i=0;i<redova;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica [i] [j] + "\t");
			}System.out.println();
		}
		System.out.println("***********************");
		
		for(int i=2;i<=redova;i++) {
			matrica[redova-i][0]=b++;
		}
		/*matrica[redova-2][0] = b++;
		matrica[redova-3][0] = b++;
		matrica[redova-4][0] = b++;
		matrica[redova-5][0] = b++;*/
		
		for(int i=0;i<redova;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica [i] [j] + "\t");
			}System.out.println();
		}
		System.out.println("***********************");
		
		for(int i = 1; i < stupci; i++) {
			matrica[0][i]=b++;
		}
		
//		matrica [0] [1] = b++;
//		matrica [0] [2] = b++;
//		matrica [0] [3] = b++;
//		matrica [0] [4] = b++;
		
		
		for(int i=0;i<redova;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica [i] [j] + "\t");
			}System.out.println();
		}
		System.out.println("***********************");
		
		for(int i=1;i<redova-1;i++) {
			matrica[i][stupci-1]=b++;
		}
//		matrica[1][stupci-1]=b++;
//		matrica[2][stupci-1]=b++;
//		matrica[3][stupci-1]=b++;
		
		for(int i=0;i<redova;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica [i] [j] + "\t");
			}System.out.println();
		}
		System.out.println("***********************");

	}

}
