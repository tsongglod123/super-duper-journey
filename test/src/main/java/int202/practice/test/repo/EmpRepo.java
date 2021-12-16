package int202.practice.test.repo;

import int202.practice.test.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class EmpRepo {
    private EntityManager getEntityManager() {
        return EMS.getEntityManager();
    }

    public Employee find(Integer id) {
        return getEntityManager().find(Employee.class, id);
    }

    public List<Employee> findAll() {
        String sql = "select e from Employee e";
        Query query = getEntityManager().createQuery(sql);
        return query.getResultList();
    }

    public List<Employee> findByOfficeId(int id) {
        String sql = "select e from Employee e where e.officeCode.id = :id";
        Query query = getEntityManager().createQuery(sql);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
