package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.National;
import com.haivo.medical_notify.model.Province;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ProvinceService {
    Province findById(Integer id);
    Province create(String provinceName, National national);
    List<Province> findAllByNational(Short idNational);
    List<Province> findAllByNational(National national);
    List<HashMap<String,Long>> countPerSonByDeparture(Date begin, Date end);
    List<HashMap<String,Long>> countPerSonHaveSymptomByDeparture(Date begin, Date end);
    List<HashMap<String,Long>> countPerSonHaveSymptomByDestination(Date begin, Date end);
    List<HashMap<String,Long>> countPerSonHaveExposureByDeparture(Date begin, Date end);
    List<HashMap<String,Long>> countPerSonHaveExposureByDestination(Date begin, Date end);
}
