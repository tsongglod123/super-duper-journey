package int202.practice.test.repo;

import int202.practice.test.entities.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class OfficeRepo {
    private EntityManager getEntityManager() {
        return EMS.getEntityManager();
    }

    public Office find(Integer id) {
        return getEntityManager().find(Office.class, id);
    }

    public List<Office> findAll() {
        String sql = "select o from Office o";
        Query query = getEntityManager().createQuery(sql);
        return query.getResultList();
    }
}
