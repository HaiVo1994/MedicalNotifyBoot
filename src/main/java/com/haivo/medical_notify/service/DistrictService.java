package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.District;
import com.haivo.medical_notify.model.Province;

import java.util.List;

public interface DistrictService {
    Iterable<District> findAll();
    List<District> findByProvince(Integer id);
    List<District> findByProvince(Province province);
    District findById(Long id);
}
