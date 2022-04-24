package sit.int221.oasiptest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasiptest.entities.EventCategory;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
}