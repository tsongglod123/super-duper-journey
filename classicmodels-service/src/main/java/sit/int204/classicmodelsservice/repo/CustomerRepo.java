package sit.int204.classicmodelsservice.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    // Query creation
    List<Customer> findAllByCustomerNameContaining(String name);

    List<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    List<Customer> findAllByCreditLimitBetween(BigDecimal lower, BigDecimal upper);

    List<Customer> findAllByCreditLimitBetween(BigDecimal lower, BigDecimal upper, Pageable pageable);

    List<Customer> findAllByCustomerNameBetween(String lower, String upper);
}
