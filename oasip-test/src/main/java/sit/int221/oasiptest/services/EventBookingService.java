package sit.int221.oasiptest.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasiptest.dto.api.EventDetailsBaseDto;
import sit.int221.oasiptest.dto.api.EventListAllDto;
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

    public List<EventListAllDto> getEventListSorted() {
        Sort sort = Sort.by("eventStartTime");
        List<EventBooking> bookings = repo.findAll(sort.descending());
        return listMapper.mapList(bookings, EventListAllDto.class, modelMapper);
    }

    public EventDetailsBaseDto getEventDetails(Integer id) {
        EventBooking booking = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(booking, EventDetailsBaseDto.class);
    }
}
