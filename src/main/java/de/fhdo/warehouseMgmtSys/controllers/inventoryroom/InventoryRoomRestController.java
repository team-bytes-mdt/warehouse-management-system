package de.fhdo.warehouseMgmtSys.controllers.inventoryroom;

import de.fhdo.warehouseMgmtSys.converters.InventoryConverter;
import de.fhdo.warehouseMgmtSys.dto.InventoryRoomDto;
import de.fhdo.warehouseMgmtSys.service.InventoryRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/inventory")
public class InventoryRoomRestController {
    private final InventoryRoomService inventoryRoomService;


    public InventoryRoomRestController(InventoryRoomService inventoryRoomService) {
        this.inventoryRoomService = inventoryRoomService;
    }

    // Get all inventories
    @GetMapping
    public ResponseEntity<List<InventoryRoomDto>> getAllInventory() {
        List<InventoryRoomDto> inventoryRoomDtos = inventoryRoomService.getAllInventories()
                .stream().map(InventoryConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(inventoryRoomDtos);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<InventoryRoomDto> getInventoryById(@PathVariable Long id) {

        return inventoryRoomService.getInventoryById(id)
                .map(InventoryConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new inventory
    @PostMapping
    public ResponseEntity<InventoryRoomDto> createInventory(@RequestBody InventoryRoomDto inventoryRoomDto) {
        var inventory = InventoryConverter.toEntity(inventoryRoomDto);
        var savedInventory = inventoryRoomService.createInventory(inventory);
        return new ResponseEntity<>(InventoryConverter.toDto(savedInventory), HttpStatus.CREATED);

    }

    // Update an inventory
    @PutMapping("/{id}")
    public ResponseEntity<InventoryRoomDto> updateInventory(@PathVariable long id,
                                                            @RequestBody InventoryRoomDto inventoryRoomDto) {
        var inventory = InventoryConverter.toEntity(inventoryRoomDto);
        var updatedInventory = inventoryRoomService.updateInventoryById(id, inventory);
        return updatedInventory.map(value -> ResponseEntity.ok(InventoryConverter.toDto(value)))
                .orElse(ResponseEntity.notFound().build());

    }

    // Delete an inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryRoomDto> deleteInventory(@PathVariable long id) {
        if(inventoryRoomService.deleteInventoryById(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }




}
