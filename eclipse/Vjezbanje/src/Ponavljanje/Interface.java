package Ponavljanje;



interface I1{
	public void m1();
	public int m2();
}

interface I2{
	void m1();
	String m3();
}


public class Interface implements I1{
	public void m1() {System.out.println("Hi!");}
	
	public int m2() {return 1;}
	}

 class C2 extends Interface implements I2{
	public String m3() {return "Sokrat";}
}
 
 class C3 implements I1, I2{
	 public void m1() {System.out.println("Hello!");}
	 public int m2() {return 2;}
	 public String m3() {return "Aristotel";}
 }
 
 abstract class C4 implements I1,I2{
	 public String m3() {return "G.I.Joe";}
 }

	
	


