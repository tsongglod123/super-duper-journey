package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.repo.OfficeRepo;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    private final OfficeRepo repo;

    @Autowired
    public OfficeController(OfficeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<Office> getOffice() {
        return repo.findAll();
    }

    @GetMapping("/{officeCode}")
    public Office getOffice(@PathVariable String officeCode) {
        return repo.findById(officeCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, officeCode + " does not exist!"));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office create(@RequestBody Office newOffice) {
        return repo.saveAndFlush(newOffice);
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode) {
        repo.findById(officeCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, officeCode + " does not exist!"));
        repo.deleteById(officeCode);
    }

    private Office mapOffice(Office office, Office update) {
        office.setAddressLine1(update.getAddressLine1());
        office.setAddressLine2(update.getAddressLine2());
        office.setCity(update.getCity());
        office.setCountry(update.getCountry());
        office.setPhone(update.getPhone());
        office.setPostalCode(update.getPostalCode());
        office.setState(update.getState());
        office.setTerritory(update.getTerritory());
        return office;
    }

    @PutMapping("/{officeCode}")
    public Office update(@RequestBody Office updateOffice, @PathVariable String officeCode) {
        Office office = repo.findById(officeCode).map(o -> mapOffice(o, updateOffice))
                .orElseGet(() -> {
                    updateOffice.setId(officeCode);
                    return updateOffice;
                });
        return repo.saveAndFlush(office);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployees(@PathVariable String officeCode) {
        Office office = repo.findById(officeCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, officeCode + " does not exist!"));
        return office.getEmployees();
    }
}
