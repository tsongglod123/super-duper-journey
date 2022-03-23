package sit.int204.classicmodelsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
}
