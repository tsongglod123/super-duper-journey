package sit.int204.finalpractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalpractice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}