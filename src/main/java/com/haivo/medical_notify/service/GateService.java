package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.Gate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface GateService {
    Iterable<Gate> findAll();
    Gate findById(Short id);
    List<HashMap<String,Long>> countPersonEntry(Date begin, Date end);
    List<HashMap<String,Long>> countPersonSymptom(Date begin, Date end);
    List<HashMap<String,Long>> countPersonExposure(Date begin, Date end);
    Gate save(Gate gate);
}
