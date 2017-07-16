/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lapirtti
 */
@Embeddable
public class OrderPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERNUMBER")
    private int ordernumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINENUMBER")
    private int linenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "STOREID")
    private String storeid;

    public OrderPK() {
    }

    public OrderPK(int ordernumber, int linenumber, String storeid) {
        this.ordernumber = ordernumber;
        this.linenumber = linenumber;
        this.storeid = storeid;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public int getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(int linenumber) {
        this.linenumber = linenumber;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordernumber;
        hash += (int) linenumber;
        hash += (storeid != null ? storeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderPK)) {
            return false;
        }
        OrderPK other = (OrderPK) object;
        if (this.ordernumber != other.ordernumber) {
            return false;
        }
        if (this.linenumber != other.linenumber) {
            return false;
        }
        if ((this.storeid == null && other.storeid != null) || (this.storeid != null && !this.storeid.equals(other.storeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.OrdersPK[ ordernumber=" + ordernumber + ", linenumber=" + linenumber + ", storeid=" + storeid + " ]";
    }
    
}
