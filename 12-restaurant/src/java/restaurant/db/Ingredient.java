/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.db;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lapirtti
 */
@Entity
@Table(name = "INGREDIENTS")
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")})
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "INGREDIENTID")
    private String ingredientid;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "UNIT")
    private String unit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNITPRICE")
    private BigDecimal unitprice;
    @Size(max = 15)
    @Column(name = "FOODGROUP")
    private String foodgroup;
    @Column(name = "INVENTORY")
    private Integer inventory;
    
    @JoinColumn(name = "VENDORID")
    @ManyToOne
    private Vendor vendor;

    public Ingredient() {
    }

    public Ingredient(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(String ingredientid) {
        this.ingredientid = ingredientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public String getFoodgroup() {
        return foodgroup;
    }

    public void setFoodgroup(String foodgroup) {
        this.foodgroup = foodgroup;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientid != null ? ingredientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientid == null && other.ingredientid != null) || (this.ingredientid != null && !this.ingredientid.equals(other.ingredientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restaurant.Ingredients[ ingredientid=" + ingredientid + " ]";
    }
    
}
