package Ponavljanje;

import javax.swing.JOptionPane;

public class P12 {

	public static void main(String[] args) {

		int red = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova:"));
		int stup = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupova"));

		int[][] matrica = new int[red][stup];

		int b = 1;
		int minred = 0;
		int maxred = red - 1;
		int minstup = 0;
		int maxstup = stup - 1;

		while (b <= red * stup) {
			// 1
			for (int i = maxstup; i >= minstup && b <= red * stup; i--) {
				matrica[maxred][i] = b++;
			}
			maxred--;
			// 2
			for (int i = maxred; i >= minred && b <= red * stup; i--) {
				matrica[i][minstup] = b++;
			}
			minstup++;
			// 3
			for (int i = minstup; i <= maxstup && b <= red * stup; i++) {
				matrica[minred][i] = b++;

			}
			minred++;
			// 4
			for (int i = minred; i <= maxred && b <= red * stup; i++) {
				matrica[i][maxstup] = b++;

			}
			maxstup--;

		}
		for (int i = 0; i < red; i++) {
			for (int j = 0; j < stup; j++) {
				System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();

		}

	}

}
