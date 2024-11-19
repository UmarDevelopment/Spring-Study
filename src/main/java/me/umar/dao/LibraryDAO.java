package me.umar.dao;

import me.umar.dao.mappers.BookMapper;
import me.umar.dao.mappers.PersonMapper;
import me.umar.models.library.Person;
import me.umar.models.library.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryDAO {
    //JdbcTemplate jdbcTemplate;
    private final SessionFactory sessionFactory;

    @Autowired
    public LibraryDAO(/*JdbcTemplate jdbcTemplate, */SessionFactory sessionFactory) {
        //this.jdbcTemplate = jdbcTemplate;
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Transactional
    public List<Book> getPersonsBook(int person_id){
        Person person = getPersonById(person_id).get();
        return person.getBooks();
//        List<Book> list;
//        list = jdbcTemplate.query(
//                "select book.* from book join person p on book.person_id = p.person_id where p.person_id = ?",
//                new Object[]{person_id},
//                new BookMapper()
//        );
//        return list;
    }

    @Transactional
    public List<Person> listAllPeople(){
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM person", Person.class).list();
    }

    @Transactional
    public List<Book> listAllBook(){
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM book", Book.class).list();
        //return jdbcTemplate.query("SELECT * FROM book", new BookMapper());
    }



    @Transactional
    public Optional<Person> getPersonById(int id){
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        if (person==null){
            return Optional.empty();
        }else{
            return Optional.of(person);
        }
    }

    @Transactional
    public Optional<Book> getBookById(int id){
        Book book=  sessionFactory.getCurrentSession().get(Book.class, id);
        if (book==null){
            return Optional.empty();
        }else{
            return Optional.of(book);
        }
//        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{id}, new BookMapper())
//                .stream().findAny();
    }

    @Transactional
    public void updatePerson(Person person){
        sessionFactory.getCurrentSession().persist(person);
//        jdbcTemplate.update("UPDATE spring.person SET fio = ?, birth_year = ? WHERE person_id = ?",
//                person.getFio(),
//                person.getBirthYear(),
//                person.getId()
//        );
    }

    @Transactional
    public void updateBook(Book book){
        sessionFactory.getCurrentSession().persist(book);
//        jdbcTemplate.update("UPDATE spring.book SET name = ?, author = ?, year = ? WHERE book_id = ?",
//                book.getName(),
//                book.getAuthor(),
//                book.getYear(),
//                book.getId()
//        );
    }

    @Transactional
    public void releaseBook(Book book){
        book.setPerson(null);
        sessionFactory.getCurrentSession().persist(book);
//        jdbcTemplate.update("UPDATE spring.book SET person_id = null WHERE book_id = ?",
//            book.getId()
//        );
    }

    @Transactional
    public void reserveBook(int person_id, int book_id){
        Book book = getBookById(book_id).get();
        Person person = getPersonById(person_id).get();
        book.setPerson(person);
        person.addBook(book);
        //sessionFactory.getCurrentSession().persist(person);
        sessionFactory.getCurrentSession().persist(book);
//        jdbcTemplate.update("UPDATE spring.book SET person_id = ? WHERE book_id = ?",
//                person.getId(),
//                book_id
//        );
    }
    @Transactional
    public void deleteBook(Book book){
        sessionFactory.getCurrentSession().delete(book);
        /*jdbcTemplate.update("DELETE FROM spring.book WHERE book_id = ?",
                book.getId()
        );*/
    }

    @Transactional
    public void deletePerson(Person person){
        sessionFactory.getCurrentSession().delete(person);
//        jdbcTemplate.update("DELETE FROM spring.person WHERE person_id = ?",
//                person.getId()
//        );
    }

    @Transactional
    public void addBook(Book book){
        sessionFactory.getCurrentSession().persist(book);
//        jdbcTemplate.update(
//                "INSERT INTO spring.book (name, author, year) VALUES (?, ?, ?)",
//                book.getName(),
//                book.getAuthor(),
//                book.getYear()
//        );
    }
}
