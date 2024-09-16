package me.umar.controllers;

import me.umar.dao.SecondDAO;
import me.umar.models.second.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/second", produces = "application/json; charset=utf-8")
public class SecondController {

    SecondDAO secondDAO;

    public SecondController(){
        secondDAO = new SecondDAO();
    }

    @GetMapping()
    public String listWordsIndex(){
        return "second/list";
    }

    @GetMapping("/list")
    public String listWords(Model model){
        model.addAttribute("words", secondDAO.getWords());
        return "second/list";
    }

    @GetMapping("/new")
    public String newWord(@ModelAttribute("word") Word word){
        return "second/new";
    }

    @PostMapping()
    public String createWord(@ModelAttribute("word") Word word){
        System.out.println("POST COMMING");
        System.out.println(word.getIntro());
        secondDAO.save(word);
        return "redirect:second/list";
    }
}
