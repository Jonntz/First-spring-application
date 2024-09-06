package br.com.jonatas.Contact.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.jonatas.Contact.models.ContactModel;

@Service
public class ContactService {
  List<ContactModel> contacts = new ArrayList<ContactModel>();

  public ContactModel create(ContactModel contact){
    contact.setId(UUID.randomUUID());
    contacts.add(contact);

    return contact;
  }

  public List<ContactModel> listAll(){
    return contacts;
  }

  public Optional<ContactModel> findByEmail(String email){
    return this.contacts.stream()
                .filter(contact -> contact.getEmail().equals(email)).findFirst();
  }
}
