package edunova;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pomocno {
	public static Scanner ulaz;
	public static boolean DEV;
	private static final String FORMAT_DATUMA="dd. MM. yyyy.";
	private static SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUMA);

	
		
	public static int unosRasponBroja(String poruka, String greska, int min, int max) {
		int i;
		while (true) {
			try {
				System.out.print(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if (i >= min && i <= max) {
					return i;
				}
				System.out.println(greska);
			} catch (Exception e) {
				System.out.println(greska);
			}
		}
			
		}

	public static String unosString(String poruka, String greska) {
		// TODO Auto-generated method stub
		String s=" ";
		while(true) {
			System.out.println(poruka);
			s=ulaz.nextLine();
			if(s.trim().length()>0) {
			return s;
			}
			System.out.println(greska);
		}
	}
	
	public static float unosFloat(String poruka, String greska) {
		while(true) {
			try {
				System.out.println(poruka);
				return Float.parseFloat(ulaz.nextLine());
			}catch(Exception e) {
				System.out.println(greska);
			}
			
			
		}
		
	}
	
	public static boolean unosBoolean(String poruka) {
		System.out.println(poruka);
		return ulaz.nextLine().trim().toLowerCase().equals("da") ? true:false;
		
	}
	public static Date unosDatum(String poruka) {
		while (true) {
			try {
				System.out.print(poruka);
				return df.parse(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Obavezan unos datuma u formatu " + FORMAT_DATUMA + ", npr. " + df.format(new Date()) + " za danas.");
			}
		}

	}

}
