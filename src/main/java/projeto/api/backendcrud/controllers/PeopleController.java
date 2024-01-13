package projeto.api.backendcrud.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.api.backendcrud.DTOs.PeopleDTO;
import projeto.api.backendcrud.services.PeopleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/people")
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<PeopleDTO>> findAll() {

        List<PeopleDTO> peopleList = peopleService.findAll();

        return ResponseEntity.ok().body(peopleList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PeopleDTO> findById(@PathVariable Long id) {

        PeopleDTO people = peopleService.findById(id);

        return ResponseEntity.ok().body(people);
    }

    @PostMapping
    public ResponseEntity<PeopleDTO> insert (@RequestBody PeopleDTO peopleDTO) {

        PeopleDTO peoplePersisted = peopleService.insert(peopleDTO);

        return ResponseEntity.ok(peoplePersisted);
    }

    @PutMapping
    public ResponseEntity<PeopleDTO> update (@RequestBody PeopleDTO peopleDTO) {

        PeopleDTO peopleUpdated = peopleService.update(peopleDTO);

        return ResponseEntity.ok(peopleUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {

        peopleService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
