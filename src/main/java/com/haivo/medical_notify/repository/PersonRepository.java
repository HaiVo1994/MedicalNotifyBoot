package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
    @Query("SELECT p FROM Person p " +
            "WHERE p.passport=:passport AND p.isEnabled=true ")
    List<Person> findByPassport(@Param("passport") String passport);
}
