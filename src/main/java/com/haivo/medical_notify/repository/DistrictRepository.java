package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.District;
import  com.haivo.medical_notify.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findAllByProvince(Province province);
}
