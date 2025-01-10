package de.fhdo.warehouseMgmtSys.controllers.item;

import de.fhdo.warehouseMgmtSys.converters.ItemConverter;
import de.fhdo.warehouseMgmtSys.dto.ItemDto;
import de.fhdo.warehouseMgmtSys.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> itemDtos = itemService.getAllItems()
                .stream().map(ItemConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemDtos);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {

        return itemService.getItemById(id)
                .map(ItemConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new inventory
    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        var item = ItemConverter.toEntity(itemDto);
        var savedInventory = itemService.createItem(item);
        return new ResponseEntity<>(ItemConverter.toDto(savedInventory), HttpStatus.CREATED);

    }

    // Update an inventory
    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable long id,
                                                        @RequestBody ItemDto itemDto) {
        var item = ItemConverter.toEntity(itemDto);
        var updatedInventory = itemService.updateItemById(id, item);
        return updatedInventory.map(value -> ResponseEntity.ok(ItemConverter.toDto(value)))
                .orElse(ResponseEntity.notFound().build());

    }

    // Delete an inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable long id) {
        if(itemService.deleteItemById(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
