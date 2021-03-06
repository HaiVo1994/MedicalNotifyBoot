package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.Contact;
import com.haivo.medical_notify.model.Person;
import com.haivo.medical_notify.model.Ward;
import com.haivo.medical_notify.repository.ContactRepository;
import com.haivo.medical_notify.service.ContactService;
import com.haivo.medical_notify.service.PersonService;
import com.haivo.medical_notify.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact findCurrentContactByPerson(Person person) {
        return contactRepository.findCurrentContactByPerson(person);
    }

    @Override
    public Contact findByPhoneAndEmail(String phone, String email) {
        return contactRepository.findContactByPhoneAndEmail(phone,email);
    }

    @Override
    public Contact create(Contact contact) {
        contact.setCreate_at(new Date());
        return contactRepository.save(contact);
    }

    @Override
    public Contact create(Contact contact, String nameHelper) {
        contact.setCreate_by(nameHelper);
        return this.create(contact);
    }

    @Override
    public Contact change(Contact contact, Person person) {
        Contact currentContact = this.findCurrentContactByPerson(person);
        if (currentContact!=null){
            if (
                    (currentContact.getEmail().equals(contact.getAddress())) &&
                            (currentContact.getEmail().equals(contact.getEmail())) &&
                            (currentContact.getLocation() == contact.getLocation()) &&
                            (currentContact.getPhone().equals(contact.getPhone()))
            ){
                return currentContact;
            }
            else {
                currentContact.setDisable_at(new Date());
                currentContact.setDisable_by(contact.getCreate_by());
                currentContact.setEnabled(false);
                contactRepository.save(currentContact);
            }
        }
        return this.create(contact);
    }

    @Override
    public Contact change(Contact contact, Person person, String nameHelper) {
        contact.setCreate_by(nameHelper);
        return this.change(contact,person);
    }

    @Autowired
    private PersonService personService;
    @Autowired
    private WardService wardService;
    @Override
    public Contact change(LinkedHashMap<String, String> jsonContact, Person person) {
//        Person person = personService.findByPassport(String.valueOf(jsonContact.get("person")));
        if(person!=null){
            Contact contact = new Contact();
            contact.setName(String.valueOf(jsonContact.get("name")));
            Ward location = wardService.findById(Long.parseLong((String) jsonContact.get("location")));
            contact.setLocation(location);
            contact.setAddress(String.valueOf(jsonContact.get("address")));
            contact.setPhone(String.valueOf(jsonContact.get("phone")));
            contact.setEmail(String.valueOf(jsonContact.get("email")));
            contact.setEnabled(true);
            contact.setCreate_by(String.valueOf(jsonContact.get("create_by")));
            contact.setPerson(person);
            return this.change(contact, person);
        }
        return null;
    }
}
