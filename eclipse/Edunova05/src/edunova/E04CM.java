package edunova;

import javax.swing.JOptionPane;

public class E04CM {

	public static void main(String[] args) {
		int redovi = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		int stupci = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));

		int[][] matrica = new int[redovi][stupci];

		int v = 1;
		int minred = 0;
		int maxred = redovi - 1;

		int minstup = 0;
		int maxstup = stupci - 1;

		while (v <= redovi * stupci) {
			for (int i = minred; i <= maxred; i++) {
				matrica [i][0]=v++;
			}
			
		}
			

		
		

		for (int i = 0; i < redovi; i++) {
			for (int j = 0; j < stupci; j++) {
				System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();
		}
		}
	}



