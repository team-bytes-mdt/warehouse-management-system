package de.fhdo.warehouseMgmtSys.controllers;

import de.fhdo.warehouseMgmtSys.converters.InventoryConverter;
import de.fhdo.warehouseMgmtSys.dto.InventoryDto;
import de.fhdo.warehouseMgmtSys.service.InventoryService;
import de.fhdo.warehouseMgmtSys.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;


    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

    }

    @GetMapping
    public String getAllInventory(Model model) {
        // Fetch all inventories and convert them to DTOs
        List<InventoryDto> inventoryDtos = inventoryService.getAllInventories()
                .stream()
                .map(InventoryConverter::toDto)
                .collect(Collectors.toList());

        System.out.println("List::::"+inventoryDtos);
        // Add DTOs to the model
        model.addAttribute("inventories",inventoryDtos);
        return "inventories";
    }


}
