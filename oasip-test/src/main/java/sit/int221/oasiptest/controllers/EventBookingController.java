package sit.int221.oasiptest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasiptest.dto.EventBookingCategoryDto;
import sit.int221.oasiptest.entities.EventBooking;
import sit.int221.oasiptest.services.EventBookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class EventBookingController {
    private final EventBookingService service;

    @Autowired
    public EventBookingController(EventBookingService service) {
        this.service = service;
    }

    @PostMapping("")
    public EventBooking create(@RequestBody EventBookingCategoryDto newBooking) {
        return service.save(newBooking);
    }

    @GetMapping("")
    public List<EventBookingCategoryDto> getEventBookings() {
        return service.getEventBookings();
    }

    @GetMapping("/{id}")
    public EventBookingCategoryDto getEventBookingById(@PathVariable Integer id) {
        return service.getEventBookingById(id);
    }
}
