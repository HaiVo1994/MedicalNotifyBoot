package com.haivo.medical_notify.formatter;

import com.haivo.medical_notify.model.Symptom;
import com.haivo.medical_notify.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class SymptomFormatter implements Formatter<Symptom> {
    private SymptomService symptomService;
    @Autowired
    public SymptomFormatter(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @Override
    public Symptom parse(String text, Locale locale) throws ParseException {
        return symptomService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Symptom symptom, Locale locale) {
        return "[" + symptom.getId() + ", " + symptom.getName() + "]";
    }
}
