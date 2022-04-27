package sit.int221.oasiptest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasiptest.dto.api.CategoryDto;
import sit.int221.oasiptest.services.EventCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class EventCategoryController {
    private final EventCategoryService service;

    @Autowired
    public EventCategoryController(EventCategoryService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<CategoryDto> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }
}
