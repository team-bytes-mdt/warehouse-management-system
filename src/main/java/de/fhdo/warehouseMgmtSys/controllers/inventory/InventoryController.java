package de.fhdo.warehouseMgmtSys.controllers.inventory;

import de.fhdo.warehouseMgmtSys.converters.InventoryConverter;
import de.fhdo.warehouseMgmtSys.domain.Inventory;
import de.fhdo.warehouseMgmtSys.dto.InventoryDto;
import de.fhdo.warehouseMgmtSys.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "inventory/inventories";
    }



    @GetMapping("/{id}")
    public String getInventoryById(Model model, @PathVariable long id) {
        // Fetch item and convert it to DTO
        InventoryDto inventory = inventoryService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .orElse(null);

        // Add DTO to the model
        model.addAttribute("inventory", inventory);
        return "inventory/inventory";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("inventory", new InventoryDto());
        return "create-inventory";
    }

    @PostMapping
    public String createInventory(@ModelAttribute InventoryDto inventoryDto) {
        Inventory inventory = InventoryConverter.toEntity(inventoryDto);
        inventoryService.createInventory(inventory);
        return "redirect:/inventory";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable long id) {
        InventoryDto inventoryDto = inventoryService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .orElse(null);
        model.addAttribute("inventory", inventoryDto);
        return "inventory/edit-inventory";
    }

    @PostMapping("/update/{id}")
    public String updateInventory(@PathVariable long id, @ModelAttribute InventoryDto inventoryDto) {
        System.out.println("DATEEEEEEE PATH"+inventoryDto.getLastUpdatedDate());
        Inventory inventory = InventoryConverter.toEntity(inventoryDto);

        System.out.println("Invent::"+inventory.getLocation());
        inventoryService.updateInventoryById(id, inventory);
        return "redirect:/inventory";
    }

    @PostMapping("/delete/{id}")
    public String deleteInventory(@PathVariable long id) {
        inventoryService.deleteInventoryById(id);
        return "redirect:/inventory";
    }


}
