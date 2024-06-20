package me.umar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "first/hello";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "first/bye";
    }
}
