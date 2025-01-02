package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.Item;
import de.fhdo.warehouseMgmtSys.service.ItemService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemGraphQlController {
    private final ItemService itemService;

    public ItemGraphQlController(ItemService itemService) {
        this.itemService = itemService;
    }

    @QueryMapping("items")
    public List<Item> getAllItems() {
        return this.itemService.getAllItems();
    }

    @QueryMapping("item")
    public Optional<Item> getItemById(@Argument Long id) {
        return itemService.getItemById(id);
    }

    @MutationMapping
    public Item createItem(@Argument Item item) {
        return this.itemService.createItem(item);
    }


}
