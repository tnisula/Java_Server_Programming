/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
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
@Table(name = "VENDORS")
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v")})
public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "VENDORID")
    private String vendorid;
    @Size(max = 30)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Size(max = 20)
    @Column(name = "REPFNAME")
    private String repfname;
    @Size(max = 20)
    @Column(name = "REPLNAME")
    private String replname;
    @Size(max = 5)
    @Column(name = "REFERREDBY")
    private String referredby;
    
    @OneToMany(mappedBy="vendor")
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Vendor() {
    }

    public Vendor(String vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getRepfname() {
        return repfname;
    }

    public void setRepfname(String repfname) {
        this.repfname = repfname;
    }

    public String getReplname() {
        return replname;
    }

    public void setReplname(String replname) {
        this.replname = replname;
    }

    public String getReferredby() {
        return referredby;
    }

    public void setReferredby(String referredby) {
        this.referredby = referredby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorid != null ? vendorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorid == null && other.vendorid != null) || (this.vendorid != null && !this.vendorid.equals(other.vendorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.Vendors[ vendorid=" + vendorid + " ]";
    }
    
}
