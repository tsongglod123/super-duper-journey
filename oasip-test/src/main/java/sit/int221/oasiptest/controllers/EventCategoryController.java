package sit.int221.oasiptest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int221.oasiptest.dto.EventCategoryDto;
import sit.int221.oasiptest.entities.EventCategory;
import sit.int221.oasiptest.services.EventCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class EventCategoryController {
}
