package com.haivo.medical_notify.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exposure")
public class Exposure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private Date disable_at;
    private String disable_by;
    private boolean isEnabled;
    private Date create_at;
    private String create_by;
    private Date update_at;
    private String update_by;

    @OneToMany(mappedBy = "exposure", fetch = FetchType.LAZY)
    private List<HistoryOfExposure> historyOfExposures;

    public Exposure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDisable_at() {
        return disable_at;
    }

    public void setDisable_at(Date disable_at) {
        this.disable_at = disable_at;
    }

    public String getDisable_by() {
        return disable_by;
    }

    public void setDisable_by(String disable_by) {
        this.disable_by = disable_by;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public List<HistoryOfExposure> getHistoryOfExposures() {
        return historyOfExposures;
    }

    public void setHistoryOfExposures(List<HistoryOfExposure> historyOfExposures) {
        this.historyOfExposures = historyOfExposures;
    }
}
