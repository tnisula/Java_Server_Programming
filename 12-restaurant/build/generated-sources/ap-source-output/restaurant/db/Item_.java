package restaurant.db;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.Ingredient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> itemid;
    public static volatile ListAttribute<Item, Ingredient> madeWith;
    public static volatile SingularAttribute<Item, BigDecimal> price;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, Date> dateadded;

}