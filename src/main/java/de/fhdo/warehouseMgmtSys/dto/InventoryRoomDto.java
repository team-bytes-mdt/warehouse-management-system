package de.fhdo.warehouseMgmtSys.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class InventoryRoomDto {
    private long id;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdatedDate;

    public InventoryRoomDto() {}

    public InventoryRoomDto(long id, String location, LocalDateTime lastUpdatedDate) {
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
    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
