/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PARTOF")
@NamedQueries({
    @NamedQuery(name = "Partof.findAll", query = "SELECT p FROM Partof p")})
public class Partof implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartofPK partofPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    public Partof() {
    }

    public Partof(PartofPK partofPK) {
        this.partofPK = partofPK;
    }

    public Partof(String mealid, String itemid) {
        this.partofPK = new PartofPK(mealid, itemid);
    }

    public PartofPK getPartofPK() {
        return partofPK;
    }

    public void setPartofPK(PartofPK partofPK) {
        this.partofPK = partofPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partofPK != null ? partofPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partof)) {
            return false;
        }
        Partof other = (Partof) object;
        if ((this.partofPK == null && other.partofPK != null) || (this.partofPK != null && !this.partofPK.equals(other.partofPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.db.Partof[ partofPK=" + partofPK + " ]";
    }
    
}
