package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.National;
import com.haivo.medical_notify.model.Province;
import com.haivo.medical_notify.repository.ProvinceRepository;
import com.haivo.medical_notify.service.NationalService;
import com.haivo.medical_notify.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl  implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private NationalService nationalService;
    @Override
    public Province findById(Integer id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Province> findAllByNational(Short idNational) {
        National national = nationalService.findById(idNational);
        return this.findAllByNational(national);
    }

    @Override
    public List<Province> findAllByNational(National national) {
        return provinceRepository.findAllByNational(national);
    }

    @Override
    public List<HashMap<String, Long>> countPerSonByDeparture(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPerSonHaveSymptomByDeparture(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPerSonHaveSymptomByDestination(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPerSonHaveExposureByDeparture(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPerSonHaveExposureByDestination(Date begin, Date end) {
        return null;
    }
}
