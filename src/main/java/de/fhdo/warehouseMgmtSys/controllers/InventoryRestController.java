package de.fhdo.warehouseMgmtSys.controllers;

import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryRestController {
    private final InventoryService inventoryService;


    public InventoryRestController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventories();
    }


}
