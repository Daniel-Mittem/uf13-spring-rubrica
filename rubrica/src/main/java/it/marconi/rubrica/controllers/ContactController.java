package it.marconi.rubrica.controllers;

import it.marconi.rubrica.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.marconi.rubrica.domain.Contact;
import it.marconi.rubrica.domain.ContactForm;
import it.marconi.rubrica.services.ContactServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
        return new ModelAndView("contact-form");
        
    }
    
}
