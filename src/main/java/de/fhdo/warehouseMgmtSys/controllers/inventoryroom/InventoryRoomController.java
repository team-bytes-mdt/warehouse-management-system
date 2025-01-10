package de.fhdo.warehouseMgmtSys.controllers.inventoryroom;

import de.fhdo.warehouseMgmtSys.converters.InventoryConverter;
import de.fhdo.warehouseMgmtSys.domain.InventoryRoom;
import de.fhdo.warehouseMgmtSys.dto.InventoryRoomDto;
import de.fhdo.warehouseMgmtSys.service.InventoryRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/inventory")
public class InventoryRoomController {
    private final InventoryRoomService inventoryRoomService;


    public InventoryRoomController(InventoryRoomService inventoryRoomService) {
        this.inventoryRoomService = inventoryRoomService;

    }

    @GetMapping
    public String getAllInventory(Model model) {
        // Fetch all inventories and convert them to DTOs
        List<InventoryRoomDto> inventoryRoomDtos = inventoryRoomService.getAllInventories()
                .stream()
                .map(InventoryConverter::toDto)
                .collect(Collectors.toList());

        System.out.println("List::::"+ inventoryRoomDtos);
        // Add DTOs to the model
        model.addAttribute("inventories", inventoryRoomDtos);
        return "inventory/inventories";
    }



    @GetMapping("/{id}")
    public String getInventoryById(Model model, @PathVariable long id) {
        // Fetch item and convert it to DTO
        InventoryRoomDto inventory = inventoryRoomService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .orElse(null);

        // Add DTO to the model
        model.addAttribute("inventory", inventory);
        return "inventory/inventory";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("inventory", new InventoryRoomDto());
        return "create-inventory";
    }

    @PostMapping
    public String createInventory(@ModelAttribute InventoryRoomDto inventoryRoomDto) {
        InventoryRoom inventory = InventoryConverter.toEntity(inventoryRoomDto);
        inventoryRoomService.createInventory(inventory);
        return "redirect:/inventory";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable long id) {
        InventoryRoomDto inventoryRoomDto = inventoryRoomService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .orElse(null);
        model.addAttribute("inventory", inventoryRoomDto);
        return "inventory/edit-inventory";
    }

    @PostMapping("/update/{id}")
    public String updateInventory(@PathVariable long id, @ModelAttribute InventoryRoomDto inventoryRoomDto) {
        System.out.println("DATEEEEEEE PATH"+ inventoryRoomDto.getLastUpdatedDate());
        InventoryRoom inventory = InventoryConverter.toEntity(inventoryRoomDto);

        System.out.println("Invent::"+inventory.getLocation());
        inventoryRoomService.updateInventoryById(id, inventory);
        return "redirect:/inventory";
    }

    @PostMapping("/delete/{id}")
    public String deleteInventory(@PathVariable long id) {
        inventoryRoomService.deleteInventoryById(id);
        return "redirect:/inventory";
    }


}
