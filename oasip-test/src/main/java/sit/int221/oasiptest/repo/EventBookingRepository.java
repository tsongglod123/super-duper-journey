package sit.int221.oasiptest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.oasiptest.entities.EventBooking;

public interface EventBookingRepository extends JpaRepository<EventBooking, Integer> {
}