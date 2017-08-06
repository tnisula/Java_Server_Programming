/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ski50b;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private Integer year;
    @Size(max = 255)
    @Column(name = "event")
    private String event;
    @OneToMany(mappedBy = "event")
    private List<Result> results;

    public Event() {
    }

    public Event(Integer year) {
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

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.year == null && other.year != null) || (this.year != null && !this.year.equals(other.year))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ski50b.Event[year=" + year + "]";
    }
    
}
