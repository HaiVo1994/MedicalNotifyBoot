package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.District;
import com.haivo.medical_notify.model.Ward;
import com.haivo.medical_notify.repository.WardRepository;
import com.haivo.medical_notify.service.DistrictService;
import com.haivo.medical_notify.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WardServiceImpl implements WardService {
    @Autowired
    private WardRepository wardRepository;
    @Override
    public Iterable<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Autowired
    private DistrictService districtService;
    @Override
    public List<Ward> findByDistrict(Long id) {
        District district = districtService.findById(id);
        if (district!=null){
            return this.findByDistrict(district);
        }
        return null;
    }

    @Override
    public List<Ward> findByDistrict(District district) {
        return wardRepository.findAllByDistrict(district);
    }

    @Override
    public Ward findById(Long id) {
        return wardRepository.findById(id).orElse(null);
    }
}
