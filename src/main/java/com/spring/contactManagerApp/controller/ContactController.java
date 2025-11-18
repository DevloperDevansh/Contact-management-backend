package com.spring.contactManagerApp.controller;


import com.spring.contactManagerApp.entities.Contact;
import com.spring.contactManagerApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    //take object of service
    @Autowired
    private ContactService contactService;


    //default page
    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }

    //Add contact Api
    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody Contact contact){
        //call the add method from the service method
        try {
            Contact addContact = contactService.addContactDetail(contact);
            return new ResponseEntity<>(addContact, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Server Error::"+e.getMessage());
            return new ResponseEntity<>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all contact detail api
    @GetMapping("/getAllContact")
    public ResponseEntity<?> getAllContact(){
        try {
            List<Contact> allContactDetail = contactService.getAllContactDetail();
            return ResponseEntity.ok(allContactDetail);
        } catch (Exception e) {
            System.out.println("Server error to fetch data "+e.getMessage());
            return new ResponseEntity<>("Server error to fetch ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete Api to delete contact from db
    @DeleteMapping("deleteContact/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable String contactId){
        try {
            contactService.deleteContactDetail(Integer.parseInt(contactId));
            return new ResponseEntity<>("Deleted Contact Successfully",HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Server error to delete data"+e.getMessage());
            return new ResponseEntity<>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update Api to update contact from db
    @PutMapping("/updateContact")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact){
        try {
            Contact upadtedContact = contactService.updateContactDetail(contact);
            return new ResponseEntity<>(upadtedContact,HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Server error"+e.getMessage());
            return new ResponseEntity<>("Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
