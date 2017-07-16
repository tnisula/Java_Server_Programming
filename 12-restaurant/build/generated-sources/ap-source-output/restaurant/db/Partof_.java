package restaurant.db;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restaurant.db.PartofPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T16:43:07")
@StaticMetamodel(Partof.class)
public class Partof_ { 

    public static volatile SingularAttribute<Partof, Integer> quantity;
    public static volatile SingularAttribute<Partof, BigDecimal> discount;
    public static volatile SingularAttribute<Partof, PartofPK> partofPK;

}