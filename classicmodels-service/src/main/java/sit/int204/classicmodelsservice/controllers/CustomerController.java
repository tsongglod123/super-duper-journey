package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.dto.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repo.CustomerRepo;
import sit.int204.classicmodelsservice.services.CustomerService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepo repo;
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerRepo repo, CustomerService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping("/{id}")
    public SimpleCustomerDTO getCustomerById(@PathVariable Integer id) {
        return service.getSimpleCustomerById(id);
    }

    @GetMapping("")
    // public List<Customer> getAllCustomer(
    public Page<Customer> getAllCustomer(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Sort sort = Sort.by(sortBy);
        return repo.findAll(PageRequest.of(page, pageSize, sort));
    }

    @GetMapping("/credit/{lower}/{upper}")
    public List<Customer> getAllCustomerByCredit(
            @PathVariable BigDecimal lower,
            @PathVariable BigDecimal upper) {
        return repo.findAllByCreditLimitBetween(lower, upper);
    }

    @GetMapping("/name/{name}")
    public List<Customer> getAllCustomerByName(@PathVariable String name) {
        return repo.findAllByCustomerNameContaining(name);
    }
}
