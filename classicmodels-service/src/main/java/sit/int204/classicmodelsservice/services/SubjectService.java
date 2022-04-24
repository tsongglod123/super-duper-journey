package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.dto.SubjectPageDto;
import sit.int204.classicmodelsservice.repo.SubjectRepository;

@Service
public class SubjectService {
    private final SubjectRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public SubjectService(SubjectRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public SubjectPageDto getAllSubjects(int page, int pageSize, String sortBy) {
        return modelMapper.map(repo.findAll(PageRequest.of(page, pageSize, Sort.by(sortBy))), SubjectPageDto.class);
    }
}
