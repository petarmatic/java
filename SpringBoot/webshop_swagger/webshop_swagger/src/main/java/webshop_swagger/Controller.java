package webshop_swagger;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class Controller {
    
     @GetMapping("/get")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Dobrodošli na webshop",HttpStatus.OK);
    }
    
    
    @PostMapping("/post")
    public ResponseEntity<String> post(
    @RequestParam (required = true) String naziv,
    @RequestParam (required = false) int broj
    ){
        return new ResponseEntity<>("Primio " + naziv + " i " + broj,HttpStatus.CREATED);
    }
    
    @PutMapping("/put")
    public ResponseEntity<String> put(
    @RequestParam (required = true) int sifra,
    @RequestParam (required = true) String naziv,
    @RequestParam (required = false) int broj
    ){
        return new ResponseEntity<>("Promjenjeno "+ naziv + " i " + broj + " na " + sifra,HttpStatus.OK);
    }
    
     @DeleteMapping("/delete")
    public ResponseEntity<String> delete(
    @RequestParam (required = true) int sifra
    ){
        return new ResponseEntity<>("Obrisano " + sifra,HttpStatus.OK);
    }

    
}
