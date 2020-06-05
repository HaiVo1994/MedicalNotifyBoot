package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.Symptom;
import com.haivo.medical_notify.repository.SymptomRepository;
import com.haivo.medical_notify.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SymptomServiceImpl implements SymptomService {
    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public Iterable<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    @Override
    public Symptom findById(Long id) {
        return symptomRepository.findById(id).orElse(null);
    }

    @Override
    public Symptom findByName(String name) {
        return symptomRepository.findByNameAndEnabled(name);
    }

    @Override
    public List<Symptom> findAllEnable() {
        return symptomRepository.getAllEnabled();
    }

    @Override
    public HashMap<String, Symptom> findMapEnable() {
        List<Symptom> symptoms = this.findAllEnable();
        HashMap<String, Symptom> mapSymptom = new HashMap<>();
        for (Symptom symptom: symptoms){
            mapSymptom.put(String.valueOf(symptom.getId()),symptom);
        }
        return mapSymptom;
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveSymptom(Date begin, Date end) {
        return null;
    }
}
