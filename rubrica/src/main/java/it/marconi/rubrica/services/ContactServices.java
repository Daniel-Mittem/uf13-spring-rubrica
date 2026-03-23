package it.marconi.rubrica.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marconi.rubrica.domain.Contact;
import it.marconi.rubrica.domain.ContactForm;
import it.marconi.rubrica.repository.ContactRepository;

@Service
public class ContactServices {
    
    // dependecy injection
    @Autowired
    private ContactRepository contactRepository;

    public Contact save(ContactForm contactForm){

        Contact c = mapContact(contactForm);
        return contactRepository.save(c);
    }

    private Contact mapContact(ContactForm form){
        Contact c = new Contact();
        c.setName(form.getName());
        c.setSurname(form.getSurname());
        c.setPhone(form.getPhone());
        c.setEmail(form.getEmail());

        return c;

    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Optional<Contact> get(UUID id) {
        return contactRepository.findById(id);
    }
    
}
