package mcdonalds;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;

@Named
@Stateless
public class HinnastonLuoja {
    private Part tiedosto;
    private Tuoteryhmä viimeisinTuoteryhmä;
    
    @PersistenceContext
    EntityManager em;
    
    public Part getTiedosto() {
        return tiedosto;
    }

    public void setTiedosto(Part tiedosto) {
        this.tiedosto = tiedosto;
    }
    
    public String vie() throws IOException {
        ZipInputStream zs = 
                new ZipInputStream(tiedosto.getInputStream());
        ZipEntry ze;
        while ((ze = zs.getNextEntry()) != null) {
            if (ze.getName().equals("mcdonaldsprices.txt")) {
                lueHinnasto(zs);
            }
        }
        return null;
    }

    private void lueHinnasto(InputStream is) {
        Scanner s = new Scanner(is);
        
        while (s.hasNextLine()) {
            String[] kentät = s.nextLine().split("\t");
            switch (kentät.length) {
                case 1:
                    lisääTuoteryhmä(kentät);
                    break;
                case 3:
                    lisääTuote(kentät);
                    break;
                default:
                    throw new RuntimeException("Virheellinen rivi!");
            }
        }
    }

    private void lisääTuoteryhmä(String[] kentät) {
        viimeisinTuoteryhmä = new Tuoteryhmä(kentät[0]);
        em.persist(viimeisinTuoteryhmä);
    }

    private void lisääTuote(String[] kentät) {
        if (viimeisinTuoteryhmä == null) {
            throw new RuntimeException("Tuote ennen tuoteryhmää!");
        }
        Tuote t = new Tuote(
                kentät[0], 
                kentät[1], 
                new BigDecimal(kentät[2].substring(1))
            );
        viimeisinTuoteryhmä.add(t);
    }
    
    @Produces @Named("hinnasto")
    public List<Tuoteryhmä> haeHinnasto() {
        return em
            .createNamedQuery(
                "Tuoteryhmä.haeKaikki", 
                Tuoteryhmä.class)
            .getResultList();
    }
}
