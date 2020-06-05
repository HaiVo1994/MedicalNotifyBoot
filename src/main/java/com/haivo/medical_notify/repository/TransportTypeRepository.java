package com.haivo.medical_notify.repository;

import com.haivo.medical_notify.model.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportTypeRepository extends JpaRepository<TransportType,Short> {
}
