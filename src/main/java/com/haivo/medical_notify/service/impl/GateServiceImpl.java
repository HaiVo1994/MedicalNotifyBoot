package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.Gate;
import com.haivo.medical_notify.repository.GateRepository;
import com.haivo.medical_notify.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class GateServiceImpl implements GateService {
    @Autowired
    private GateRepository gateRepository;
    @Override
    public Iterable<Gate> findAll() {
        return gateRepository.findAll();
    }

    @Override
    public Gate findById(Short id) {
        return gateRepository.findById(id).orElse(null);
    }

    @Override
    public List<HashMap<String, Long>> countPersonEntry(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPersonSymptom(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPersonExposure(Date begin, Date end) {
        return null;
    }
}
