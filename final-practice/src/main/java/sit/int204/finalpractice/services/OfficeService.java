package sit.int204.finalpractice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.finalpractice.dto.OfficeDto;
import sit.int204.finalpractice.entities.Office;
import sit.int204.finalpractice.repo.OfficeRepository;
import sit.int204.finalpractice.utils.ListMapper;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepository repo;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public OfficeService(OfficeRepository repo, ModelMapper modelMapper, ListMapper listMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public OfficeDto getOfficeById(String id) {
        Office office = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " does not exist."));
        return modelMapper.map(office, OfficeDto.class);
    }

    public List<OfficeDto> getOffices() {
        List<Office> office = repo.findAll();
        return listMapper.mapList(office, OfficeDto.class, modelMapper);
    }

    public List<OfficeDto> getOfficesByCountry(String country) {
        List<Office> office = repo.findAllByCountryEquals(country);
        return listMapper.mapList(office, OfficeDto.class, modelMapper);
    }

    public Office save(OfficeDto newOffice) {
        Office office = modelMapper.map(newOffice, Office.class);
        return repo.saveAndFlush(office);
    }
}
