package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.Exposure;
import com.haivo.medical_notify.repository.ExposureRepository;
import com.haivo.medical_notify.service.ExposureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ExposureServiceImpl implements ExposureService {
    @Autowired
    private ExposureRepository exposureRepository;
    @Override
    public Iterable<Exposure> findAll() {
        return exposureRepository.findAll();
    }

    @Override
    public Exposure findById(Long id) {
        return exposureRepository.findById(id).orElse(null);
    }

    @Override
    public Exposure findByName(String name) {
        return exposureRepository.findByName(name);
    }

    @Override
    public Exposure create(String exposureName) {
        Exposure exposure = new Exposure();
        exposure.setName(exposureName);
        exposure.setEnabled(true);
        return exposureRepository.save(exposure);
    }

    @Override
    public List<Exposure> findAllEnable() {
        return exposureRepository.getAllEnabled();
    }

    @Override
    public HashMap<String, Exposure> mapEnable() {
        List<Exposure> exposures = this.findAllEnable();
        HashMap<String, Exposure> mapExposure = new HashMap<>();
        for (Exposure exposure: exposures){
            mapExposure.put(String.valueOf(exposure.getId()), exposure);
        }
        return mapExposure;
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveExposure(Date begin, Date end) {
        return null;
    }
}
