package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.dto.EmployeeDTO;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<EmployeeDTO> getEmployees() {
        return service.getEmployees();
    }

    @PostMapping("")
    public Employee create(@RequestBody EmployeeDTO newEmployee) {
        return service.save(newEmployee);
    }
}
