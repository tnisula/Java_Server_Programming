/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lapirtti
 */
@Entity
@Table(name = "MADEWITH")
@NamedQueries({
    @NamedQuery(name = "Madewith.findAll", query = "SELECT m FROM Madewith m")})
public class Madewith implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MadewithPK madewithPK;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Madewith() {
    }

    public Madewith(MadewithPK madewithPK) {
        this.madewithPK = madewithPK;
    }

    public Madewith(String itemid, String ingredientid) {
        this.madewithPK = new MadewithPK(itemid, ingredientid);
    }

    public MadewithPK getMadewithPK() {
        return madewithPK;
    }

    public void setMadewithPK(MadewithPK madewithPK) {
        this.madewithPK = madewithPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (madewithPK != null ? madewithPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Madewith)) {
            return false;
        }
        Madewith other = (Madewith) object;
        if ((this.madewithPK == null && other.madewithPK != null) || (this.madewithPK != null && !this.madewithPK.equals(other.madewithPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.Madewith[ madewithPK=" + madewithPK + " ]";
    }
    
}
