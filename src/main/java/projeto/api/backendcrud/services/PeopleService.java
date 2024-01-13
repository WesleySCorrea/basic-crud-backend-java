package projeto.api.backendcrud.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import projeto.api.backendcrud.DTOs.PeopleDTO;
import projeto.api.backendcrud.model.People;
import projeto.api.backendcrud.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final ModelMapper mapper;
    private final PeopleRepository peopleRepository;

    public List<PeopleDTO> findAll() {

        List<People> peopleList = peopleRepository.findAll();

        List<PeopleDTO> peopleDTOList = peopleList.stream()
                .map(people -> mapper.map(people, PeopleDTO.class))
                .collect(Collectors.toList());

        return peopleDTOList;
    }

    public PeopleDTO findById(Long id) {

        Optional<People> people = peopleRepository.findById(id);

        return mapper.map(people, PeopleDTO.class);
    }

    public PeopleDTO insert(PeopleDTO peopleDTO) {

        People people = mapper.map(peopleDTO, People.class);

        People peoplePersisted = peopleRepository.save(people);

        return mapper.map(peoplePersisted, PeopleDTO.class);
    }
    
    public PeopleDTO update(PeopleDTO peopleDTO) {

        PeopleDTO peoplePersisted = this.findById(peopleDTO.getId());

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(peopleDTO, peoplePersisted);

        PeopleDTO peopleUpdated = this.insert(peoplePersisted);

        return peopleUpdated;
    }

    public void delete (Long id) {

        peopleRepository.deleteById(id);
    }
}
