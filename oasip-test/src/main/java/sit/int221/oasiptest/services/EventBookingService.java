package sit.int221.oasiptest.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasiptest.dto.EventBookingCategoryDto;
import sit.int221.oasiptest.entities.EventBooking;
import sit.int221.oasiptest.repo.EventBookingRepository;
import sit.int221.oasiptest.utils.ListMapper;

import java.util.List;

@Service
public class EventBookingService {
    private final EventBookingRepository repo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public EventBookingService(EventBookingRepository repo, ModelMapper modelMapper, ListMapper listMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public List<EventBookingCategoryDto> getEventBookings() {
        List<EventBooking> list = repo.findAll();
        return listMapper.mapList(list, EventBookingCategoryDto.class, modelMapper);
    }

    public EventBookingCategoryDto getEventBookingById(Integer id) {
        EventBooking booking = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(booking, EventBookingCategoryDto.class);
    }

    public EventBooking save(EventBookingCategoryDto newBooking) {
        EventBooking booking = modelMapper.map(newBooking, EventBooking.class);
        return repo.saveAndFlush(booking);
    }
}
