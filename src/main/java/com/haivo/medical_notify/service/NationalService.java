package com.haivo.medical_notify.service;

import com.haivo.medical_notify.model.National;

public interface NationalService {
    Iterable<National> findAll();
    National findById(Short id);
}
