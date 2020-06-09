package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.Exposure;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ExposureService {
    Iterable<Exposure> findAll();
    Exposure findById(Long id);
    Exposure findByName(String name);
    Exposure create(String exposureName);
    List<Exposure> findAllEnable();
    HashMap<String, Exposure> mapEnable();
    List<HashMap<String, Long>> countPersonHaveExposure(Date begin, Date end);
}
