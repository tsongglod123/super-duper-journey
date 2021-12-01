package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Customer;

import java.util.List;

public class CustomerRepo {
    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Customer.findUser");
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size() == 0 ? null : customers.get(0);
    }
}
