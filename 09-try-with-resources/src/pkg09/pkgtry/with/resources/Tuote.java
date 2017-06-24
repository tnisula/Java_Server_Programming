package pkg09.pkgtry.with.resources;

import java.math.BigDecimal;

public class Tuote {
    private String nimi;
    private String annoskoko;
    private BigDecimal hinta;

    public Tuote(String nimi, String annoskoko, BigDecimal hinta) {
        this.nimi = nimi;
        this.annoskoko = annoskoko;
        this.hinta = hinta;
    }

    public Tuote() {
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getAnnoskoko() {
        return annoskoko;
    }

    public void setAnnoskoko(String annoskoko) {
        this.annoskoko = annoskoko;
    }

    public BigDecimal getHinta() {
        return hinta;
    }

    public void setHinta(BigDecimal hinta) {
        this.hinta = hinta;
    }
    
    
}
