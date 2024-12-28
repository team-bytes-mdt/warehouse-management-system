package de.fhdo.warehouseMgmtSys.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTORY_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "LAST_UPDATED_DATE", nullable = false)
    private LocalDateTime lastUpdatedDate;

    public Inventory() {
        // Default constructor
    }


    public Inventory(String location, LocalDateTime lastUpdatedDate) {
        this.location = location;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @PrePersist
    @PreUpdate
    private void updateTimestamp() {
        this.lastUpdatedDate = LocalDateTime.now();
    }
}