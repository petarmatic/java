package edunova;

public class E02IncrementDecrement {

	public static void main(String[] args) {
		int i=0;
		// increment
		i=i+1; //1
		i+=1; //2
		i++; //3
		++i; //4
		
		//decrement
		i=i-1;//3
		i-=1;//2
		i--;//1
		--i;//0
	
		System.out.println(i);
		
		// i++ prvo koristi vrijednost pa ju uveća
		
		i=1;
		System.out.println(i++); //1
		System.out.println(i); // 2
		
		// ++i prvo ućeva pa onda koristi vrijednost isto i --
		System.out.println(++i); //3
		
		int t=-2,k=0;
		
		t= ++k -t;// k=1, t=0
		System.out.println("k=" +k + ",t=" +t);
		k=--t - t++; // k=0 t=0
		System.out.println("k=" + k + ",t=" + t);
		
		 
	}

}
