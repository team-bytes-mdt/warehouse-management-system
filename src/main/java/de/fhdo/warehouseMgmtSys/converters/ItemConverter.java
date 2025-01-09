package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.Item;
import de.fhdo.warehouseMgmtSys.dto.ItemDto;

public class ItemConverter {

    // Convert from Entity to DTOs
    public static ItemDto toDto(Item itemEntity) {
        return new ItemDto(
                itemEntity.getId(),
                itemEntity.getName(),
                itemEntity.getDescription(),
                itemEntity.getCategory(),
                itemEntity.getQuantity(),
                itemEntity.getPrice(),
                itemEntity.getInventoryId()
        );
    }

    // Convert from DTOs to Entity
    public static Item toEntity(ItemDto itemDto) {
        Item itemEntity = new Item();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());
        itemEntity.setDescription(itemDto.getDescription());
        itemEntity.setCategory(itemDto.getCategory());
        itemEntity.setQuantity(itemDto.getQuantity());
        itemEntity.setPrice(itemDto.getPrice());
        itemEntity.setInventoryId(itemDto.getInventoryId());
        return itemEntity;
    }
}
