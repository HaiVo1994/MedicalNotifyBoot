package com.haivo.medical_notify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transport_type")
public class TransportType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;
    private String name;
    @OneToMany(mappedBy = "transportType", fetch = FetchType.LAZY)
    @JsonIgnore
    private List< Transport> transports;

    public TransportType() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List< Transport> getTransports() {
        return transports;
    }

    public void setTransports(List< Transport> transports) {
        this.transports = transports;
    }
}
