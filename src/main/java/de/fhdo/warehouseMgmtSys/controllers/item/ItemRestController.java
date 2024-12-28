package de.fhdo.warehouseMgmtSys.controllers.item;

import de.fhdo.warehouseMgmtSys.converters.ItemConverter;
import de.fhdo.warehouseMgmtSys.dto.ItemDto;
import de.fhdo.warehouseMgmtSys.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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


}
