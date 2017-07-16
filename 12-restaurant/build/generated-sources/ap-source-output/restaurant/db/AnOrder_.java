package restaurant.db;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.OrderPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(AnOrder.class)
public class AnOrder_ { 

    public static volatile SingularAttribute<AnOrder, OrderPK> ordersPK;
    public static volatile SingularAttribute<AnOrder, String> menuitemid;
    public static volatile SingularAttribute<AnOrder, BigDecimal> price;
    public static volatile SingularAttribute<AnOrder, Date> time;

}