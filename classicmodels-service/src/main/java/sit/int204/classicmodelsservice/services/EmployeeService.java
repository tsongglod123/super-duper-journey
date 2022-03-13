package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.dto.EmployeeDTO;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.repo.EmployeeRepo;
import sit.int204.classicmodelsservice.utils.ListMapper;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public EmployeeService(EmployeeRepo repo, ModelMapper modelMapper, ListMapper listMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public Employee save(EmployeeDTO newEmployee) {
        Employee employee = modelMapper.map(newEmployee, Employee.class);
        return repo.saveAndFlush(employee);
    }

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employeeList = repo.findAll();
        return listMapper.mapList(employeeList, EmployeeDTO.class, modelMapper);
    }
}
