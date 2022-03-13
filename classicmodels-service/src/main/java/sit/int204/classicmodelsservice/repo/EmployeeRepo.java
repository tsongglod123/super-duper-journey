package sit.int204.classicmodelsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
