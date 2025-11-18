package com.spring.contactManagerApp.services;

import com.spring.contactManagerApp.entities.Contact;

import java.util.List;

public interface ContactService {

    //Add contact
    public Contact addContactDetail(Contact contact);

    //get all contact detail
    public List<Contact> getAllContactDetail();

    //delete contact
    public void deleteContactDetail(int contactId);

    //update contact
    public Contact updateContactDetail(Contact contact);
}
