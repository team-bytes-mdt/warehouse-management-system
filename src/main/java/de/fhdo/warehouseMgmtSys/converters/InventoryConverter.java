package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.InventoryRoom;
import de.fhdo.warehouseMgmtSys.dto.InventoryRoomDto;

public class InventoryConverter {

    //Convert from Entity to Dto
    public static InventoryRoomDto toDto(InventoryRoom inventory) {
        if (inventory == null) {
            return null;
        }
        return new InventoryRoomDto(
                inventory.getId(),
                inventory.getLocation(),
                inventory.getLastUpdatedDate()
        );
    }

    //Convert from Dto to Entity
    public static InventoryRoom toEntity(InventoryRoomDto inventoryRoomDto) {

        System.out.println("DTO:::"+ inventoryRoomDto.getLastUpdatedDate());
        if (inventoryRoomDto == null) {
            return null;
        }

        InventoryRoom inventory = new InventoryRoom();
        inventory.setId(inventoryRoomDto.getId());
        inventory.setLocation(inventoryRoomDto.getLocation());
        inventory.setLastUpdatedDate(inventoryRoomDto.getLastUpdatedDate());
        return inventory;
    };
}
