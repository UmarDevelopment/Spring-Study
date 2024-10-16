package me.umar.controllers;

import me.umar.dao.LibraryDAO;
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

    @PostMapping("addPerson")
    public String addNewPerson(@ModelAttribute("person") Person person){
        System.out.println(person);
        dao.addPerson(person);
        return "redirect:/library";
    }

    @GetMapping("listPeople")
    public String listAllPeople(Model model){
        model.addAttribute("listPeople", dao.listAllPeople());
        return "library/listPeople";
    }

    @GetMapping("personDetail/{id}")
    public String personDetail(@PathVariable("id") int id, Model model){
        Person person = dao.getPersonById(id).get();
        model.addAttribute("person", person);
        return "library/detailPerson";
    }

    @GetMapping("editPerson/{id}")
    public String editPerson(@PathVariable("id") int id,  Model model){
        Person person = dao.getPersonById(id).get();
        model.addAttribute("person", person);
        return "library/editPerson";
    }

    @PatchMapping("editPerson/{id}")
    public String editPersonPatch(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        System.out.println(id);
        System.out.println(person);
        return "redirect:/library";
    }
}
