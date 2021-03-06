package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Entry;
import  com.haivo.medical_notify.model.Exposure;
import  com.haivo.medical_notify.model.HistoryOfExposure;
import  com.haivo.medical_notify.model.support.Statistical;
import  com.haivo.medical_notify.model.support.Statistical_Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryOfExposureRepository extends JpaRepository<HistoryOfExposure, Long> {
    @Query("SELECT distinct (h.entry) FROM HistoryOfExposure h " +
            "WHERE h.dateDeclare>= :beginDate AND h.dateDeclare< :endDate " +
            "AND h.hasExposure = true ")
    List<Entry> getEntryHasExposure(@Param("beginDate")Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical(h.entry.id, " +
            "SUM(CASE h.hasExposure WHEN true THEN 1 ELSE 0 END)) " +
            "FROM HistoryOfExposure h " +
            "WHERE h.entry.immigrationDate >= :beginDate AND h.entry.immigrationDate< :endDate " +
            "GROUP BY h.entry")
    List<Statistical> statisticalByAmountPeople(@Param("beginDate")Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Person(h.entry.person.name,h.entry.id, " +
            "h.entry.immigrationDate ,SUM(CASE h.hasExposure WHEN true THEN 1 ELSE 0 END)) " +
            "FROM HistoryOfExposure h " +
            "WHERE h.entry.immigrationDate >= :beginDate AND h.entry.immigrationDate< :endDate " +
            "GROUP BY h.entry.person.name,h.entry.id,h.entry.immigrationDate " +
            "ORDER BY h.entry.immigrationDate")
    List<Statistical_Person> getListPersonByAmountExposure(@Param("beginDate")Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical(h.exposure.name, " +
            "SUM(CASE h.hasExposure WHEN true THEN 1 ELSE 0 END)) " +
            "FROM HistoryOfExposure h " +
            "WHERE h.entry.immigrationDate >= :beginDate AND h.entry.immigrationDate< :endDate " +
            "GROUP BY h.exposure.name")
    List<Statistical> statisticalByTypeExposure(@Param("beginDate")Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Person(" +
            "h.entry.person.name,h.entry.id, h.entry.immigrationDate" +
            ") " +
            "FROM HistoryOfExposure h " +
            "WHERE h.entry.immigrationDate >= :startDate AND h.entry.immigrationDate<= :endDate " +
            "AND h.exposure = :exposure " +
            "AND h.hasExposure = true " +
            "ORDER BY h.entry.immigrationDate")
    Page<Statistical_Person> getListPersonBySymptomType(@Param("startDate") Date begin,
                                                        @Param("endDate") Date end,
                                                        @Param("exposure") Exposure exposure,
                                                        Pageable pageable);
    List<HistoryOfExposure> findByEntry(Entry entry);
}
