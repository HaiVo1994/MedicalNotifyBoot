package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Entry;
import  com.haivo.medical_notify.model.Status;
import  com.haivo.medical_notify.model.Symptom;
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
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical(s.entry.id, " +
            "SUM(CASE s.haveSymptom WHEN true THEN 1 ELSE 0 END)) " +
            "FROM Status s " +
            "WHERE s.entry.immigrationDate >= :startDate AND s.entry.immigrationDate<= :endDate " +
            "GROUP BY s.entry")
    List<Statistical> countSymptom(@Param("startDate") Date begin, @Param("endDate") Date end);

    @Query("SELECT new   com.haivo.medical_notify.model.support.Statistical(s.symptom.name, " +
            "SUM(CASE s.haveSymptom WHEN true THEN 1 ELSE 0 END))" +
            "FROM Status s " +
            "WHERE s.entry.immigrationDate >= :startDate AND s.entry.immigrationDate <= :endDate " +
            "GROUP BY s.symptom.name")
    List<Statistical> countForSymptomType(@Param("startDate") Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Person(s.entry.person.name,s.entry.id, " +
            "s.entry.immigrationDate, SUM(CASE s.haveSymptom WHEN true THEN 1 ELSE 0 END)) " +
            "FROM Status s " +
            "WHERE s.entry.immigrationDate >= :startDate AND s.entry.immigrationDate<= :endDate " +
            "GROUP BY s.entry.person.name,s.entry.id,s.entry.immigrationDate " +
            "ORDER BY s.entry.immigrationDate")
    List<Statistical_Person> getListPersonByAmountSymptom(@Param("startDate") Date begin,
                                                          @Param("endDate") Date end);
    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Person(" +
            "s.entry.person.name,s.entry.id, s.entry.immigrationDate" +
            ") " +
            "FROM Status s " +
            "WHERE s.entry.immigrationDate >= :startDate AND s.entry.immigrationDate<= :endDate " +
            "AND s.symptom = :symptom " +
            "AND s.haveSymptom = true " +
            "ORDER BY s.entry.immigrationDate")
    Page<Statistical_Person> getListPersonBySymptomType(@Param("startDate") Date begin,
                                                        @Param("endDate") Date end,
                                                        @Param("symptom") Symptom symptom,
                                                        Pageable pageable);

    List<Status> findByEntry(Entry entry);
}
