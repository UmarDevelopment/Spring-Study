package me.umar.dao.mappers;

import me.umar.models.library.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("person_id"));
        person.setBirthYear(resultSet.getInt("birth_year"));
        person.setFio(resultSet.getString("fio"));
        return person;
    }
}
