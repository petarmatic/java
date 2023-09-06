/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edunova;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edunova.controller.ObradaSmjer;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import edunova.util.PocetniInsert;
import java.util.List;

/**
 *
 * @author Katedra
 */
public class Start {

    public static void main(String[] args) {
        
       // HibernateUtil.getSession();
       //new PocetniInsert();
       
       // System.out.println(new Gson().toJson(new ObradaSmjer().read()));

       String json="[{\"naziv\":\"skoda\",\"cijena\":1145,\"upisnina\":106,\"trajanje\":295,\"verificiran\":true},{\"naziv\":\"audi\",\"cijena\":1429,\"upisnina\":91,\"trajanje\":235,\"verificiran\":true},{\"naziv\":\"bemve\",\"cijena\":1189,\"upisnina\":63,\"trajanje\":315,\"verificiran\":false},{\"naziv\":\"fića\",\"cijena\":1037,\"upisnina\":63,\"trajanje\":237,\"verificiran\":true},{\"naziv\":\"peglica\",\"cijena\":1145,\"upisnina\":54,\"trajanje\":149,\"verificiran\":true},{\"naziv\":\"stojadin\",\"cijena\":975,\"upisnina\":66,\"trajanje\":304,\"verificiran\":true},{\"naziv\":\"ajkula\",\"cijena\":1124,\"upisnina\":59,\"trajanje\":276,\"verificiran\":false},{\"naziv\":\"drakula\",\"cijena\":1403,\"upisnina\":104,\"trajanje\":170,\"verificiran\":false},{\"naziv\":\"linda\",\"cijena\":1526,\"upisnina\":78,\"trajanje\":132,\"verificiran\":true},{\"naziv\":\"pc\",\"cijena\":1413,\"upisnina\":59,\"trajanje\":227,\"verificiran\":false},{\"naziv\":\"Yeti\",\"cijena\":1344,\"upisnina\":101,\"trajanje\":156,\"verificiran\":true},{\"naziv\":\"skala\",\"cijena\":977,\"upisnina\":58,\"trajanje\":208,\"verificiran\":false},{\"naziv\":\"polo\",\"cijena\":1111,\"upisnina\":59,\"trajanje\":92,\"verificiran\":true},{\"naziv\":\"golf\",\"cijena\":1307,\"upisnina\":98,\"trajanje\":173,\"verificiran\":false},{\"naziv\":\"passat\",\"cijena\":1111,\"upisnina\":82,\"trajanje\":343,\"verificiran\":false},{\"naziv\":\"truhlo\",\"cijena\":1374,\"upisnina\":116,\"trajanje\":170,\"verificiran\":true},{\"naziv\":\"gas\",\"cijena\":1240,\"upisnina\":55,\"trajanje\":127,\"verificiran\":false,\"sifra\":53},{\"naziv\":\"terenac\",\"cijena\":1216,\"upisnina\":99,\"trajanje\":281,\"verificiran\":true},{\"naziv\":\"ford\",\"cijena\":978,\"upisnina\":65,\"trajanje\":98,\"verificiran\":true},{\"naziv\":\"mercedes benz\",\"cijena\":1348,\"upisnina\":101,\"trajanje\":250,\"verificiran\":true},{\"naziv\":\"amg\",\"cijena\":1360,\"upisnina\":57,\"trajanje\":231,\"verificiran\":true},{\"naziv\":\"gt4\",\"cijena\":1080,\"upisnina\":116,\"trajanje\":278,\"verificiran\":true},{\"naziv\":\"Hasaki main\",\"cijena\":1257,\"upisnina\":106,\"trajanje\":257,\"verificiran\":true},{\"naziv\":\"yasuo\",\"cijena\":1297,\"upisnina\":76,\"trajanje\":159,\"verificiran\":false},{\"naziv\":\"zed\",\"cijena\":1137,\"upisnina\":86,\"trajanje\":310,\"verificiran\":true},{\"naziv\":\"Pantheon\",\"cijena\":933,\"upisnina\":80,\"trajanje\":322,\"verificiran\":true},{\"naziv\":\"vi\",\"cijena\":1179,\"upisnina\":106,\"trajanje\":329,\"verificiran\":true},{\"naziv\":\"amdd\",\"cijena\":1298,\"upisnina\":79,\"trajanje\":313,\"verificiran\":false},{\"naziv\":\"intel\",\"cijena\":1510,\"upisnina\":70,\"trajanje\":278,\"verificiran\":true},{\"naziv\":\"xiaomi\",\"cijena\":1116,\"upisnina\":66,\"trajanje\":111,\"verificiran\":true},{\"naziv\":\"šaomi\",\"cijena\":1230,\"upisnina\":60,\"trajanje\":282,\"verificiran\":false},{\"naziv\":\"žaomi\",\"cijena\":1150,\"upisnina\":111,\"trajanje\":101,\"verificiran\":true},{\"naziv\":\"nesto\",\"cijena\":1446,\"upisnina\":78,\"trajanje\":335,\"verificiran\":true},{\"naziv\":\"novo ime\",\"cijena\":1342,\"upisnina\":76,\"trajanje\":146,\"verificiran\":true},{\"naziv\":\"šaran\",\"cijena\":1193,\"upisnina\":74,\"trajanje\":295,\"verificiran\":true},{\"naziv\":\"štuka\",\"cijena\":1088,\"upisnina\":86,\"trajanje\":286,\"verificiran\":true},{\"naziv\":\"linjak\",\"cijena\":1384,\"upisnina\":71,\"trajanje\":281,\"verificiran\":false},{\"naziv\":\"som\",\"cijena\":1458,\"upisnina\":97,\"trajanje\":253,\"verificiran\":false},{\"naziv\":\"linda pas\",\"cijena\":1178,\"upisnina\":99,\"trajanje\":223,\"verificiran\":false},{\"naziv\":\"hans\",\"cijena\":1334,\"upisnina\":98,\"trajanje\":215,\"verificiran\":true},{\"naziv\":\"rex\",\"cijena\":1116,\"upisnina\":105,\"trajanje\":111,\"verificiran\":false},{\"naziv\":\"neptun\",\"cijena\":1506,\"upisnina\":104,\"trajanje\":184,\"verificiran\":true},{\"naziv\":\"grabovac\",\"cijena\":1541,\"upisnina\":88,\"trajanje\":111,\"verificiran\":false},{\"naziv\":\"metropola\",\"cijena\":1485,\"upisnina\":73,\"trajanje\":141,\"verificiran\":true},{\"naziv\":\"baranja\",\"cijena\":1444,\"upisnina\":104,\"trajanje\":333,\"verificiran\":true},{\"naziv\":\"petar\",\"cijena\":1218,\"upisnina\":72,\"trajanje\":302,\"verificiran\":true},{\"naziv\":\"pero\",\"cijena\":1016,\"upisnina\":90,\"trajanje\":212,\"verificiran\":false},{\"naziv\":\"genuis\",\"cijena\":1386,\"upisnina\":96,\"trajanje\":321,\"verificiran\":true},{\"naziv\":\"futurta\",\"cijena\":1130,\"upisnina\":54,\"trajanje\":337,\"verificiran\":false},{\"naziv\":\"aaaaa\",\"cijena\":1153,\"upisnina\":94,\"trajanje\":324,\"verificiran\":true},{\"naziv\":\"bbb\",\"cijena\":1221,\"upisnina\":109,\"trajanje\":119,\"verificiran\":false},{\"naziv\":\"dinamo\",\"cijena\":980,\"upisnina\":97,\"trajanje\":227,\"verificiran\":false},{\"naziv\":\"osijek\",\"cijena\":1225,\"upisnina\":57,\"trajanje\":285,\"verificiran\":false},{\"naziv\":\"hajudk\",\"cijena\":1066,\"upisnina\":74,\"trajanje\":156,\"verificiran\":true},{\"naziv\":\"lokomotiva\",\"cijena\":1479,\"upisnina\":94,\"trajanje\":222,\"verificiran\":false},{\"naziv\":\"kohorta\",\"cijena\":931,\"upisnina\":59,\"trajanje\":191,\"verificiran\":false},{\"naziv\":\"torcida\",\"cijena\":1453,\"upisnina\":54,\"trajanje\":307,\"verificiran\":true},{\"naziv\":\"slaven belupo\",\"cijena\":933,\"upisnina\":106,\"trajanje\":255,\"verificiran\":true},{\"naziv\":\"istra\",\"cijena\":1429,\"upisnina\":83,\"trajanje\":110,\"verificiran\":false},{\"naziv\":\"vinkovci\",\"cijena\":1280,\"upisnina\":82,\"trajanje\":96,\"verificiran\":true}]";
       
       List<Smjer> lista= new Gson().fromJson(json, new TypeToken<List<Smjer>>(){}.getType());
    
        
        ObradaSmjer os = new ObradaSmjer();
        
        for(Smjer s : lista){
            os.setEntitet(s);
            try {
                os.create();
            } catch (EdunovaException ex) {
                System.out.println(ex.getPoruka());
            }
        }
    }
}
            
    

