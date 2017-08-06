package classicmodels;

import classicmodels.Customers;
import classicmodels.Employees;
import classicmodels.Offices;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-15T12:42:46")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile CollectionAttribute<Employees, Employees> employeesCollection;
    public static volatile SingularAttribute<Employees, String> lastName;
    public static volatile SingularAttribute<Employees, String> firstName;
    public static volatile SingularAttribute<Employees, String> extension;
    public static volatile SingularAttribute<Employees, String> jobTitle;
    public static volatile SingularAttribute<Employees, Offices> officeCode;
    public static volatile CollectionAttribute<Employees, Customers> customersCollection;
    public static volatile SingularAttribute<Employees, Employees> reportsTo;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, Integer> employeeNumber;

}