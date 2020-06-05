package com.haivo.medical_notify.formatter;

import com.haivo.medical_notify.model.Exposure;
import com.haivo.medical_notify.service.ExposureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ExposureFormatter implements Formatter<Exposure> {
    private ExposureService exposureService;
    @Autowired
    public ExposureFormatter(ExposureService exposureService){
        this.exposureService = exposureService;
    }
    @Override
    public Exposure parse(String text, Locale locale) throws ParseException {
        return exposureService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Exposure exposure, Locale locale) {
        return "[" + exposure.getId() + ", " + exposure.getName() + "]";
    }
}
