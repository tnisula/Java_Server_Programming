package restaurant.db;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.Vendor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(Ingredient.class)
public class Ingredient_ { 

    public static volatile SingularAttribute<Ingredient, String> ingredientid;
    public static volatile SingularAttribute<Ingredient, String> unit;
    public static volatile SingularAttribute<Ingredient, Vendor> vendor;
    public static volatile SingularAttribute<Ingredient, String> name;
    public static volatile SingularAttribute<Ingredient, Integer> inventory;
    public static volatile SingularAttribute<Ingredient, BigDecimal> unitprice;
    public static volatile SingularAttribute<Ingredient, String> foodgroup;

}