package classicmodels;

import classicmodels.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-15T12:42:46")
@StaticMetamodel(Productlines.class)
public class Productlines_ { 

    public static volatile SingularAttribute<Productlines, String> productLine;
    public static volatile SingularAttribute<Productlines, byte[]> image;
    public static volatile CollectionAttribute<Productlines, Products> productsCollection;
    public static volatile SingularAttribute<Productlines, String> textDescription;
    public static volatile SingularAttribute<Productlines, String> htmlDescription;

}