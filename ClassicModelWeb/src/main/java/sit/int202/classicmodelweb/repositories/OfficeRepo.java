package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.*;
import sit.int202.classicmodelweb.entities.Office;

import java.util.*;

public class OfficeRepo {
    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public List<Office> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Office.findAll");
        return query.getResultList();
    }

    public void save(Office office) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(office);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Office office) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(office);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(String pk) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Office office = find(pk);
        if (office != null) {
            em.remove(em.contains(office) ? office : em.merge(office));
        }
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Office office) {
        delete(office.getId());
    }
}
