package de.fhdo.warehouseMgmtSys.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="INVENTORY")
public class Inventory {
    @Id
    @Column(name="INVENTORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="LOCATION")
    private String location;
    @Column(name="LAST_UPDATED_DATE")
    private Date last_updated_date;

    public Inventory(long id, String location, Date last_updated_date) {
        this.id = id;
        this.location = location;
        this.last_updated_date = last_updated_date;
    }

    public Inventory() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(Date last_updated_date) {
        this.last_updated_date = last_updated_date;
    }
}
