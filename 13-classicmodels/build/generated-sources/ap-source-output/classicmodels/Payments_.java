package classicmodels;

import classicmodels.Customers;
import classicmodels.PaymentsPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-15T12:42:46")
@StaticMetamodel(Payments.class)
public class Payments_ { 

    public static volatile SingularAttribute<Payments, Double> amount;
    public static volatile SingularAttribute<Payments, PaymentsPK> paymentsPK;
    public static volatile SingularAttribute<Payments, Customers> customers;
    public static volatile SingularAttribute<Payments, Date> paymentDate;

}