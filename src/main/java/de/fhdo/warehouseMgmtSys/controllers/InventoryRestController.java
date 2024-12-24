package de.fhdo.warehouseMgmtSys.controllers;

import de.fhdo.warehouseMgmtSys.converters.InventoryConverter;
import de.fhdo.warehouseMgmtSys.dto.InventoryDto;
import de.fhdo.warehouseMgmtSys.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventory")
public class InventoryRestController {
    private final InventoryService inventoryService;


    public InventoryRestController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Get all inventories
    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory() {
        List<InventoryDto> inventoryDtos = inventoryService.getAllInventories()
                .stream().map(InventoryConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(inventoryDtos);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable Long id) {

        return inventoryService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new inventory
    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto) {
        var inventory = InventoryConverter.toEntity(inventoryDto);
        var savedInventory = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(InventoryConverter.toDto(savedInventory), HttpStatus.CREATED);

    }

    // Update an inventory
    @PutMapping("/{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable long id,
                                                        @RequestBody InventoryDto inventoryDto) {
        var inventory = InventoryConverter.toEntity(inventoryDto);
        var updatedInventory = inventoryService.updateInventoryById(id, inventory);
        return updatedInventory.map(value -> ResponseEntity.ok(InventoryConverter.toDto(value)))
                .orElse(ResponseEntity.notFound().build());

    }

    // Delete an inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryDto> deleteInventory(@PathVariable long id) {
        if(inventoryService.deleteInventoryById(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }




}
