package de.fhdo.warehouseMgmtSys.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "INVENTORY_ROOMS")
public class InventoryRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTORY_ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "LAST_UPDATED_DATE", nullable = false, updatable = false)
    private LocalDateTime lastUpdatedDate;

    public InventoryRoom() {
        // Default constructor
    }


    public InventoryRoom(String location, LocalDateTime lastUpdatedDate) {
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
    private void onCreate() {
        this.lastUpdatedDate = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.lastUpdatedDate = LocalDateTime.now();
    }
}