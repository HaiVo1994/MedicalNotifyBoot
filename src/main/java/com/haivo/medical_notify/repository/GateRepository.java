package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Short> {
}
