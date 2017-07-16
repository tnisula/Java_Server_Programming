/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ORDERS")
@NamedQueries({
    @NamedQuery(name = "AnOrder.findAll", query = "SELECT o FROM AnOrder o")})
public class AnOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderPK ordersPK;
    @Size(max = 5)
    @Column(name = "MENUITEMID")
    private String menuitemid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public AnOrder() {
    }

    public AnOrder(OrderPK ordersPK) {
        this.ordersPK = ordersPK;
    }

    public AnOrder(int ordernumber, int linenumber, String storeid) {
        this.ordersPK = new OrderPK(ordernumber, linenumber, storeid);
    }

    public OrderPK getOrdersPK() {
        return ordersPK;
    }

    public void setOrdersPK(OrderPK ordersPK) {
        this.ordersPK = ordersPK;
    }

    public String getMenuitemid() {
        return menuitemid;
    }

    public void setMenuitemid(String menuitemid) {
        this.menuitemid = menuitemid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordersPK != null ? ordersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnOrder)) {
            return false;
        }
        AnOrder other = (AnOrder) object;
        if ((this.ordersPK == null && other.ordersPK != null) || (this.ordersPK != null && !this.ordersPK.equals(other.ordersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.Orders[ ordersPK=" + ordersPK + " ]";
    }
    
}
