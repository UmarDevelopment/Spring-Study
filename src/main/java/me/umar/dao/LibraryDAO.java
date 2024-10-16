package me.umar.dao;

import me.umar.dao.mappers.PersonMapper;
import me.umar.models.library.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO person (fio, birth_year) VALUES (?, ?)",
                person.getFio(),
                person.getBirthYear()
        );
    }

    public List<Person> listAllPeople(){
        return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());
    }

    public Optional<Person> getPersonById(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny();
    }
}
