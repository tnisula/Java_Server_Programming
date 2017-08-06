/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ski50b;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lapirtti
 */
@Entity
@Table(name = "events")
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")})
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private Integer year;
    @Size(max = 255)
    @Column(name = "event")
    private String event;
    @OneToMany(mappedBy = "year")
    private Collection<Results> resultsCollection;

    public Events() {
    }

    public Events(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Collection<Results> getResultsCollection() {
        return resultsCollection;
    }

    public void setResultsCollection(Collection<Results> resultsCollection) {
        this.resultsCollection = resultsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (year != null ? year.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.year == null && other.year != null) || (this.year != null && !this.year.equals(other.year))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ski50b.Events[ year=" + year + " ]";
    }
    
}
