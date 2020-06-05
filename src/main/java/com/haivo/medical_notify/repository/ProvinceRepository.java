package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.National;
import  com.haivo.medical_notify.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    List<Province> findAllByNational(National national);
}
