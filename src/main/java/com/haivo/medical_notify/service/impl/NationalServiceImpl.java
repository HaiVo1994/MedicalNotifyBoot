package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.National;
import com.haivo.medical_notify.repository.NationalRepository;
import com.haivo.medical_notify.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NationalServiceImpl implements NationalService {
    @Autowired
    private NationalRepository nationalRepository;
    @Override
    public Iterable<National> findAll() {
        return nationalRepository.findAll();
    }

    @Override
    public National findById(Short id) {
        return nationalRepository.findById(id).orElse(null);
    }
}
