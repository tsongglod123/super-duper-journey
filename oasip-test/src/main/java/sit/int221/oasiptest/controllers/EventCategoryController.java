package sit.int221.oasiptest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasiptest.dto.CategoryDto;
import sit.int221.oasiptest.dto.EventCategoryDto;
import sit.int221.oasiptest.entities.EventCategory;
import sit.int221.oasiptest.services.CategoryService;
import sit.int221.oasiptest.services.EventCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class EventCategoryController {
    private final EventCategoryService service;
    private final CategoryService categoryService;

    @Autowired
    public EventCategoryController(EventCategoryService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<CategoryDto> getEventCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("")
    public EventCategory create(@RequestBody CategoryDto newCategory) {
        return categoryService.save(newCategory);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}/bookings")
    public EventCategoryDto getEventCategoryById(@PathVariable Integer id) {
        return service.getEventCategoryById(id);
    }
}
