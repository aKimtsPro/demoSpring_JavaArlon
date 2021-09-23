package bstorm.akimts.demospring.demo.metier.mapper;

import bstorm.akimts.demospring.demo.dataaccess.entity.Person;
import bstorm.akimts.demospring.demo.metier.dto.PersonDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("demo")
public class PersonMapper {

    public PersonDTO entityToDTO(Person entity){
        if(entity == null)
            return null;

        return PersonDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .age(entity.getAge())
                .build();
    }

    public Person dtoToEntity(PersonDTO dto){
        if(dto == null)
            return null;

        return Person.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .age(dto.getAge())
                .build();
    }

}
