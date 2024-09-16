package me.umar.controllers;

import me.umar.dao.ClassesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("classes")
public class ClassSchedulerController {

    ClassesDAO dao;

    @Autowired
    public ClassSchedulerController(ClassesDAO dao){
        this.dao = dao;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("classes", dao.getClasses());
        return "classes/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("classe", dao.getClasse(id));
        return "classes/show";
    }
}
