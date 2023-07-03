package edunova;

import javax.swing.JOptionPane;

public class jhgjg {
	
		
		public static void main(String[] args) {

			boolean dev = false;

			int red = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
			int stup = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));

			int[][] matrica = new int[red][stup];
			int b = 1;

			// zadnji red
			for (int i = 1; i <= stup; i++) {
				matrica[red - 1][stup - i] = b++;
			}
			// prvi stup
			for (int i = 2; i <= red; i++) {
				matrica[red - i][0] = b++;
			}
			// prvi red
			for (int i = 1; i < stup; i++) {
				matrica[0][i] = b++;
			}
			// zadnji stup
			for (int i = 1; i < red - 1; i++) {
				matrica[i][stup - 1] = b++;
			}

			
			
			// zadnji red
			for (int i = 2; i < stup; i++) {
				matrica[red - 2][stup - i] = b++;
			}
			// prvi stup
			for (int i = 3; i < red; i++) {
				matrica[red - i][1] = b++;
			}
			// prvi red
			for (int i = 2; i < stup-i; i++) {
				matrica[1][i] = b++;
			}
			// zadnji stup
			for (int i = 2; i < red - 2; i++) {
				matrica[i][stup - 2] = b++;
			}

			
			
			for (int i = 0; i < red; i++) {
				for (int j = 0; j < stup; j++) {
					System.out.print(matrica[i][j] + "\t");
				}
				System.out.println();
			}
		}
	}

    





