package edunova;

import javax.swing.JOptionPane;

public class CiklicnaMatrica {

		 public static void main(String[] args) {
			 
		        boolean dev = false;

		        int redovi = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		        int stupci = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));

		        int[][] matrica = new int[redovi][stupci];

		        int v = 1;

		        int minred = 0;
		        int maxred = redovi - 1;

		        int minstup = 0;
		        int maxstup = stupci - 1;

		        while (v <= redovi * stupci) {
		            // 1
		            for (int i = maxstup; i >= minstup; i--) {
		                matrica[maxred][i] = v++;
		            }
		            maxred--;

		            // 2
		            for (int i = maxred; i >= minred; i--) {
		                matrica[i][minstup] = v++;
		            }
		            minstup++;

		            // 3
		            for (int i = minstup; i <= maxstup; i++) {
		                matrica[minred][i] = v++;
		            }
		            minred++;

		            // 4
		            for (int i = minred; i <= maxred; i++) {
		                matrica[i][maxstup] = v++;
		            }
		            maxstup--;
		        }

		        for (int i = 0; i < redovi; i++) {
		            for (int j = 0; j < stupci; j++) {
		                System.out.print(matrica[i][j] + "\t");
		            }
		            System.out.println();
		        }
		    }
		}




