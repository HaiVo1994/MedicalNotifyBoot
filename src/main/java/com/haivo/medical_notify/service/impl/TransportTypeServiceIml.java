package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.TransportType;
import com.haivo.medical_notify.repository.TransportTypeRepository;
import com.haivo.medical_notify.service.TransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TransportTypeServiceIml implements TransportTypeService {
    @Autowired
    private TransportTypeRepository transportTypeRepository;

    @Override
    public Iterable<TransportType> getAll() {
        return transportTypeRepository.findAll();
    }

    @Override
    public TransportType findById(Short id) {
        return transportTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<HashMap<String, Long>> countPerson(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveExposure(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveSymptom(Date begin, Date end) {
        return null;
    }
}
