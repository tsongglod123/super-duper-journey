package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dto.ProductPageDTO;
import sit.int204.classicmodelsservice.dto.SimpleProductDTO;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repo.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo repo;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public ProductPageDTO getAllProducts(int page, int pageSize, String sortBy) {
        return modelMapper.map(repo.findAll(PageRequest.of(page, pageSize, Sort.by(sortBy))), ProductPageDTO.class);
    }

    public SimpleProductDTO getProduct(String id) {
        Product product = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " doesn't exist!"));
        return modelMapper.map(product, SimpleProductDTO.class);
    }
}
