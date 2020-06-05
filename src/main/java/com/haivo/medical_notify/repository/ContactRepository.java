package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Contact;
import  com.haivo.medical_notify.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c " +
            "WHERE c.isEnabled = true AND c.person = :person")
    Contact findCurrentContactByPerson(@Param("person") Person person);
    Contact findContactByPhoneAndEmail(String phone, String email);
}
