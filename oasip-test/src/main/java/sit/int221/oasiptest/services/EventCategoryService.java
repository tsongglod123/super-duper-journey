package sit.int221.oasiptest.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasiptest.dto.EventCategoryDto;
import sit.int221.oasiptest.entities.EventCategory;
import sit.int221.oasiptest.repo.EventCategoryRepository;

@Service
public class EventCategoryService {
    private final EventCategoryRepository repo;
    private final ModelMapper modelMapper;

    public EventCategoryService(EventCategoryRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public EventCategoryDto getEventCategoryById(Integer id) {
        EventCategory category = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(category, EventCategoryDto.class);
    }
}
