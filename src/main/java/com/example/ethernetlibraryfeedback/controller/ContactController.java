package com.example.ethernetlibraryfeedback.controller;


import com.example.ethernetlibraryfeedback.entity.Contact;
import com.example.ethernetlibraryfeedback.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private ContactService contactService;
    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    //handler method
    @GetMapping("/contacts")
    public String listContacts(Model model){
        model.addAttribute("contacts", contactService.getAllContacts());
        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String createContactForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "createcontact";
    }

    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute ("contact") Contact contact){
        contactService.saveContact(contact);
        return "redirect:/contacts" ;
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContactForm( @PathVariable Long id, Model model){
        model.addAttribute("contact", contactService.getContactById(id));
        return "editcontact";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable Long id,@ModelAttribute("contact") Contact contact, Model model){
        Contact existingContact = contactService.getContactById(id);
        existingContact.setId(contact.getId());
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setBook(contact.getBook());
        existingContact.setEmail(contact.getEmail());

        contactService.updateContact(existingContact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Long id, Model model){
        contactService.deleteContactById(id);
        model.addAttribute("message", "Contact deleted successfully");
        model.addAttribute("returnUrl", "/contacts");
        return "successpage";
    }
}