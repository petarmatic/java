/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author Katedra
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
             Document d = Jsoup.parse(sb.toString());
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();

            //System.out.println(sb.toString());
        } catch (Exception e) {
        }

        return "";
    }
    
}
