package me.umar.controllers;

import me.umar.test.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String message = name+" : "+surname;
        model.addAttribute("message", message);
        return "first/hello";
    }

    @GetMapping("/test")
    public String test(Model model){
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Umar"));
        people.add(new Person(2, "Oleg"));
        people.add(new Person(3, "Nika"));
        people.add(new Person(4, "Vika"));
        model.addAttribute("people", people);
        return "first/test";
    }


    @GetMapping("/bye")
    public String sayBye(@RequestParam("name") String name){
        System.out.println(name);
        return "first/bye";
    }
}
