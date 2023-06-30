package edunova;

import javax.swing.JOptionPane;

public class E04CM {

	public static void main(String[] args) {
		int redovi=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		int stupci=Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));
		
		int [][] matrica= new int [redovi][stupci];
		
		
		 int b=1;
		 
		 for(int i=1;i<=redovi;i++)
				matrica[redovi-1][stupci-i]=b++;
		 
//		 matrica[redovi-2][0]=6;
//		 matrica[redovi-3][0]=7;
//		 matrica[redovi -4][0]=8;
		 
		 
		 for(int i=2;i<=stupci;i++)
			 matrica[redovi-i][0]=b++;

		for(int i=0;i<redovi;i++) {
			for(int j=0;j<stupci;j++) {
				System.out.print(matrica[i][j] +"\t");
			}
			System.out.println();
		}
		
		
			
	}
		}


