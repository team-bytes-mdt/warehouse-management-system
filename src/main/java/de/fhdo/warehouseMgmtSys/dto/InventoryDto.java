package de.fhdo.warehouseMgmtSys.dto;

import java.util.Date;

public class InventoryDto {
    private long id;
    private String location;
    private Date lastUpdatedDate;

    public InventoryDto() {}

    public InventoryDto(long id, String location, Date lastUpdatedDate) {
        this.id = id;
        this.location = location;
        this.lastUpdatedDate = lastUpdatedDate;
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
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    public void setLastUpdatedDate(Date lastUpdatedDate) {

    }
}
