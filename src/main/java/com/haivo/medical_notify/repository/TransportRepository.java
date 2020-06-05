package com.haivo.medical_notify.repository;

import com.haivo.medical_notify.model.Transport;
import com.haivo.medical_notify.model.TransportType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends CrudRepository<Transport,Long> {
    Transport findByTransportationNo(String transportationNo);
    List<Transport> findAllByTransportType(TransportType transportType);
}
