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
                inventory.getLastUpdatedDate()
        );
    }

    //Convert from Dto to Entity
    public static Inventory toEntity(InventoryDto inventoryDto) {

        System.out.println("DTO:::"+inventoryDto.getLastUpdatedDate());
        if (inventoryDto == null) {
            return null;
        }

        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setLocation(inventoryDto.getLocation());
        inventory.setLastUpdatedDate(inventoryDto.getLastUpdatedDate());
        return inventory;
    };
}
