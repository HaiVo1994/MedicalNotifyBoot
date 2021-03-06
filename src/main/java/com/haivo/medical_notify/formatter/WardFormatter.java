package com.haivo.medical_notify.formatter;

import com.haivo.medical_notify.model.Ward;
import com.haivo.medical_notify.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class WardFormatter implements Formatter<Ward> {
    private WardService wardService;

    @Autowired
    public WardFormatter(WardService wardService) {
        this.wardService = wardService;
    }

    @Override
    public Ward parse(String text, Locale locale) throws ParseException {
        return wardService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Ward ward, Locale locale) {
        return "[" + ward.getId() + ", " + ward.getName() + "]";
    }
}
