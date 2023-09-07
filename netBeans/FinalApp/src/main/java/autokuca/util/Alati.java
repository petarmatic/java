/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author petar
 */
public class Alati {
    public static String getOib(){
         try {
            //https://stackoverflow.com/questions/8616781/how-to-get-a-web-pages-source-code-from-java
             URI uri = new URI("http://oib.itcentrala.com/oib-generator/");
             BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            uri.toURL().openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            //   /html/body/div[1]/div[1]/text()
             Document d = (Document) Jsoup.parse(sb.toString());
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate((Element) d).get();

            //System.out.println(sb.toString());
        } catch (Exception e) {
        }

        return "";
    }
    
    /**
     * Provjera valjanosti OIB broja
     * https://regos.hr/app/uploads/2018/07/KONTROLA-OIB-a.pdf
     * @param oib String bilo koje dužine
     * @return true ako je valjan, false ako nije valjan
     */
    public static boolean isValjanOIB(String oib){
        if(oib==null || oib.length() != 11) {
            return false;
        }
        char[] chars = oib.toCharArray();
        int a = 10;
        for (int i = 0; i < 10; i++) {
        	char c = chars[i];
        	if (c < '0' || c > '9') {
        		return false;
        	}
            a = a + (c - '0');
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;
        return (kontrolni == (chars[10] - '0'));
    }
    
}
