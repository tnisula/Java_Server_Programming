package restaurant.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.Item;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(Meal.class)
public class Meal_ { 

    public static volatile SingularAttribute<Meal, String> mealid;
    public static volatile SingularAttribute<Meal, String> name;
    public static volatile ListAttribute<Meal, Item> items;

}