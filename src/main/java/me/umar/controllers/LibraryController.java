package me.umar.controllers;

import me.umar.dao.LibraryDAO;
import me.umar.models.library.Book;
import me.umar.models.library.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("library")
public class LibraryController {

    LibraryDAO dao;

    @Autowired
    public LibraryController(LibraryDAO dao){
        this.dao = dao;
    }

    @GetMapping
    public String welcomeLibraryPage(){

        return "library/welcome";
    }

    @GetMapping("addPerson")
    public String addNewPerson(Model model){
        model.addAttribute("person", new Person());
        return "library/addPerson";
    }

    @GetMapping("addBook")
    public String addNewBook(Model model){
        model.addAttribute("book", new Book());
        return "library/addBook";
    }

    @PostMapping("addPerson")
    public String addNewPerson(@ModelAttribute("person") Person person){
        dao.addPerson(person);
        return "redirect:/library";
    }

    @PostMapping("addBook")
    public String addNewBook(@ModelAttribute("book") Book book){
        dao.addBook(book);
        return "redirect:/library";
    }

    @GetMapping("listPeople")
    public String listAllPeople(Model model){
        model.addAttribute("listPeople", dao.listAllPeople());
        return "library/listPeople";
    }

    @GetMapping("listBook")
    public String listAllBooks(Model model){
        model.addAttribute("listBook", dao.listAllBook());
        return "library/listBook";
    }

    @GetMapping("personDetail/{id}")
    public String personDetail(@PathVariable("id") int id, Model model){
        Person person = dao.getPersonById(id).get();
        model.addAttribute("person", person);
        return "library/detailPerson";
    }

    @GetMapping("bookDetail/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model){
        Book book = dao.getBookById(id).get();
        model.addAttribute("book", book);
        model.addAttribute("people", dao.listAllPeople());
        Person person = new Person();
        if (dao.getPersonById(book.getPerson_id()).isPresent()){
            person = dao.getPersonById(book.getPerson_id()).get();
        }else{
            person.setExists(false);
        }
        model.addAttribute("person", person);
        return "library/detailBook";
    }

    @GetMapping("editPerson/{id}")
    public String editPerson(@PathVariable("id") int id,  Model model){
        Person person = dao.getPersonById(id).get();
        model.addAttribute("person", person);
        return "library/editPerson";
    }

    @GetMapping("editBook/{id}")
    public String editBook(@PathVariable("id") int id,  Model model){
        Book book = dao.getBookById(id).get();
        model.addAttribute("book", book);
        return "library/editBook";
    }

    @PatchMapping("editPerson/{id}")
    public String editPersonPatch(@ModelAttribute("person") Person person){
        dao.updatePerson(person);
        return "library/detailPerson";
    }

    @PatchMapping("editBook")
    public String editBookPatch(@ModelAttribute("book") Book book){
        dao.updateBook(book);
        int id = book.getId();
        return String.format("redirect:/library/bookDetail/%s", id);
    }

    @PatchMapping("releaseBook")
    public String releaseBook(@ModelAttribute("book") Book book){
        dao.releaseBook(book);
        int id = book.getId();
        return String.format("redirect:/library/bookDetail/%s", id);
    }

    @PatchMapping("{book_id}/reserveBook")
    public String reserveBook(@ModelAttribute("person") Person person, @PathVariable("book_id") int book_id){
        dao.reserveBook(person, book_id);
        return String.format("redirect:/library/bookDetail/%s", book_id);
    }

    @DeleteMapping("deleteBook")
    public String deleteBook(@ModelAttribute("book") Book book){
        dao.deleteBook(book);
        return "redirect:/library/listBook";
    }

    @DeleteMapping("deletePerson")
    public String deleteBook(@ModelAttribute("person") Person person){
        System.out.println(person);
        dao.deletePerson(person);
        return "redirect:/library/listPeople";
    }
}
