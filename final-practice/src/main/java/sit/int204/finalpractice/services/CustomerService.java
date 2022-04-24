package sit.int204.finalpractice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.finalpractice.repo.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }


}
