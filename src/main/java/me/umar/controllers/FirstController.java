package me.umar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/bye")
    public String sayBye(@RequestParam("name") String name){
        System.out.println(name);
        return "first/bye";
    }
}
