package com.example.store.controllers;

import com.example.store.repositories.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AutorRepository autorRepository;

    public AuthorController(AutorRepository autorRepository){
        this.autorRepository=autorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", autorRepository.findAll());

        return "authors/list";
    }
}
