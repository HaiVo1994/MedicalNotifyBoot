package com.haivo.medical_notify.service;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.Entry;
import com.haivo.medical_notify.model.Status;
import com.haivo.medical_notify.model.Symptom;
import com.haivo.medical_notify.model.support.Statistical;
import com.haivo.medical_notify.model.support.Statistical_Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public interface StatusService {
    Status create(Status status, Entry entry, Symptom symptom);
    Status create(Status status);
//    void declare(List<Status> statuses, Entry entry);
    List<Status> declare(List<LinkedHashMap<String,String>> statusJson, Entry entry);

    List<Entry> getListEntryHaveSymptom(Date begin, Date end);
    List<Entry> getListEntryHaveSymptomById(Date begin, Date end, Long symptomId);

    List<JsonObject> statisticalByCountSymptom(Date begin, Date end);
    List<JsonObject> statisticalByCountSymptom(JsonObject dateEntry);
    List<Statistical> statisticalByTypeSymptom(Date begin, Date end);
    List<Statistical> statisticalByTypeSymptom(JsonObject dateEntry);

    JsonObject getListByAmountSymptom(Date begin, Date end, long amount, int size, int page);
    JsonObject getListByAmountSymptom(JsonObject data, int size, int page);
    Page<Statistical_Person> getListBySymptomType(Date begin, Date end, Symptom symptom, Pageable pageable);
    Page<Statistical_Person> getListBySymptomType(JsonObject data, int size, int page);

    List<Status> findByEntry(Entry entry);
}
