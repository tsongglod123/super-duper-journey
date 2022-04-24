package sit.int204.finalpractice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.finalpractice.repo.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }


}
