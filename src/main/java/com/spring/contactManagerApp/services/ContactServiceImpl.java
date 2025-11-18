package com.spring.contactManagerApp.services;

import com.spring.contactManagerApp.entities.Contact;
import com.spring.contactManagerApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    //Take repository object to perform database operation
    @Autowired
    private ContactRepository contactRepository;


    @Override
    public Contact addContactDetail(Contact contact) {
        Contact savedetail = contactRepository.save(contact);
        return savedetail;
    }

    @Override
    public List<Contact> getAllContactDetail() {
        List<Contact> allContactDetail = contactRepository.findAll();
        return allContactDetail;
    }

    @Override
    public void deleteContactDetail(int contactId) {
        Contact contact = contactRepository.getById(contactId);
        contactRepository.delete(contact);
    }

    @Override
    public Contact updateContactDetail(Contact contact) {
        Optional<Contact> existingcontactOpt = contactRepository.findById((int) contact.getContactId());

        if(existingcontactOpt.isPresent()){
            //create contact object
           Contact existingContact = existingcontactOpt.get();

           //update the detail
           existingContact.setName(contact.getName());
           existingContact.setEmail(contact.getEmail());
           existingContact.setPhone(contact.getPhone());

            //save into db
            Contact save = contactRepository.save(existingContact);
            return save;
        }else{
            throw new RuntimeException("Contact not found with ID: " +contact.getContactId());
        }
    }
}
