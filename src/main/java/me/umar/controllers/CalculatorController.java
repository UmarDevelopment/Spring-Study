package me.umar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/mult")
    public String getMult(HttpServletRequest request, Model model){
        int val1 = Integer.valueOf(request.getParameter("val1"));
        int val2 = Integer.valueOf(request.getParameter("val2"));
        int answer = val1*val2;
        model.addAttribute("result", val1+" * "+val2 +" = "+answer);
        return "calculator/answer";
    }

    @GetMapping("/div")
    public String getDiv(HttpServletRequest request, Model model){
        double val1 = Double.valueOf(request.getParameter("val1"));
        double val2 = Double.valueOf(request.getParameter("val2"));
        double answer = val1/val2;
        model.addAttribute("result", val1+" / "+val2 +" = "+answer);
        return "calculator/answer";
    }

    @GetMapping("")
    public String get(){
        return "calculator/calc";
    }
}
