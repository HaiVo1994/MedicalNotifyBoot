package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Exposure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExposureRepository extends JpaRepository<Exposure,Long> {
    @Query("SELECT e FROM Exposure e " +
            "WHERE e.isEnabled = true")
    List<Exposure> getAllEnabled();
    @Query("SELECT e FROM Exposure e " +
            "WHERE e.name=:name " +
            "AND e.isEnabled = true")
    Exposure findByName(@Param("name") String name);
}
