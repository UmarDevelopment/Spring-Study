package me.umar.dao;

import me.umar.dao.mappers.BookMapper;
import me.umar.dao.mappers.PersonMapper;
import me.umar.models.library.Person;
import me.umar.models.library.*;
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

    public List<Book> listAllBook(){
        return jdbcTemplate.query("SELECT * FROM book", new BookMapper());
    }


    public Optional<Person> getPersonById(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny();
    }

    public Optional<Book> getBookById(int id){
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{id}, new BookMapper())
                .stream().findAny();
    }

    public void updatePerson(Person person){
        jdbcTemplate.update("UPDATE spring.person SET fio = ?, birth_year = ? WHERE person_id = ?",
                person.getFio(),
                person.getBirthYear(),
                person.getId()
        );
    }

    public void updateBook(Book book){
        jdbcTemplate.update("UPDATE spring.book SET name = ?, author = ?, year = ? WHERE book_id = ?",
                book.getName(),
                book.getAuthor(),
                book.getYear(),
                book.getId()
        );
    }

    public void releaseBook(Book book){
        jdbcTemplate.update("UPDATE spring.book SET person_id = null WHERE book_id = ?",
            book.getId()
        );
    }

    public void reserveBook(Person person, int book_id){
        jdbcTemplate.update("UPDATE spring.book SET person_id = ? WHERE book_id = ?",
                person.getId(),
                book_id
        );
    }

    public void deleteBook(Book book){
        jdbcTemplate.update("DELETE FROM spring.book WHERE book_id = ?",
                book.getId()
        );
    }

    public void deletePerson(Person person){
        jdbcTemplate.update("DELETE FROM spring.person WHERE person_id = ?",
                person.getId()
        );
    }

    public void addBook(Book book){
        jdbcTemplate.update(
                "INSERT INTO spring.book (name, author, year) VALUES (?, ?, ?)",
                book.getName(),
                book.getAuthor(),
                book.getYear()
        );
    }
}
