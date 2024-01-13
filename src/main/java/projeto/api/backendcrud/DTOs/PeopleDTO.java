package projeto.api.backendcrud.DTOs;

import lombok.Data;

@Data
public class PeopleDTO {

    private Long id;
    private String name;
    private String lastName;
    private int age;

}
