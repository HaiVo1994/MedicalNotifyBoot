package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.Contact;
import com.haivo.medical_notify.model.Person;

import java.util.LinkedHashMap;

public interface ContactService {
    Contact findCurrentContactByPerson(Person person);
    Contact findByPhoneAndEmail(String phone, String email);
    Contact create(Contact contact);
    Contact create(Contact contact, String nameHelper);
    Contact change(Contact contact, Person person);
    Contact change(Contact contact, Person person, String nameHelper);
    Contact change(LinkedHashMap<String, String> jsonContact, Person person);
}
