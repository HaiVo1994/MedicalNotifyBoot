package com.haivo.medical_notify.repository;

import  com.haivo.medical_notify.model.Entry;
import  com.haivo.medical_notify.model.support.Statistical;
import  com.haivo.medical_notify.model.support.Statistical_Entry;
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
public interface EntryRepository extends JpaRepository<Entry,String> {
    @Query("SELECT " +
            "new  com.haivo.medical_notify.model.support.Statistical(e.statuses.size, COUNT(e))  " +
            "FROM Entry e " +
            "WHERE (e.immigrationDate >= :startDate) AND (e.immigrationDate<= :endDate)" +
            "GROUP BY (e.statuses.size)")
    List<Statistical> statisticalSymptomDeparture(@Param("startDate") Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Entry(e.immigrationDate,COUNT(e)) " +
            "FROM Entry e " +
            "WHERE (e.immigrationDate >= :startDate) AND (e.immigrationDate<= :endDate)" +
            "GROUP BY e.immigrationDate " +
            "ORDER BY e.immigrationDate asc ")
    List<Statistical_Entry> statisticalEntry(@Param("startDate") Date begin, @Param("endDate") Date end);

    @Query("SELECT new  com.haivo.medical_notify.model.support.Statistical_Person(" +
            "e.person.name,e.id, e.immigrationDate" +
            ") " +
            "FROM Entry e " +
            "WHERE (e.immigrationDate >= :startDate) AND (e.immigrationDate<= :endDate)" +
            "ORDER BY e.immigrationDate asc ")
    Page<Statistical_Person> getEntriesByImmigrationDate(
            @Param("startDate") Date begin,
            @Param("endDate") Date end,
            Pageable pageable);
}
