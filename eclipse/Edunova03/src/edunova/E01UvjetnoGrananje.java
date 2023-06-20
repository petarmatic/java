package edunova;

import javax.swing.JOptionPane;

public class E01UvjetnoGrananje {

	public static void main(String[] args) {
		
		boolean uvjet=true;
		// rjeđe
		if (uvjet) {
			System.out.println("1");

	}
	// opcionalno
		else {
			//false grana
			System.out.println("2");
		}
		
		
	
	
	int i = 1;
	// češće susretljiva sintaksa
	if(i>0) {
		System.out.println("3");
		
	}
	// jedna linija nakon if ne trebaju {}, ali uvijek koristit
	
	if(i==0)
		System.out.println("4");
	System.out.println("5");
	
	// boolean i if ne mogu zajedno 
	boolean tocno=true;
	
	if(tocno==true) {
		System.out.println("6");
	}
	
	// korištenje operatora & | !
	
	int t=2;
	int k=3;
	// ugnježđeni if
	if(t!=0) {
		if(k>-8) {
			System.out.println("7");
			
		}
	}
	
	
	// & (and) komada 1 provjera oba uvjeta
	if(t!=0 & k>-8) {
		System.out.println("8");
	}
	
	// mi ćemo koristiti &&
	// && - drugi uvjet ne provjerava ako prvi nije zadovoljen
	if(t!=0 && k>-8) {
		System.out.println("9");
	}
	
	// || (ili) 2 komada ako je prvi zadovoljen ne provjerava se drugi
	
	if(t==2 || k>7) {
		System.out.println("11");
	}
	
	// u nastavku ćemo koristiti
	if(!tocno) {
		System.out.println("12");
	}
	
	int ocjena=5;
	if (ocjena==1) {
		System.out.println("Nedovoljan");
	} else if (ocjena==2) {
		System.out.println("Dovoljan");
	}else if (ocjena==3){
		System.out.println("Dobar");
	} else if (ocjena==4) {
		System.out.println("Vrlo dobar");
	}else if (ocjena==5){
		System.out.println("Odličan");
	}
	
	
	int broj= Integer.parseInt(JOptionPane.showInputDialog("Unesi broj"));
	if (broj%2==0) {
		System.out.println("broj je paran");
	}else {
		System.out.println("broj je neparan");
	}
	
	// tercijarni operator ?
	// inline if
	
	System.out.println("broj je" +(broj%2!=0 ? "ne" : "") + "paran");
		
		
	
		
	}
		
}
