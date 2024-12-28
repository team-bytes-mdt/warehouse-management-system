package de.fhdo.warehouseMgmtSys.domain;

public enum Role {
    ADMIN, WAREHOUSE_MANAGER, WAREHOUSE_STAFF, INVENTORY_MANAGER, SYSTEM_ADMINISTRATOR, CUSTOMER;

    public String toString() {
        switch (this) {
            case ADMIN:
                return "ADMIN";
            case WAREHOUSE_MANAGER:
                return "WAREHOUSE MANAGER";
            case WAREHOUSE_STAFF:
                return "WAREHOUSE STAFF";
            case INVENTORY_MANAGER:
                return "INVENTORY MANAGER";
            case SYSTEM_ADMINISTRATOR:
                return "SYSTEM ADMINISTRATOR";
            case CUSTOMER:
                return "CUSTOMER";
        }
        return "";
    }
}
