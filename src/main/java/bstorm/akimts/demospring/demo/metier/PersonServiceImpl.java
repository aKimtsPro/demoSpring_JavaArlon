package bstorm.akimts.demospring.demo.metier;

import bstorm.akimts.demospring.demo.annotation.Impl;
import bstorm.akimts.demospring.demo.dataaccess.repository.PersonRepository;
import bstorm.akimts.demospring.demo.metier.mapper.PersonMapper;
import bstorm.akimts.demospring.demo.metier.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Primary
@Impl
@Qualifier("boom")
@Service("personServiceImpl")
@Profile({"demo", "impl"})
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> getAll() {
        return repository.findAll().stream()
                .map( mapper::entityToDTO )
                .collect(Collectors.toList());
    }

    @Override
    public void add(PersonDTO toAdd) {
        repository.save( mapper.dtoToEntity(toAdd) );
    }
}
