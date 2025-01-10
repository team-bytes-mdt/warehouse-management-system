package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.InventoryRoom;
import de.fhdo.warehouseMgmtSys.service.InventoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class InventoryRoomGraphQlController {

    private final InventoryRoomService inventoryRoomService;

    @Autowired
    public InventoryRoomGraphQlController(InventoryRoomService inventoryRoomService) {
        this.inventoryRoomService = inventoryRoomService;
    }

    @QueryMapping("inventories")
    public List<InventoryRoom> getInventories() {
        return inventoryRoomService.getAllInventories();
    }

    @QueryMapping("inventory")
    public Optional<InventoryRoom> getInventory(@Argument Long id) {
        return inventoryRoomService.getInventoryById(id);
    }

    @MutationMapping
    public InventoryRoom createInventory(@Argument InventoryRoom inventory) {
        return inventoryRoomService.createInventory(inventory);
    }

    @MutationMapping
    public Optional<InventoryRoom> updateInventory(@Argument Long id, @Argument InventoryRoom inventory) {
        return inventoryRoomService.updateInventoryById(id,inventory);
    }

    @MutationMapping
    public boolean deleteInventory(@Argument Long id) {
        return inventoryRoomService.deleteInventoryById(id);
    }
}
