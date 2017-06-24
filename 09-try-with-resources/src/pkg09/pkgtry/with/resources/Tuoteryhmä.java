package pkg09.pkgtry.with.resources;

import java.util.Collection;
import java.util.LinkedList;

public class Tuoteryhmä {
    private Collection<Tuote> tuotteet;
    private String nimi;

    public Tuoteryhmä(String nimi) {
        this.nimi = nimi;
        tuotteet = new LinkedList<>();
    }

    public Tuoteryhmä() {
    }

    public Collection<Tuote> getTuotteet() {
        return tuotteet;
    }

    public void setTuotteet(Collection<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void add(Tuote t) {
        tuotteet.add(t);
    }
}
