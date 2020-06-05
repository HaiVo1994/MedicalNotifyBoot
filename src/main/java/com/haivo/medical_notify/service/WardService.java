package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.District;
import com.haivo.medical_notify.model.Ward;

import java.util.List;

public interface WardService {
    Iterable<Ward> findAll();
    List<Ward> findByDistrict(Long id);
    List<Ward> findByDistrict(District district);
    Ward findById(Long id);
}
