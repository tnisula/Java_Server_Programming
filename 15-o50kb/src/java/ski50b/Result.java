/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ski50b;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author lapirtti
 */
@Entity
@Table(name = "results")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")})
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resultid")
    private Integer resultid;
    @Size(max = 255)
    @Column(name = "athlete")
    private String athlete;
    @Size(max = 255)
    @Column(name = "medal")
    private String medal;
    @Size(max = 255)
    @Column(name = "country")
    private String country;
    @Column(name = "result")
    @Temporal(TemporalType.TIME)
    private Date result;
    @JoinColumn(name = "year", referencedColumnName = "year")
    @ManyToOne
    private Event event;

    public Result() {
    }

    public Result(Integer resultid) {
        this.resultid = resultid;
    }

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getResult() {
        return result;
    }

    public void setResult(Date result) {
        this.result = result;
    }
    
    public String getResultAsString() {
        return (new SimpleDateFormat("HH:mm:ss")).format(result);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultid != null ? resultid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.resultid == null && other.resultid != null) || (this.resultid != null && !this.resultid.equals(other.resultid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ski50b.Result[resultid=" + resultid + "]";
    }
    
}
