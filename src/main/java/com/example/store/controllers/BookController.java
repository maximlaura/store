package com.example.store.controllers;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.store.domain.Carte;
import com.example.store.repositories.CarteRepository;
import com.example.store.repositories.EdituraRepository;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookController {
    @Autowired
    private CarteRepository repository;

    @Autowired
    private EdituraRepository lrepository;

    @RequestMapping(value="/*")
    public String homePage(){
        return "index";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    /*@RequestMapping(value="/books/carti")
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "/books/carti";
    }*/

    @RequestMapping("/books")
    public String getBook(Model model){
        model.addAttribute("lista_carti", repository.findAll());
        return "books/carti";
    }

    //Add a new book
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/addBook",method=RequestMethod.GET)
    public String showBook(Model model){
        model.addAttribute("carte", new Carte());
        model.addAttribute("edituri", lrepository.findAll());
        return "/addBook";
    }

    //Save a book
    @RequestMapping (value="/save", method=RequestMethod.POST)
    public String saveBook(Carte book){
        repository.save(book);
        return "redirect:carti";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping (value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Integer id, Model model){
        repository.deleteById(id);
        return "redirect:../carti";
    }

    //Restful Service to get all books
   /* @RequestMapping(value="/books",method= RequestMethod.GET)
    public @ResponseBody List<Carte> bookRest(){
        return (List<Carte>) repository.findAll();
    }*/

    /*@RequestMapping(value="/books/{id}",method=RequestMethod.GET)
    public @ResponseBody List <Carte> findBookRest(@PathVariable ("id") Integer id){
        return repository.findbyId(id);
    }*/

    //Edit a book
  /* @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping (value="/edit/{id}")
    public String editBook(@PathVariable("id") Integer id,Model model){
        model.addAttribute("book",repository.findbyId(id));
        model.addAttribute("library",lrepository.findAll());
        return "editBook";
    }*/

}


/*import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final CarteRepository carteRepository;

    public BookController(CarteRepository carteRepository) {
        this.carteRepository=carteRepository;
    }

    @RequestMapping("/books")


   public String getBook(Model model){

       model.addAttribute("lista_carti", carteRepository.findAll());

        return "books/carti";
    }
}*/
