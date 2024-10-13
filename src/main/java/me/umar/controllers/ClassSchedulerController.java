package me.umar.controllers;

import me.umar.dao.ClassesDAO;
import me.umar.models.classes.Classe;
import me.umar.util.ClasseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("classes")
public class ClassSchedulerController {

    ClassesDAO dao;
    ClasseValidator validator;

    @Autowired
    public ClassSchedulerController(ClassesDAO dao, ClasseValidator validator) {
        this.dao = dao;
        this.validator = validator;
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
    public String createClasse(@ModelAttribute("classe") @Valid Classe classe, BindingResult bindingResult){
        validator.validate(classe, bindingResult);
        if (bindingResult.hasErrors()){
            return "classes/new";
        }
        dao.addClasse(classe);
        return "redirect:/classes";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("classe", dao.getClasse(id));
        return "classes/edit";
    }

    @PatchMapping("/{id}")
    public String edit1(@ModelAttribute("classe") @Valid Classe classe, BindingResult bindingResult, @PathVariable("id") int id){
        validator.validate(classe, bindingResult);
        if (bindingResult.hasErrors()){
            return "classes/edit";
        }
        dao.deleteClasse(id);
        dao.addClasse(classe);
        return "redirect:/classes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        dao.deleteClasse(id);
        return "redirect:/classes";
    }

    @GetMapping("/select")
    public String select(Model model, @ModelAttribute("classe") Classe classe){
        model.addAttribute("classes", dao.getClasses());
        return "classes/select_classe";
    }

    @PatchMapping("/select")
    public String select(@ModelAttribute("classe") Classe classe){
        System.out.println(classe.getId());
        return "redirect:/classes";
    }
}
