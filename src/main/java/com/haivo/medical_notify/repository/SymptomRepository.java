package com.haivo.medical_notify.repository;

import com.haivo.medical_notify.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom,Long> {
    @Query("SELECT s FROM Symptom s " +
            "WHERE s.isEnabled = true")
    List<Symptom> getAllEnabled();
    @Query("SELECT s FROM Symptom s " +
            "WHERE s.name=:name " +
            "AND s.isEnabled = true ")
    Symptom findByNameAndEnabled(@Param("name") String name);
}
