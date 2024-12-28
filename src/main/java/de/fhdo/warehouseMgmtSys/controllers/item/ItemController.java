package de.fhdo.warehouseMgmtSys.controllers.item;

import de.fhdo.warehouseMgmtSys.converters.ItemConverter;
import de.fhdo.warehouseMgmtSys.domain.Item;
import de.fhdo.warehouseMgmtSys.dto.ItemDto;
import de.fhdo.warehouseMgmtSys.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public String getAllItems(Model model) {
        // Fetch all Items and convert them to DTOs
        List<ItemDto> items = itemService.getAllItems()
                .stream()
                .map(ItemConverter::toDto)
                .collect(Collectors.toList());

        // Add DTO to the model
        model.addAttribute("items", items);
        return "item/items";
    }

    @GetMapping("/{id}")
    public String getItemById(Model model, @PathVariable long id) {
        // Fetch item and convert it to DTO
        ItemDto item = itemService.getItemById(id)
                .map(ItemConverter::toDto)
                .orElse(null);

        // Add DTO to the model
        model.addAttribute("item", item);
        return "item/item";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new ItemDto());
        return "item/create-item";
    }

    @PostMapping
    public String createItem(@ModelAttribute ItemDto itemDto) {
        Item item = ItemConverter.toEntity(itemDto);
        itemService.createItem(item);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable long id) {
        ItemDto item = itemService.getItemById(id)
                .map(ItemConverter::toDto)
                .orElse(null);
        model.addAttribute("item", item);
        return "item/edit-item";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable long id, @ModelAttribute ItemDto itemDto) {
        Item item = ItemConverter.toEntity(itemDto);
        itemService.updateItemById(id, item);
        return "redirect:/items";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }
}
