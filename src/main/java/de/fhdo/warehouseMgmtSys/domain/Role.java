package de.fhdo.warehouseMgmtSys.domain;

public enum Role { WAREHOUSE_MANAGER, WAREHOUSE_STAFF, SYSTEM_ADMINISTRATOR;

    public String toString() {
        switch (this) {
            case WAREHOUSE_MANAGER:
                return "WAREHOUSE MANAGER";
            case WAREHOUSE_STAFF:
                return "WAREHOUSE STAFF";
            case SYSTEM_ADMINISTRATOR:
                return "SYSTEM ADMINISTRATOR";
        }
        return "";
    }
}
