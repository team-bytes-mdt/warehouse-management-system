package de.fhdo.warehouseMgmtSys.models;

public enum Role {
    ADMIN, WAREHOUSE_MANAGER, WAREHOUSE_STAFF;

    public String toString() {
        switch (this) {
            case ADMIN:
                return "Admin";
            case WAREHOUSE_MANAGER:
                return "Warehouse Manager";
            case WAREHOUSE_STAFF:
                return "Warehouse Staff";
        }
        return "";
    }
}
