package de.fhdo.warehouseMgmtSys.controllers;

import de.fhdo.warehouseMgmtSys.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public String getAllInventory(Model model) {
        model.addAttribute("inventories",inventoryService.getAllInventories());
        return "inventories";
    }

    @GetMapping("/items")
    public String getAllItems(Model model) {
        model.addAttribute("items",inventoryService.getAllItems());
        return "items";
    }
}
