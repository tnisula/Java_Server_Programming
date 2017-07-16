package restaurant;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import restaurant.db.Ingredient;
import restaurant.db.Item;
import restaurant.db.Meal;
import restaurant.db.Vendor;

@Named
@Stateless
public class MenuBean {
    @PersistenceContext
    private EntityManager em;
    
    public List<Meal> getMeals() {
        return em
            .createNamedQuery("Meal.findAll", Meal.class)
            .getResultList();
    }
    
    public List<Item> getDishes() {
        return em
            .createNamedQuery("Item.findAll", Item.class)
            .getResultList();
    }
    
    public List<Ingredient> getIngredients() {
        return em
            .createNamedQuery("Ingredient.findAll", Ingredient.class)
            .getResultList();
    }

    public List<Vendor> getVendors() {
        return em
            .createNamedQuery("Vendor.findAll", Vendor.class)
            .getResultList();
    }
}
