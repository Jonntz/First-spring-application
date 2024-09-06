package br.com.jonatas.Contact.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatas.Contact.models.ContactModel;
import br.com.jonatas.Contact.services.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

  @Autowired
  ContactService contactService;

  @GetMapping()
  public List<ContactModel> contacts(){
    return contactService.listAll();
  }

  @GetMapping("/{email}")
  public ResponseEntity<?> findByEmail(@PathVariable("email") String email){
    var result = contactService.findByEmail(email);
    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    }

    return ResponseEntity.status(404).body("contato não encontrado");
  }

  @PostMapping()
  public ContactModel createContact(@RequestBody ContactModel contactModel){
    contactService.create(contactModel);
    return contactModel;
  }
}
