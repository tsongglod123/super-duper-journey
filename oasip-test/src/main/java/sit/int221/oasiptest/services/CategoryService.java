package sit.int221.oasiptest.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasiptest.dto.CategoryDto;
import sit.int221.oasiptest.entities.EventCategory;
import sit.int221.oasiptest.repo.EventCategoryRepository;
import sit.int221.oasiptest.utils.ListMapper;

import java.util.List;

@Service
public class CategoryService {
    private final EventCategoryRepository repo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    public CategoryService(EventCategoryRepository repo, ModelMapper modelMapper, ListMapper listMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public List<CategoryDto> getCategories() {
        List<EventCategory> list = repo.findAll();
        return listMapper.mapList(list, CategoryDto.class, modelMapper);
    }

    public CategoryDto getCategoryById(Integer id) {
        EventCategory category = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(category, CategoryDto.class);
    }

    public EventCategory save(CategoryDto newCategory) {
        EventCategory category = modelMapper.map(newCategory, EventCategory.class);
        return repo.saveAndFlush(category);
    }
}
