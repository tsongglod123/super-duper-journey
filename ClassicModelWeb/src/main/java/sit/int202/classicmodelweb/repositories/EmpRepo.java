package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Employee;

import java.util.List;

public class EmpRepo {
    private EntityManager getEntityManager() {
        return EntityManagerService.getEntityManager();
    }

    public Employee find(Integer emp_id) {
        EntityManager em = getEntityManager();
        return em.find(Employee.class, emp_id);
    }

    public List<Employee> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select e from Employee e");
        return query.getResultList();
    }

    public List<Employee> findByDesc(String s) {
        EntityManager em = getEntityManager();
        String sql = "select e from Employee e where e.firstName like :fname or e.lastName like :lname";
        Query query = em.createQuery(sql);
        query.setParameter("fname", s + "%");
        query.setParameter("lname", s + "%");
        return query.getResultList();
    }

    public void save(Employee employee) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }
}
