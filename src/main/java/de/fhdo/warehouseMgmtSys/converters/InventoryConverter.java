package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.dto.InventoryDto;

public class InventoryConverter {

    //Convert from Entity to Dto
    public static InventoryDto toDto(Inventory inventory) {
        if (inventory == null) {
            return null;
        }
        return new InventoryDto(
                inventory.getId(),
                inventory.getLocation(),
                inventory.getLast_updated_date()
        );
    }

    //Convert from Dto to Entity
    public static Inventory toEntity(InventoryDto inventoryDto) {
        if (inventoryDto == null) {
            return null;
        }

        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setLocation(inventoryDto.getLocation());
        inventory.setLast_updated_date(inventoryDto.getLastUpdatedDate());
        return inventory;
    };
}
