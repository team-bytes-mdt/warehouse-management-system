package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.domain.Item;
import de.fhdo.warehouseMgmtSys.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;



    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Item Service methods (Functional Requirements)
     */
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {

        return itemRepository.save(item);
    }

    public Optional<Item> updateItemById(long id, Item item) {
        return itemRepository.findById(id).map(existing -> {
            existing.setName(item.getName());
            existing.setDescription(item.getDescription());
            existing.setPrice(item.getPrice());
            existing.setQuantity(item.getQuantity());
            existing.setCategory(item.getCategory());
            return itemRepository.save(existing);
        });

    }

    public boolean deleteItemById(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Object getStockLevels(long id) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            return String.format("Stock level for item ID %d is %d.", id, existingItem.getQuantity());
        }
        return String.format("Item with ID %d not found.", id);
    }

    public String trackStockLevels(long id, int quantity) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            int newQuantity = existingItem.getQuantity() + quantity;
            existingItem.setQuantity(newQuantity);
            itemRepository.save(existingItem);
            return String.format("Stock level for item ID %d increased by %d. New stock: %d", id, quantity, newQuantity);
        }
        return String.format("Item with ID %d not found.", id);
    }
}
