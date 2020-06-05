package com.haivo.medical_notify.service.impl;

import com.haivo.medical_notify.model.Transport;
import com.haivo.medical_notify.model.TransportType;
import com.haivo.medical_notify.repository.TransportRepository;
import com.haivo.medical_notify.service.TransportService;
import com.haivo.medical_notify.service.TransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class TransportServiceImpl implements TransportService {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private TransportTypeService transportTypeService;

    @Override
    public Transport create(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public Transport create(LinkedHashMap<String, String> transportJson) {
        String transportationNo = (String) transportJson.get("transportationNo");
        Transport transport = this.findByTransportationNo(transportationNo);
        if (transport!=null){
            return transport;
        }

        transport = new Transport();
        TransportType transportType = transportTypeService.
                findById(Short.parseShort((String) transportJson.get("transportType")));
        if (transportType==null)
            return null;

        transport.setTransportType(transportType);
        transport.setTransportationNo(transportationNo);
        transport.setNote((String) transportJson.get("note"));
        return this.create(transport);
    }

    @Override
    public Transport findById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    @Override
    public Transport findByTransportationNo(String transportationNo) {
        return transportRepository.findByTransportationNo(transportationNo);
    }

    @Override
    public List<Transport> findByType(Short idType) {
        TransportType transportType = transportTypeService.findById(idType);
        return transportRepository.findAllByTransportType(transportType);
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveSymptomInPlane(Date begin, Date end) {
        return null;
    }

    @Override
    public List<HashMap<String, Long>> countPersonHaveExposureInPlane(Date begin, Date end) {
        return null;
    }

    @Override
    public long countPeronHaveSymptomByTransportType(Date begin, Date end, Short transportTypeId) {
        return 0;
    }
}
