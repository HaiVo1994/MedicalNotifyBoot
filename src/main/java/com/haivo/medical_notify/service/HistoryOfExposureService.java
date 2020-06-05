package com.haivo.medical_notify.service;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.Entry;
import com.haivo.medical_notify.model.Exposure;
import com.haivo.medical_notify.model.HistoryOfExposure;
import com.haivo.medical_notify.model.support.Statistical;
import com.haivo.medical_notify.model.support.Statistical_Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public interface HistoryOfExposureService {
    HistoryOfExposure create(HistoryOfExposure historyOfExposure);
    HistoryOfExposure create(HistoryOfExposure historyOfExposure, Entry entry, Exposure exposure);
    List<HistoryOfExposure> declare(List<HistoryOfExposure> historyOfExposures, Entry entry, Exposure exposure);
    List<HistoryOfExposure> declare(List<LinkedHashMap<String,String>> historyOfExposures, Entry entry);
    List<Entry> getListEntryHaveExposure(Date begin, Date end);
    List<Entry> getListEntryHaveExposureById(Date begin, Date end, Long exposureId);

    List<JsonObject> statisticalByCountPerson(Date begin, Date end);
    List<JsonObject> statisticalByCountPerson(JsonObject dateEntry);
    List<Statistical> statisticalByTypeExposure(Date begin, Date end);
    List<Statistical> statisticalByTypeExposure(JsonObject dateEntry);

    JsonObject getListByAmountExposure(Date begin, Date end, long amount, int size, int page);
    JsonObject getListByAmountExposure(JsonObject data, int size, int page);
    Page<Statistical_Person> getListByExposureType(Date begin, Date end, Exposure exposure, Pageable pageable);
    Page<Statistical_Person> getListByExposureType(JsonObject data, int size, int page);

    List<HistoryOfExposure> findByEntry(Entry entry);
}
