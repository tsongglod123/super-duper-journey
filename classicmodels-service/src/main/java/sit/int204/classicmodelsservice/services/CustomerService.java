package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dto.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repo.CustomerRepo;

@Service
public class CustomerService {
    private final CustomerRepo repo;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public SimpleCustomerDTO getSimpleCustomerById(Integer id) {
        Customer customer = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " does not exist!"));
        return modelMapper.map(customer, SimpleCustomerDTO.class);
    }

    private SimpleCustomerDTO convertEntityToDTO(Customer customer) {
        SimpleCustomerDTO dto = new SimpleCustomerDTO();
        dto.setCustomerName(customer.getCustomerName());
        dto.setCity(customer.getCity());
        dto.setPhone(customer.getPhone());
        dto.setCountry(customer.getCountry());
//        dto.setSalesPerson(customer.getSalesRepEmployee().getFirstName() + " " + customer.getSalesRepEmployee().getLastName());
        return dto;
    }


}
