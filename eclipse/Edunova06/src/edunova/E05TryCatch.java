package edunova;


public class E05TryCatch {
		
		public static void main(String[] args) {
			
			
			int[] niz = {1,2};
			
			
			
			// iznimke se obrađuju s try catch finally blokom
			try {
				// ovdje se uvijek dolazi
				System.out.println(niz[2]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// ovdje se dolazi ako je iznimka bačena ArrayIndexOutOfBoundsException
				System.out.println("Ideš na index koji ne postoji");
			}catch (NumberFormatException | StackOverflowError e) {
				// ovdje se dolazi ako je iznimka bačena NumberFormatException ili StackOverflowError
				
			}catch (Exception e) {
				// TODO: handle exception
				// Ovaj će uhvatiti sve što nije prethodno navedeno
			}finally {
				// ovdje se uvijek dolazi
			}
			
			// u nastavku ću koristiti
			try {
				System.out.println(niz[2]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}

	
}
