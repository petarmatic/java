package edunova;

import javax.swing.JOptionPane;

public class E04CM {

	public static void main(String[] args) {
		boolean dev=false;
		
		int redovi = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj redova"));
		int stupci = dev ? 5 : Integer.parseInt(JOptionPane.showInputDialog("Unesi broj stupaca"));

		int[][] matrica = new int[redovi][stupci];

		int v = 1;
		
		int minred = 1;
        int maxred = redovi;

        int minstup = 1;
        int maxstup = stupci;

       
        while (v<=stupci*redovi) {
        	//1
            for (int i = minstup; i <=maxstup; i++) {
                matrica[maxred-minred][maxstup-i] = v++;
            }
            if(v>stupci*redovi) {
            break;
            }
            minred++;
           // 2
            for(int i=minred;i<=maxred;i++) {
            	matrica [maxred-i][maxstup-minstup]=v++; 	
            }
            if(v>stupci*redovi) {
            	break;
            }
            maxstup--;
           
//           //3
//            for(int i=minstup;i<=maxstup-minstup;i++) {
//            	matrica[maxred-minred][i]=v++;
//            }
//            if(v>stupci*redovi) {
//            	break;
//            }
//            maxstup--;
//            //4
//            for(int i=minred-1;i<=maxred-minred;i++) {
//            	matrica[i][maxstup]=v++;
//            }
//            if(v>stupci*redovi) {
//            	break;
//            }
//            
//            
//            minstup++;
            
            
           
        } 
    		
        for (int i = 0; i < redovi; i++) {
            for (int j = 0; j < stupci; j++) {
                	System.out.print(matrica[i][j] + "\t");
            	}System.out.println();
        	}
    }
	
    }
	

