package edunova;

public class E02UvjetnoGrananjeSwitch {

	public static void main(String[] args) {
		int ocjena = 6;

		if (ocjena == 1) {
			System.out.println("Nedovoljan");
		} else if (ocjena == 2) {
			System.out.println("Dovoljan");
		} else {
			System.out.println("Nije ocjena");
		}
		
		//switch
		
		switch(ocjena) {
		case 1:
			System.out.println("Nedovoljan");
			break;
			
		case 2 :
			System.out.println("Dovoljan");
			break;
			
		case 3:
			System.out.println("Dobar");
			break;
			
		case 4:
			System.out.println("Vrlo Dobar");
			break;
		case 5:
			System.out.println("Odličan");
			break;
		default:
			System.out.println("Nije ocjenaa");
			
		}
		
		
		
		String grad="Osijek";
		switch(grad) {
		case "Osijek":
			System.out.println("Najbolji grad");
			break;
		default:
			System.out.println("Svi drugi");
		}
		
		
		char c='Q';
		
		switch(c) {
		case 'Q':
			System.out.println("Slovo Q");
		}
		

	}

}
