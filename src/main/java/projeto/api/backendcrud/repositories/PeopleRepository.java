package projeto.api.backendcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.api.backendcrud.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
