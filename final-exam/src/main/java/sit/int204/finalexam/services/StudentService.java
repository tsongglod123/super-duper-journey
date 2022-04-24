package sit.int204.finalexam.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.finalexam.dto.StudentDto;
import sit.int204.finalexam.repo.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentService(StudentRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

}
