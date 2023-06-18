package edunova;

public class E08Konverzije {

	public static void main(String[] args) {

		// implicitna
		int i = 24;
		double d = i;
		System.out.println(i);

		// eksplicitna

		i = Integer.parseInt(String.valueOf(d));

		// cast
		i = (int) d;

	}

}
