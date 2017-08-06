/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classicmodels;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@Stateless
public class CustomerPhoneBean {
    @PersistenceContext 
    EntityManager em;
    
    public List<CustomerPhone> getCustomerPhones() {
        return em.createNamedQuery(
                "Customers.findCustomerPhones", 
                CustomerPhone.class).getResultList();
    }
}
