package sit.int204.finalpractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalpractice.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}