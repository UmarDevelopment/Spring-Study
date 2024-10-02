package me.umar.controllers;

import me.umar.dao.ClassesDAO;
import me.umar.models.classes.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String newClasse(Model model){
        model.addAttribute("classe", new Classe());

        return "classes/new";
    }

    @PostMapping("/create")
    public String createClasse(@ModelAttribute("classe") Classe classe){
        dao.addClasse(classe);
        return "redirect:/classes";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("classe", dao.getClasse(id));
        return "classes/edit";
    }

    @PatchMapping("/{id}")
    public String edit1(@ModelAttribute("classe") Classe classe, @PathVariable("id") int id){
        dao.deleteClasse(id);
        dao.addClasse(classe);
        return "redirect:/classes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        dao.deleteClasse(id);
        return "redirect:/classes";
    }
}
