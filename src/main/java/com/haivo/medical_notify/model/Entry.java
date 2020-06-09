package com.haivo.medical_notify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entry")
public class Entry {
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGate")
    @NotNull
    private  Gate gate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMainTransport")
    @NotNull
    private  Transport transport;
    private String seatNo;

    @NotNull
    private Date departureDate;
    @NotNull
    private Date immigrationDate;
    @Column(columnDefinition="TEXT")
    @NotNull
    private String placeTravel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfProvinceDeparture")
    @NotNull
    private  Province provinceDeparture;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfProvinceDestination")
    @NotNull
    private  Province provinceDestination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPerson")
    @NotNull
    private  Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idContactHelpDeclare")
    @JsonIgnore
    private  Contact contactHelpDeclare;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY)
    @JsonIgnore
    private List< Status> statuses;
    @Column(columnDefinition="TEXT")
    private String listCure;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY)
    @JsonIgnore
    private List< HistoryOfExposure> historyOfExposures;

    private String createBy;
    private Date createAt;
    private boolean isDelete;
    private String updateBy;
    private Date updateAt;

    public Entry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  Gate getGate() {
        return gate;
    }

    public void setGate( Gate gate) {
        this.gate = gate;
    }

    public  Transport getTransport() {
        return transport;
    }

    public void setTransport( Transport transport) {
        this.transport = transport;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getImmigrationDate() {
        return immigrationDate;
    }

    public void setImmigrationDate(Date immigrationDate) {
        this.immigrationDate = immigrationDate;
    }

    public String getPlaceTravel() {
        return placeTravel;
    }

    public void setPlaceTravel(String placeTravel) {
        this.placeTravel = placeTravel;
    }

    public  Province getProvinceDeparture() {
        return provinceDeparture;
    }

    public void setProvinceDeparture( Province provinceDeparture) {
        this.provinceDeparture = provinceDeparture;
    }

    public  Province getProvinceDestination() {
        return provinceDestination;
    }

    public void setProvinceDestination( Province provinceDestination) {
        this.provinceDestination = provinceDestination;
    }

    public  Person getPerson() {
        return person;
    }

    public void setPerson( Person person) {
        this.person = person;
    }

    public  Contact getContactHelpDeclare() {
        return contactHelpDeclare;
    }

    public void setContactHelpDeclare( Contact contactHelpDeclare) {
        this.contactHelpDeclare = contactHelpDeclare;
    }

    public List< Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List< Status> statuses) {
        this.statuses = statuses;
    }

    public String getListCure() {
        return listCure;
    }

    public void setListCure(String listCure) {
        this.listCure = listCure;
    }

    public List< HistoryOfExposure> getHistoryOfExposures() {
        return historyOfExposures;
    }

    public void setHistoryOfExposures(List< HistoryOfExposure> historyOfExposures) {
        this.historyOfExposures = historyOfExposures;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
