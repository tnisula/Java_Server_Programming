package classicmodels;

import classicmodels.OrderdetailsPK;
import classicmodels.Orders;
import classicmodels.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-15T12:42:46")
@StaticMetamodel(Orderdetails.class)
public class Orderdetails_ { 

    public static volatile SingularAttribute<Orderdetails, OrderdetailsPK> orderdetailsPK;
    public static volatile SingularAttribute<Orderdetails, Integer> quantityOrdered;
    public static volatile SingularAttribute<Orderdetails, Orders> orders;
    public static volatile SingularAttribute<Orderdetails, Short> orderLineNumber;
    public static volatile SingularAttribute<Orderdetails, Double> priceEach;
    public static volatile SingularAttribute<Orderdetails, Products> products;

}