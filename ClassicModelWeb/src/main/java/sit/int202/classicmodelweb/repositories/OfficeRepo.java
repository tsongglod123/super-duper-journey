package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.*;
import sit.int202.classicmodelweb.entities.Office;

import java.util.*;

public class OfficeRepo {
    private EntityManager em;

    public OfficeRepo() {
        this.em = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public Office find(String officeCode) {
        return em.find(Office.class, officeCode);
    }

    public List<Office> findAll() {
        Query query = em.createQuery("select o from Office o");
        return query.getResultList();
    }

    public void save(Office office) {
        em.getTransaction().begin();
        em.persist(office);
        em.getTransaction().commit();
    }
}
