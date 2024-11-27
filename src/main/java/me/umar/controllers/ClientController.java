package me.umar.controllers;

import me.umar.models.cleintsystem.Client;
import me.umar.models.library.Person;
import me.umar.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clients")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public String index(){
        return "clientsystem/welcome";
    }

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("listClients", clientService.findAll());
        return "clientsystem/list";
    }

    @GetMapping("createClient")
    public String createClient(Model model){
        model.addAttribute("client", new Client());
        return "clientsystem/createclient";
    }

    @PostMapping("createClient")
    public String postCreateClient(@ModelAttribute("client") Client client){
        System.out.println(client);
        clientService.save(client);
        return "redirect:/clients";
    }

}
