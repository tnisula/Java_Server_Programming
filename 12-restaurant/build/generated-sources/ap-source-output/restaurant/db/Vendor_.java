package restaurant.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.Ingredient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(Vendor.class)
public class Vendor_ { 

    public static volatile SingularAttribute<Vendor, String> replname;
    public static volatile SingularAttribute<Vendor, String> companyname;
    public static volatile SingularAttribute<Vendor, String> referredby;
    public static volatile SingularAttribute<Vendor, String> vendorid;
    public static volatile ListAttribute<Vendor, Ingredient> ingredients;
    public static volatile SingularAttribute<Vendor, String> repfname;

}