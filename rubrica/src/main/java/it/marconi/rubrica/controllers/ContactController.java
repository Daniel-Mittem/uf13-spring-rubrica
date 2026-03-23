package it.marconi.rubrica.controllers;

import it.marconi.rubrica.repository.ContactRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.marconi.rubrica.domain.Contact;
import it.marconi.rubrica.domain.ContactForm;
import it.marconi.rubrica.services.ContactServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;



@Controller
public class ContactController {

    @Autowired
    private ContactServices contactServices;

    @GetMapping("/")
    public ModelAndView showContactList(){
        //passo alla webpage la lista dei contatti letta dal db
        return new ModelAndView("contact-list").addObject("contacts", contactServices.findAll());
    }

    @GetMapping("/new")
    public ModelAndView newContactForm() {
        return new ModelAndView("contact-form").addObject(new ContactForm());
    }

    @PostMapping("/new")
    public ModelAndView handleNewContact(@ModelAttribute ContactForm contactForm){
        Contact c = contactServices.save(contactForm);	
        return new ModelAndView("redirect:/contact?id=" + c.getId());
    
    }

    @GetMapping(path = "contact", params ="id")
    public ModelAndView showContact(@RequestParam("id") UUID contactId){
        Optional<Contact> opContact = contactServices.get(contactId);

        // Controllo se il dato è presente
        if(opContact.isPresent()){
            return new ModelAndView("contact-detail").addObject("contact", opContact.get())
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contatto non trovato")
        }
    }
    
}
