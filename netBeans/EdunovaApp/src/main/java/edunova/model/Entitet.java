package edunova.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// čitati https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html
// i ovo https://github.com/tjakopec/ORM_JAVA_PHP_CSHARP
// DZ:
// Mapirati klase u javi da dobijemo identičan era kao u edunovajp28 bazi
@MappedSuperclass
public abstract class Entitet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sifra;

    public Entitet() {
    }

    public Entitet(Integer sifra) {
        this.sifra = sifra;
    }

    public Integer getSifra() {
        return sifra;
    }

    public void setSifra(Integer sifra) {
        this.sifra = sifra;
    }

}
