package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class InventoryGraphQlController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryGraphQlController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @QueryMapping("inventories")
    public List<Inventory> getInventories() {
        return inventoryService.getAllInventories();
    }

    @QueryMapping("inventory")
    public Optional<Inventory> getInventory(@Argument Long id) {
        return inventoryService.getInventoryById(id);
    }

    @MutationMapping
    public Inventory createInventory(@Argument Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }
}
