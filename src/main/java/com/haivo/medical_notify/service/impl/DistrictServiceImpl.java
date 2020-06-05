package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.District;
import com.haivo.medical_notify.model.Province;
import com.haivo.medical_notify.repository.DistrictRepository;
import com.haivo.medical_notify.service.DistrictService;
import com.haivo.medical_notify.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }

    @Autowired
    private ProvinceService provinceService;
    @Override
    public List<District> findByProvince(Integer id) {
        Province province = provinceService.findById(id);
        if (province!=null)
            return this.findByProvince(province);
        return null;
    }

    @Override
    public List<District> findByProvince(Province province) {
        return districtRepository.findAllByProvince(province);
    }

    @Override
    public District findById(Long id) {
        return districtRepository.findById(id).orElse(null);
    }
}
