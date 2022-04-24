package sit.int204.finalpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int204.finalpractice.dto.OfficeDto;
import sit.int204.finalpractice.entities.Office;
import sit.int204.finalpractice.services.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    private final OfficeService service;

    @Autowired
    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public OfficeDto getOfficeById(@PathVariable String id) {
        return service.getOfficeById(id);
    }

    @GetMapping("")
    public List<OfficeDto> getOfficesByCountry(@RequestParam(defaultValue = "uk") String country) {
        return service.getOfficesByCountry(country);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Office create(@RequestBody OfficeDto newOffice) {
        return service.save(newOffice);
    }

    @GetMapping("/all")
    public List<OfficeDto> getOffices() {
        return service.getOffices();
    }
}
