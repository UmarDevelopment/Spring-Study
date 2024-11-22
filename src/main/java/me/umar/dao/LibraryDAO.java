package me.umar.dao;

import me.umar.dao.mappers.BookMapper;
import me.umar.dao.mappers.PersonMapper;
import me.umar.models.library.Person;
import me.umar.models.library.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class LibraryDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public LibraryDAO(SessionFactory sessionFactory) {
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
    }

    @Transactional
    public List<Person> listAllPeople(){
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM person", Person.class).list();
    }

    @Transactional
    public List<Book> listAllBook(){
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM book", Book.class).list();
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
    }

    @Transactional
    public void updatePerson(Person person){
        Person personH = sessionFactory.getCurrentSession().get(Person.class, person.getId());
        personH.setFio(person.getFio());
        personH.setBirthYear(person.getBirthYear());
        personH.setBooks(person.getBooks());
    }

    @Transactional
    public void updateBook(Book book){
        Book bookH = sessionFactory.getCurrentSession().get(Book.class, book.getId());
        bookH.setYear(book.getYear());
        bookH.setName(book.getName());
        bookH.setAuthor(book.getAuthor());
        bookH.setYear(book.getYear());
        bookH.setPerson(book.getPerson());
    }

    @Transactional
    public void releaseBook(Book book){
        Book bookH = sessionFactory.getCurrentSession().get(Book.class, book.getId());
        bookH.setPerson(null);
    }

    @Transactional
    public void reserveBook(int person_id, int book_id){
        Book book = getBookById(book_id).get();
        Person person = getPersonById(person_id).get();
        book.setPerson(person);
    }
    @Transactional
    public void deleteBook(Book book){
        sessionFactory.getCurrentSession().delete(book);
    }

    @Transactional
    public void deletePerson(Person person){
        System.out.println("HERE WE START");
        Query query = sessionFactory.getCurrentSession().createNativeQuery("DELETE FROM person where person_id = "+person.getId());
        query.executeUpdate();
        System.out.println("HERE WE FINISH");
    }

    @Transactional
    public void addBook(Book book){
        sessionFactory.getCurrentSession().persist(book);
    }
}
